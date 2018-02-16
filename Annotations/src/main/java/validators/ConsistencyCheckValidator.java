package validators;

import java.lang.reflect.Field;

import model.DocumentType;

public class ConsistencyCheckValidator {

	@SuppressWarnings("unused")
	private String baseField;
	private String matchField;
	Class<? extends DocumentType> matchClass;

	@SuppressWarnings("unchecked")
	public void initialize(String baseField, Object obj, String matchField) {
		this.baseField = baseField;
		this.matchField = matchField;
		this.matchClass = (Class<? extends DocumentType>) obj;

	}

	public boolean validate(String baseField, DocumentType doc) {
		try {
			Object matchFieldValue = getFieldValue(doc, matchField);
			return baseField != null && baseField.equals(matchFieldValue);
		} catch (Exception e) {
			return false;
		}
	}

	private Object getFieldValue(Object obj, String fieldName) throws NoSuchFieldException, IllegalAccessException {
		Class<?> clazz = obj.getClass();
		Field matchFied = clazz.getDeclaredField(fieldName);
		matchFied.setAccessible(true);
		return matchFied.get(obj);
	}

}
