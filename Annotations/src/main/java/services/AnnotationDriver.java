package services;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import annotations.ConsistencyCheck;
import model.AdhaarCard;
import model.BankStatement;
import model.DocumentType;
import model.PanCard;
import validators.ConsistencyCheckValidator;

public class AnnotationDriver {

	public static final Logger logger = Logger.getLogger(AnnotationDriver.class.getName());

	public static void main(String[] args) throws IllegalAccessException {

		LocalDate date = LocalDate.of(1988, 06, 19);
		PanCard pan = new PanCard("sarithab", "ALTPB0854F", date);
		AdhaarCard aadhaar = new AdhaarCard("sarithab", 867478704875L, date, "saritha.bolla@gmail.com", "9949711160");
		BankStatement statement = new BankStatement("sarithab", 4565656L, date, "saritha.bolla@gmail.com",
				"9949711160");
		List<DocumentType> documents = new ArrayList<>();

		documents.add(pan);
		documents.add(aadhaar);
		documents.add(statement);
		if (isAllAreDocuments(documents)) {
			if (ValidationCheck.validateEachFieldOverAnnotation(documents)) {
				Map<String, DocumentType> map = getMapOfDocuments(documents);
				validateConsistency(map);
			}
		}

	}

	// Checking wheather all documnets fall under valid Document category
	public static boolean isAllAreDocuments(List<DocumentType> documents) {

		for (DocumentType doc : documents) {

			if (!doc.getClass().isAnnotationPresent(annotations.Document.class)) {
				logger.log(Level.SEVERE, "Missing @Document in some class " + doc.getClass().getSimpleName());
				return false;
			}
		}
		return true;

	}

	private static Map<String, DocumentType> getMapOfDocuments(List<DocumentType> documents) {
		Map<String, DocumentType> map = new HashMap<>();

		for (DocumentType doc1 : documents) {
			map.put(doc1.getClass().getSimpleName(), doc1);
		}
		return map;
	}

	private static void validateConsistency(Map<String, DocumentType> map) throws IllegalAccessException {
		for (String key : map.keySet()) {
			DocumentType doc = map.get(key);
			Field[] fields = doc.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				if (field.isAnnotationPresent(ConsistencyCheck.class)) {
					Annotation ann = field.getDeclaredAnnotation(ConsistencyCheck.class);
					ConsistencyCheck myAnnotation = (ConsistencyCheck) ann;
					Object o = field.get(doc);
					ConsistencyCheckValidator cvs = new ConsistencyCheckValidator();

					if (cvs.validate(o.toString(), map.get(myAnnotation.matchClass().getSimpleName()),
							myAnnotation.matchField())) {

						logger.info("Validation success " + doc.getClass().getName());
					}
				}
			}
		}
	}

}
