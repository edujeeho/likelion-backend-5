package com.example.validation.constraints.annotations;

import com.example.validation.constraints.Phone010Validator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Phone010 가 붙은 필드는
// 유효성 검사 시
// (010) 또는 010- 으로 시작해야 한다
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Phone010Validator.class)
public @interface Phone010 {
    // Annotation Element
    String message() default "010으로 시작하지 않음";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
