package com.example.app.service;

import com.example.app.dto.ArticleForm;
import com.example.app.entity.Article;
import com.example.app.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article created(ArticleForm dto) {
        Article article = dto.toEntity();
        if (article.getId() != null) {
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {
        // 1. 수정용 엔티티 생성
        Article article = dto.toEntity();
        // 2. 대상 엔티티 조회
        Article target = articleRepository.findById(id).orElse(null);
        // 3. 잘못된 요청 처리
        if (target == null || id != article.getId()) {
            return null;
        }
        // 4. 업데이트
        target.patch(article);
        return articleRepository.save(target);

    }

    public Article delete(long id) {
        // 1. 대상 찾기
        Article target = articleRepository.findById(id).orElse(null);
        // 2. 예외 처리
        if (target == null) {
            return null;
        }
        return target;
    }

    @Transactional // 실패 할 경우 롤백
    public List<Article> createArticles(List<ArticleForm> dtos) {
        // 1. dto묶음을 엔티티로 변환
         List<Article> articleList = dtos.stream().map(dto -> dto.toEntity()).collect(Collectors.toList());
        // 2. 엔티티 묶음을 디비로 저장
        articleList.stream().forEach(article -> articleRepository.save(article));
        // 3. 강제 예외 발생
        articleRepository.findById(-1L).orElseThrow(() -> new IllegalArgumentException("실패!~!"));
        // 4. 결과 값 반환
        return articleList;


    }
}
