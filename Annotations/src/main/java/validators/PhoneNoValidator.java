package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNoValidator  implements Validator<String>{
	
	public static final Pattern phoNo = Pattern.compile("(^$|[0-9]{10})");

	@Override
	public boolean isValid(String no) {
		Matcher matcher = phoNo.matcher(no);
        return matcher.find();
	}
	
}
