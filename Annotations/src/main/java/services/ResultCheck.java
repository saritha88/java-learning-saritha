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

public class ResultCheck {

	public static final Logger logger = Logger.getLogger(ResultCheck.class.getName());

	public static void main(String[] args) throws IllegalAccessException {

		LocalDate date = LocalDate.of(1988,06,19);
		PanCard pan = new PanCard("sarithab", "ALTPB0854F", date);
		AdhaarCard aadhaar = new AdhaarCard("sarithab", 867478704875L, date,"saritha.bolla@gmail.com", "9949711160");
		BankStatement statement = new BankStatement("sarithab", 4565656L, date,"saritha.bolla@gmail.com", "9949711160");
		List<DocumentType> documents = new ArrayList<>();
		documents.add(pan);
		documents.add(aadhaar);
		documents.add(statement);
		checkAllAreDocuments(documents);

	}

	public static boolean checkAllAreDocuments(List<DocumentType> documents) throws IllegalAccessException {

		Map<String, DocumentType> docs = new HashMap<>();
		for (DocumentType doc : documents) {

			if (doc.getClass().isAnnotationPresent(annotations.Document.class)) {
				docs.put(doc.getClass().getSimpleName(), doc);
			}
		}
		if (docs.size() != documents.size()) {
			logger.log(Level.SEVERE, "Missing @Document in some class");
			return false;
		} else {

			if (ValidationCheck.validateEachDocument(documents)) {
				validateConsistency(docs, documents);
			}
		}

		return true;

	}

	private static void validateConsistency(Map<String, DocumentType> map, List<DocumentType> documents)
			throws IllegalAccessException {
		for (DocumentType doc : documents) {
			Field[] fields = doc.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				if (field.isAnnotationPresent(ConsistencyCheck.class)) {
					Annotation ann = field.getDeclaredAnnotation(ConsistencyCheck.class);
					ConsistencyCheck myAnnotation = (ConsistencyCheck) ann;
					Object o = field.get(doc);
					ConsistencyCheckValidator cvs = new ConsistencyCheckValidator();
					cvs.initialize(o.toString(), myAnnotation.matchClass(), myAnnotation.matchField());

					if (cvs.validate(o.toString(), map.get(myAnnotation.matchClass().getSimpleName()))) {

						logger.info("Validation success "+doc.getClass().getName());
					}
				}
			}
		}
	}

}
