package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;
import java.util.Locale;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Dob {

	String message() default "invalid date";
	LocalDate minDate=LocalDate.of(1980, 01, 01);
	LocalDate maxDate=LocalDate.of(2030, 01, 01);


}
