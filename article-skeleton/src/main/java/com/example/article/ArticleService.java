package com.example.article;

import com.example.article.dto.ArticleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository repository;

    public ArticleDto createArticle(ArticleDto dto) {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    public ArticleDto readArticle(Long id) {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    public List<ArticleDto> readArticleAll() {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    public ArticleDto updateArticle(Long id, ArticleDto dto) {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    public void deleteArticle(Long id) {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }
}
