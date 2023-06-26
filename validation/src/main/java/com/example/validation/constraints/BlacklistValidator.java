package com.example.validation.constraints;

import com.example.validation.constraints.annotations.Blacklist;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.Set;

public class BlacklistValidator
        implements ConstraintValidator<Blacklist, String> {
    private Set<String> blacklist;
    
    @Override
    public void initialize(Blacklist constraintAnnotation) {
        blacklist = new HashSet<>();
        for (String target: constraintAnnotation.blacklist()) {
            blacklist.add(target);
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // this.blacklist 안에 value 가 있으면 실패
        return !this.blacklist.contains(value);
    }
}
