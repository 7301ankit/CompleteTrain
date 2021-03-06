package com.TotalWork.CompleteTraining.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = EmailValidation.class)
public @interface Email {
 String message()default "enter valid email";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
