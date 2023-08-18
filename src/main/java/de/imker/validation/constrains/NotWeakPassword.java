package de.imker.validation.constrains;

import de.imker.validation.validators.PasswordValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface NotWeakPassword {

  String message() default "must be strong";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
