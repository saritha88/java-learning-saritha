package services;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import annotations.CustomField;
import annotations.Dob;
import annotations.NotNull;
import model.DocumentType;
import validators.FieldValidator;

public class ValidationCheck {
	public static final Logger logger = Logger.getLogger(ValidationCheck.class.getName());

	public static boolean validateEachFieldOverAnnotation(List<DocumentType> documents) throws IllegalAccessException {
		boolean valid = false;
		for (DocumentType doc : documents) {

			Field[] fields = doc.getClass().getDeclaredFields();
			for (Field field : fields) {

				field.setAccessible(true);
				Annotation[] annotations = field.getAnnotations();

				for (Annotation ann : annotations) {
					valid = triggerAnnotationBasedValidation(doc, field, ann);
					if (!valid)
						return false;
				}

			}
			valid = (valid) ? true : false;
		}

		return valid;
	}

	private static boolean triggerAnnotationBasedValidation(DocumentType doc, Field field, Annotation ann)
			throws IllegalAccessException {

		boolean check = true;
		if (ann instanceof NotNull) {
			check =  notNullValidation(doc, field,ann);
		}
		if (ann instanceof CustomField) {
			check = check && fielldValidation(doc, field, ann);
		}
		if (ann instanceof Dob) {
			check = check && dobValidation(doc, field, ann);
		}

		return check;
	}

	private static boolean fielldValidation(DocumentType doc, Field field, Annotation ann)
			throws IllegalAccessException {
		Object name = field.get(doc);
		FieldValidator validator = new FieldValidator();
		CustomField annotation = (CustomField) ann;
		String message=((CustomField) ann).message();
		if (!validator.isValid(annotation.value(), name.toString())) {
			logger.log(Level.SEVERE, message);
			return false;
		}
		return true;
	}
	private static boolean dobValidation(DocumentType doc, Field field, Annotation ann) throws IllegalAccessException {
		LocalDate dob = (LocalDate) field.get(doc);
		
		if (dob.isAfter(((Dob) ann).maxDate) || dob.isBefore(((Dob) ann).minDate)) {
			logger.log(Level.SEVERE, "Invalid date");
			return false;
		}
		return true;
	}

	private static boolean notNullValidation(DocumentType doc, Field field, Annotation ann) throws IllegalAccessException {
		if (field.get(doc) == null || field.get(doc).toString().isEmpty()) {
			String message=((NotNull) ann).message();
			logger.log(Level.SEVERE,message);
			return false;
		}
		return true;
	}

}
