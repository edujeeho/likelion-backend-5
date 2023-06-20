package com.example.http.dto;

import lombok.Data;

import java.util.List;

@Data
public class ArticleComplexDto {
    private String title;
    private String content;
    private WriterDto writer;
    private List<String> comments;
}
