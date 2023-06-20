package com.example.http.dto;

import lombok.Data;

import java.util.List;

// 블로그 게시글
// 게시글 - 제목
// 게시글 - 내용
/*
{
   "title": "제목",
   "content": "content"
}
* */
@Data
public class ArticleWithCommentsDto {
    private String title;
    private String content;
    private String writer;
    private List<String> comments;
}
