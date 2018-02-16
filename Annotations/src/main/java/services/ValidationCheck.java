package services;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import annotations.Dob;
import annotations.Email;
import annotations.Name;
import annotations.NotNull;
import annotations.PhoneNo;
import model.DocumentType;
import validators.DateValidator;
import validators.EmailValidator;
import validators.NameValidator;
import validators.PhoneNoValidator;

public class ValidationCheck {
	public static final Logger logger = Logger.getLogger(ValidationCheck.class.getName());

	static boolean  validateEachDocument(List<DocumentType> documents) throws IllegalAccessException {
		boolean valid = false;
		for (DocumentType doc : documents) {

			Field[] fields = doc.getClass().getDeclaredFields();
			for (Field field : fields) {

				field.setAccessible(true);
				Annotation[] annotations = field.getAnnotations();
				
				for (Annotation ann : annotations) {
					valid = triggerAnnotationBasedValidation(doc, field, ann);
					if(!valid) return false;
			}
				
		}
		valid = (valid) ? true : false;
	}
		
		
		return valid;
	}
	private static  boolean triggerAnnotationBasedValidation(DocumentType doc, Field field, Annotation ann)
			throws IllegalAccessException {
		
		boolean check=true;
		if (ann instanceof NotNull) {
			check=check && notNullValidation(doc, field);
		} 
		 if (ann instanceof Name) {
			check=check && nameValidation(doc, field, ann);
		} 
		 if (ann instanceof Dob) {
			check=check && dobValidation(doc, field);
		} 
		 if (ann instanceof PhoneNo) {
			check=check && phoneNumberValidation(doc, field, ann);
		} 
		 if (ann instanceof Email) {
			check=check && emailValidation(doc, field);
		}
return check;
	}

	private static boolean nameValidation(DocumentType doc, Field field, Annotation ann) throws IllegalAccessException {

		Object name = field.get(doc);
		NameValidator e = new NameValidator();
		if (!e.isValid(name.toString())) {
			logger.log(Level.SEVERE, "Name should be atleast of 8 characters" + doc.getClass().getName());
			return false;
		}
		return true;
	}

	private static boolean emailValidation(DocumentType doc, Field field) throws IllegalAccessException {
		Object email = field.get(doc);
		EmailValidator e = new EmailValidator();
		if (!e.isValid(email.toString())) {
			logger.log(Level.SEVERE, "Invalid email" + doc.getClass().getName());
			return false;
		}
		return true;
	}

	private static boolean phoneNumberValidation(DocumentType doc, Field field, Annotation ann)
			throws IllegalAccessException {
		Object no = field.get(doc);
		PhoneNoValidator ph = new PhoneNoValidator();

		if (!(ph.isValid(no.toString()))) {
			logger.log(Level.SEVERE, "Not a valid number");
			return false;
		}
		return true;

	}

	private static boolean dobValidation(DocumentType doc, Field field) throws IllegalAccessException {
		Object dob = field.get(doc);
		DateValidator d=new DateValidator();
		if (!d.isValid(dob.toString())) {
			logger.log(Level.SEVERE, "Invalid date format");
			return false;
		}
		return true;
	}

	private static boolean notNullValidation(DocumentType doc, Field field) throws IllegalAccessException {
		if (field.get(doc) == null || field.get(doc).toString().isEmpty()) {
			logger.log(Level.SEVERE, "Field cannot be null or empty");
			return false;
		}
		return true;
	}

}
