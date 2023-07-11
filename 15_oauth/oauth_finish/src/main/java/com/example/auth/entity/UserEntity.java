package com.example.auth.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
// 단순 아이디 비밀번호 외에 소셜 로그인을 통해 계정을 생성해보자.
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // DB 제약사항 추가
    @Column(nullable = false, unique = true)
    private String username;
    private String password;

    private String email;
    private String phone;

    // Naver, Kakao 등 소셜 로그인 제공자 문자값
    private String provider;
    // Naver, Kakao 등에서 사용자를 식별하기 위해 제공한 값
    private String providerId;
}
