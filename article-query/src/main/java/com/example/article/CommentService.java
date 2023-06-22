package com.example.article;

import com.example.article.dto.CommentDto;
import com.example.article.entity.CommentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public CommentDto createComment(Long articleId, CommentDto dto) {
        // articleId를 ID로 가진 ArticleEntity 가 존재 하는지?
        if (!articleRepository.existsById(articleId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);  // 자유롭게 상황대처

        CommentEntity newComment = new CommentEntity();
        newComment.setWriter(dto.getWriter());
        newComment.setContent(dto.getContent());
        newComment.setArticleId(articleId);
        newComment = commentRepository.save(newComment);
        return CommentDto.fromEntity(newComment);
    }

    // 반환 타입 이름 인자
    public List<CommentDto> readCommentAll(Long articleId) {
        List<CommentEntity> commentEntities
                = commentRepository.findAllByArticleId(articleId);
        List<CommentDto> commentList = new ArrayList<>();
        for (CommentEntity entity: commentEntities) {
            commentList.add(CommentDto.fromEntity(entity));
        }

        return commentList;
    }

    // 수정하고자 하는 댓글이 지정한 게시글에 있는지 확인할 목적으로
    // articleId도 첨부한다.
    public CommentDto updateComment(
            Long articleId,
            Long commentId,
            CommentDto dto
    ) {
        // 요청한 댓글이 존재하는지
        Optional<CommentEntity> optionalComment
                = commentRepository.findById(commentId);
        // 존재하지 않으면 예외 발생
        if (optionalComment.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        // 아니면 로직 진행
        CommentEntity comment = optionalComment.get();

        // 대상 댓글이 대상 게시글의 댓글이 맞는지
        if (!articleId.equals(comment.getArticleId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        comment.setContent(dto.getContent());
        comment.setWriter(dto.getWriter());
        return CommentDto.fromEntity(commentRepository.save(comment));
    }

    // deleteComment() 자유롭게 만들기
    public void deleteComment(Long articleId, Long commentId) {
        Optional<CommentEntity> optionalComment
                = commentRepository.findById(commentId);
        if (optionalComment.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        CommentEntity comment = optionalComment.get();
        if (!articleId.equals(comment.getArticleId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        commentRepository.deleteById(commentId);
    }
}










