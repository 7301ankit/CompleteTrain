package com.TotalWork.CompleteTraining.validation;


import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordValidation  implements ConstraintValidator<Password,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(6, 30),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.Special, 1),
                new WhitespaceRule()

        ));
        RuleResult result=validator.validate(new PasswordData(s));
        if(result.isValid()){

          return true;
        }
        List<String> message=validator.getMessages(result);
        String messageTemplate = message.stream().collect(Collectors.joining(","));
        System.out.println("messageTemplate");
        return false;
    }
}
