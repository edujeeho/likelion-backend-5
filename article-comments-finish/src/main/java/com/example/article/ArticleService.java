package com.example.article;

import com.example.article.dto.ArticleDto;
import com.example.article.entity.ArticleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository repository;

    public ArticleDto createArticle(ArticleDto dto) {
//        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
        ArticleEntity newArticle = new ArticleEntity();
        newArticle.setTitle(dto.getTitle());
        newArticle.setContent(dto.getContent());
        newArticle.setWriter(dto.getWriter());
        return ArticleDto.fromEntity(repository.save(newArticle));
    }

    public ArticleDto readArticle(Long id) {
//        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
        Optional<ArticleEntity> optionalArticle
            = repository.findById(id);
        // 채워 넣어 보기
        // optional 안에 Aritcle이 들어있으면
        if (optionalArticle.isPresent())
            // DTO로 전환 후 반환
            return ArticleDto.fromEntity(optionalArticle.get());
        // 아니면 404
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);

//        // 반대 순서
//        if (optionalArticle.isEmpty())
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        return ArticleDto.fromEntity(optionalArticle.get());
    }

    public List<ArticleDto> readArticleAll() {
//        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
        List<ArticleDto> articleList = new ArrayList<>();
        for (ArticleEntity entity: repository.findAll()) {
            articleList.add(ArticleDto.fromEntity(entity));
        }
        return articleList;
    }

    public ArticleDto updateArticle(Long id, ArticleDto dto) {
        // UPDATE
        // ArticleEntity 받아오기
        Optional<ArticleEntity> optionalArticle
                = repository.findById(id);
        // ArticleEntity 가 있을때
        if (optionalArticle.isPresent()) {
            // 전달받은 dto 기준으로 수정
            ArticleEntity article = optionalArticle.get();
            article.setWriter(dto.getWriter());
            article.setTitle(dto.getTitle());
            article.setContent(dto.getContent());
            repository.save(article);
            return ArticleDto.fromEntity(article);
        }
        // 없다면 404
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void deleteArticle(Long id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);

//        // 존재하면
//        Optional<ArticleEntity> optionalArticle
//                = repository.findById(id);
//        if (optionalArticle.isPresent())
//            // 삭제
//            repository.deleteById(id);
//        // 아니면 404
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

//        // 정보 제공 없이 실패하면 조용히 실패
//        repository.deleteById(id);
    }
}










