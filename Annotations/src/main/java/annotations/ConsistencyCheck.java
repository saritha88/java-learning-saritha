package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import model.DocumentType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface ConsistencyCheck {

	
	String message() default "{annotations.ConsistencyCheck.message}";

    Class<? extends DocumentType> matchClass();
    String baseField();
    String matchField();

}
