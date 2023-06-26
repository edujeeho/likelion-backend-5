package com.example.validation.constraints;

import com.example.validation.constraints.annotations.EmailWhitelist;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.Set;

// 데이터 유효성 검사기
public class EmailWhitelistValidator
        // 사용자 지정 유효성 검사를 위해 구현해야 하는 인터페이스
        implements ConstraintValidator<EmailWhitelist, String> {
    private final Set<String> whiteList;

    public EmailWhitelistValidator() {
        this.whiteList = new HashSet<>();
        this.whiteList.add("gmail.com");
        this.whiteList.add("naver.com");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 유효한 값일 때 true를 반환
        // 유효하지 않은 값일때 false를 반환
        String[] split = value.split("@");
        String domain = split[split.length - 1];
        // Set whiteList에 domain이 추가되어 있는지
        return whiteList.contains(domain);
    }
}
