package com.example.jpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
// Audit: 감시하다.
// 이 어노테이션이 추가된 설정 (Configuration)이 있을 때
// 객체의 생성 및 수정 시각을 기록할 수 있다.
@EnableJpaAuditing
public class JpaConfig {}
