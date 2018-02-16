package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator implements Validator<String> {
	public static final Pattern NAME_PATTERN = Pattern.compile("^[A-Z]{8,20}$", Pattern.CASE_INSENSITIVE);

	@Override
	public boolean isValid(String name) {
		Matcher matcher = NAME_PATTERN.matcher(name);
		return matcher.find();
	}

}
