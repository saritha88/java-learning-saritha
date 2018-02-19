package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import model.DocumentType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface ConsistencyCheck {
	
	String message() default "{All documents should consists of same Fullname}";

    Class<? extends DocumentType> matchClass();
    String matchField();

}
