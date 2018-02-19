package validators;

import java.lang.reflect.Field;

import model.DocumentType;

public class ConsistencyCheckValidator {

	public boolean validate(String baseField, DocumentType doc,String matchField) {
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
