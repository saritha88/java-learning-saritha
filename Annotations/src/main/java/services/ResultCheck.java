package services;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import annotations.ConsistencyCheck;
import annotations.Dob;
import annotations.Email;
import annotations.NotNull;
import annotations.PhoneNo;
import model.AdhaarCard;
import model.BankStatement;
import model.DocumentType;
import model.PanCard;
import validators.ConsistencyCheckValidator;
import validators.EmailValidator;
import validators.PhoneNoValidator;

public class ResultCheck {
	public static final Logger logger = Logger.getLogger(ResultCheck.class.getName());

	public static void main(String[] args) throws ParseException, IllegalAccessException, NoSuchFieldException {

		Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1988-06-19");
		
		PanCard pan = new PanCard("sariha", "ALTPB0854F", date);
		AdhaarCard aadhaar = new AdhaarCard("saritha", 867478704875L, date, "saritha.bolla@gmail.com", "9949711160");
		BankStatement statement = new BankStatement("saritha", 4565656L, date, "saritha.bolla@gmail.com", "9949711160");
		List<DocumentType> documents = new ArrayList<>();
		documents.add(pan);
		documents.add(aadhaar);
		documents.add(statement);
		checkAllAreDocuments(documents);
		if (!validateType(pan, aadhaar)) {
			logger.log(Level.SEVERE,"consistency check failed for Pan and Aadhaar card" );
			
		} else if (!validateType(statement, aadhaar)) {
			logger.log(Level.SEVERE,"consistency check failed for Bank statement and Aadhaar card" );
			
		}

	}

	private static boolean validateType(DocumentType doc1, DocumentType doc2)
			throws NoSuchFieldException, IllegalAccessException {

		Class<? extends DocumentType> cls = doc1.getClass();
		Annotation[] annotation = cls.getAnnotations();
		for (Annotation ann1 : annotation) {
			if (ann1 instanceof ConsistencyCheck) {
				Field fields = doc1.getClass().getDeclaredField("fullName");
				fields.setAccessible(true);
				Object o = fields.get(doc1);
				String str = o.toString();
				ConsistencyCheck myAnnotation = (ConsistencyCheck) ann1;
				ConsistencyCheckValidator cvs = new ConsistencyCheckValidator();

				cvs.initialize(str, myAnnotation.matchClass(), myAnnotation.matchField());
				if (cvs.validate(str, doc2))
					return true;
			}

		}
		return false;

	}

	public static boolean checkAllAreDocuments(List<DocumentType> documents)
			throws IllegalAccessException {

		List<DocumentType> docs = new ArrayList<>();
		for (DocumentType doc : documents) {

			if (doc.getClass().isAnnotationPresent(annotations.Document.class)) {
				docs.add(doc);
			}
		}
		if (docs.size() != documents.size()) {
			logger.log(Level.SEVERE,"Missing @Document in some class");
			return false;
		} else {
			validateEachDocument(documents);
		}
		return true;
	}

	private static void validateEachDocument(List<DocumentType> documents)
			throws IllegalAccessException {
		for (DocumentType doc : documents) {

			getAllFileds(doc);

		}
	}

	private static void getAllFileds(DocumentType doc) throws IllegalAccessException {
		Field[] fields = doc.getClass().getDeclaredFields();
		for (Field field : fields) {

			validateEachField(doc, field);

		}
	}

	private static void validateEachField(DocumentType doc, Field field) throws IllegalAccessException {
		field.setAccessible(true);
		Annotation[] annotations = field.getAnnotations();

		for (Annotation ann : annotations) {

			triggerAnnotationBasedValidation(doc, field, ann);

		}
	}

	private static void triggerAnnotationBasedValidation(DocumentType doc, Field field, Annotation ann)
			throws IllegalAccessException {
		if (ann instanceof NotNull) {
			notNullValidation(doc, field);
		} else if (ann instanceof Dob) {
			dobValidation(doc, field);
		} else if (ann instanceof PhoneNo) {
			phoneNumberValidation(doc, field, ann);
		} else if (ann instanceof Email) {
			emailValidation(doc, field);
		}
	}

	private static void emailValidation(DocumentType doc, Field field) throws IllegalAccessException {
		Object email = field.get(doc);
		EmailValidator e=new EmailValidator();
		if (!e.isValid(email.toString())) {
			logger.log(Level.SEVERE, "Invalid email" + doc.getClass().getName());
			
		}
	}

	private static void phoneNumberValidation(DocumentType doc, Field field, Annotation ann)
			throws IllegalAccessException {
		Object no = field.get(doc);
       PhoneNoValidator ph=new PhoneNoValidator();
      
       if(!(ph.isValid(no.toString()))|| no.toString().length() > ((PhoneNo) ann).maxLength() || no.toString().length() <((PhoneNo) ann).minLength()) {
    	   logger.log(Level.SEVERE, "Not a valid number");
       }
		
	}

	private static void dobValidation(DocumentType doc, Field field) throws IllegalAccessException {
		Object dob = field.get(doc);
		Date createdDate = (Date) dob;
		if(createdDate.after(new Date())) {
			logger.log(Level.SEVERE, "Date cannot be future date");
		}
	}

	private static void notNullValidation(DocumentType doc, Field field) throws  IllegalAccessException {
		
			if (field.get(doc) == null || field.get(doc).toString().isEmpty()) {
				logger.log(Level.SEVERE,"Field cannot be null or empty");
			}
				

	}

}
