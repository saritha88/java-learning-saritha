package validators;


public class FieldValidator implements Validator<String,String> {
	
	@Override
	public boolean isValid(String t,String str) {
        return  str.matches(t);
	}
	

}
