package validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator  implements Validator<String>{

	@Override
	public boolean isValid(String val) {
		
        return isValidFormat("yyyy/MM/dd", val);
	}

	 private static boolean isValidFormat(String format, String value) {
	        Date date = null;
	        try {
	            SimpleDateFormat sdf = new SimpleDateFormat(format);
	            if (value != null){
	                date = sdf.parse(value);
	                if (!value.equals(sdf.format(date))) {
	                    date = null;
	                }
	            }

	        } catch (ParseException ex) {
	        }
	        return date != null;
}
}
