package com.example.app.repository;

import com.example.app.entity.Article;
import com.example.app.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // JPA 와 연동 테스트
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시물 모든 댓글 조회")
    void findByArticleId() {

        {
            // 입력 데이터 준비
            Long articleId = 4L;

            // 실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            // 예상하기
            Article article = new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ");
            Comment a = new Comment(1L, article, "park", "굿 윌 헌팅");
            Comment b = new Comment(2L, article, "kim", "스파이더맨");
            Comment c = new Comment(3L, article, "saki", "라라랜드");

            List<Comment> expected = Arrays.asList(a, b, c);
            // 검증
            assertEquals(expected.toString(), comments.toString());

        }
        {
            // 입력 데이터 준비
            Long articleId = 1L;
            // 실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            // 예상하기
            Article article = new Article(1L, "가가가가", "1111");
            List<Comment> expected = Arrays.asList();
            // 검증
            assertEquals(expected.toString(), comments.toString());

        }
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        // 입력 데이터 준비
        String nickname = "saki";
        // 실제 수행
        List<Comment> comments = commentRepository.findByNickname(nickname);
        // 예상하기
        Comment a = new Comment(3L, new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ"), nickname, "라라랜드");
        Comment b = new Comment(6L, new Article(5L, "좋아하는 음식은?", "댓글 ㄱㄱ"), nickname, "초밥");
        Comment c = new Comment(9L, new Article(6L, "공부하고 있는 프로그래밍 언어는?", "댓글 ㄱㄲㄱ"), nickname, "자바");

        List<Comment> expected = Arrays.asList(a, b, c);
        // 비교
        assertEquals(expected.toString(), comments.toString());

    }
}