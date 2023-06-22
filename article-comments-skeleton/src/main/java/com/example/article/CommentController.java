package com.example.article;

import com.example.article.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService service;

    public void create() {}

    public void readAll() {}

    public void update() {}

    public void delete() {}
}
