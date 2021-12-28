package com.example.app.service;

import com.example.app.dto.CommentDto;
import com.example.app.entity.Article;
import com.example.app.entity.Comment;
import com.example.app.repository.ArticleRepository;
import com.example.app.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;


    public List<CommentDto> comments(Long articleId) {
        // 조회 : 목록
//        List<Comment> comments = commentRepository.findByArticleId(articleId);
        // 변환 : 엔티티 -> Dto
//        List<CommentDto> dtos = new ArrayList<CommentDto>();
//        for (int i = 0; i< comments.size(); i++){
//            Comment c = comments.get(i);
//            CommentDto dto = CommentDto.createCommentDto(c);
//            dtos.add(dto);
//        }
        // 반환
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDto createComment(Long articleId, CommentDto dto) {
        // 게시글 조회 및 예외 처리
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패"));
        // 댓글 엔티티 생성
        Comment comment = Comment.createComment(dto, article);
        // 댓글 엔티티 DB 저장
        Comment created = commentRepository.save(comment);
        // DTO로 변경하여 반환
        return CommentDto.createCommentDto(created);
    }

    @Transactional
    public CommentDto updateComment(Long id, CommentDto dto) {
        // 댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("댓글 업데이트 실패"));
        // 댓글 수정
        target.patch(dto);
        // 디비 갱신
        Comment updated = commentRepository.save(target);
        // DTO로 변환하여 반환
        return CommentDto.createCommentDto(updated);
    }

    @Transactional
    public CommentDto deleteComment(Long id) {

        Comment target = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패"));

        commentRepository.delete(target);

        return CommentDto.createCommentDto(target);
    }
}
