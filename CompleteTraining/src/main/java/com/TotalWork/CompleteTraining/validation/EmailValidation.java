package com.TotalWork.CompleteTraining.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation implements ConstraintValidator<Email,String> {
   private String regex="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
           + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Pattern p=Pattern.compile(regex);
    if(s.length()==0){
    System.out.println("enter is empty");
        return false;
    }
        Matcher m=p.matcher(s);
    if(m.matches()==false){
        System.out.println("email invalid");
        return false;
        }
    return true;

    }
}
