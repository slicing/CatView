package com.dharma.spring.validator;

import com.dharma.spring.model.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

public class ProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id","id.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"type","type.required");
    }
}
