package com.example.demojvalidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class PersonValidator implements org.springframework.validation.Validator {

    // javax.validation.Validator
    @Autowired
    private Validator validator;

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Set<ConstraintViolation<Object>> validates = validator.validate(obj);

        for (ConstraintViolation<Object> constraintViolation : validates) {
            String propertyPath = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();
            errors.rejectValue(propertyPath, "", message);
        }

        Person p = (Person) obj;
        try {
            if (p.getAge() < 0) {
                errors.rejectValue("age", "", "only.positive.numbers");
            }
        } catch (NullPointerException ignored) {}

//        if (p.getName().length() == 0) {
//            errors.rejectValue("name", "","only.positive.numbers");
//        }
    }
}