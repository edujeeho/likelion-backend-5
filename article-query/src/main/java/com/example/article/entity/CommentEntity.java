package com.example.article.entity;

/*
id integer primary key autoincrement
writer text
content text
 */

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
    private String writer;
    private String content;
}


