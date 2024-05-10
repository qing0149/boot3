package test17;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotNullOrThrow {
    Class<? extends RuntimeException> exception() default RuntimeException.class;
    String message() default "Value is null.";
}