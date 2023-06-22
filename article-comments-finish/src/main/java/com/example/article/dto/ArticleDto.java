package com.example.article.dto;

import com.example.article.entity.ArticleEntity;
import lombok.Data;

@Data
public class ArticleDto {
    private Long id;
    private String writer;
    private String title;
    private String content;

    public static ArticleDto fromEntity(ArticleEntity entity) {
        ArticleDto dto = new ArticleDto();
        dto.setId(entity.getId());
        dto.setWriter(entity.getWriter());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        return dto;
    }
}
