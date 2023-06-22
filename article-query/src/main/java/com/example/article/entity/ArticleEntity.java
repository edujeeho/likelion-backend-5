package com.example.article.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "articles")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String writer;
    private String title;
    private String content;
}
