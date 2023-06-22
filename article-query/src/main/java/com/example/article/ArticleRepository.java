package com.example.article;

import com.example.article.entity.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository
        extends JpaRepository<ArticleEntity, Long> {
    // ID가 큰 순서대로 최상위 20개
    List<ArticleEntity> findTop20ByOrderByIdDesc();
    // ID가 특정 값보다 작은 데이터 중 큰 순서대로 최상위 20개
    List<ArticleEntity> findTop20ByIdLessThanOrderByIdDesc(Long id);

    // 제목에 title이 들어가는 article 검사
    Page<ArticleEntity> findAllByTitleContains(
            String title, Pageable pageable);
}
