package com.example.article;

import com.example.article.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findAllByArticleId(Long id);
}
