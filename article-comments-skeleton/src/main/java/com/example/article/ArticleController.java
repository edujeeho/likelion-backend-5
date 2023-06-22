package com.example.article;

import com.example.article.dto.ArticleDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService service;

    @PostMapping
    public ArticleDto create(@RequestBody ArticleDto dto) {
        return service.createArticle(dto);
    }

    @GetMapping
    public List<ArticleDto> readAll() {
        return service.readArticleAll();
    }

    @GetMapping("/{id}")
    public ArticleDto read(@PathVariable("id") Long id) {
        return service.readArticle(id);
    }

    @PutMapping("/{id}")
    public ArticleDto update(@PathVariable("id") Long id, @RequestBody ArticleDto dto) {
        return service.updateArticle(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteArticle(id);
    }
}
