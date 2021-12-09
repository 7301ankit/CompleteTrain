package com.TotalWork.CompleteTraining.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberValidation implements ConstraintValidator<Number,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
       if(s.length()>10){
           System.out.println("this is invalid number");
           return false;
       }
       else{
           return true;
       }
    }
}
