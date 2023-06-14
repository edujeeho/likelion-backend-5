package com.example.jpa.entities;
/*
id
title
content
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// 나만의 엔티티 만들어서 테이블 적용 되는거 꼭 확인
// ArticleEntity 도 괜찮고...
@Entity
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
}
