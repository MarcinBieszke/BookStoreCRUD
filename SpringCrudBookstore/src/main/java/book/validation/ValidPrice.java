package book.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidPriceImp.class)
public @interface ValidPrice {
	
	String message() default "Value must be beetwen 0 and 100";
	Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
