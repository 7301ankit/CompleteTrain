package com.TotalWork.CompleteTraining.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NumberValidation.class)
public @interface Number {
    String message() default "enter valid number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
