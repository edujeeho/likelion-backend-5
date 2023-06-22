package com.example.article;

import com.example.article.dto.CommentDto;
import com.example.article.entity.ArticleEntity;
import com.example.article.entity.CommentEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {

    public CommentDto createComment(Long articleId, CommentDto dto) {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    public List<CommentDto> readCommentAll(Long articleId) {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    public CommentDto updateComment(Long articleId, Long commentId, CommentDto dto) {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    public void deleteComment(Long articleId, Long commentId) {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }
}
