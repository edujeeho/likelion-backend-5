package com.example.article.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long articleId;

//    @ManyToOne
//    private ArticleEntity article;
    private String writer;
    private String content;
}
