package com.example.app.entity;

import com.example.app.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne // 해당 댓글 엔티티가 여러개가 하나의 아티클에 연관된다.
    @JoinColumn(name = "article_id") // "article_id" 컬럼에 article의 대표값 지정
    private Article article;
    @Column
    private String nickname;
    @Column
    private String body;

    public static Comment createComment(CommentDto dto, Article article) {
        // 예외 발생
        if (dto.getId() != null) {
             throw new IllegalArgumentException("댓글 생성 실패! ID 값이 없어야합니다.");
        }
        if (dto.getArticleId() != article.getId()) {
            throw new IllegalArgumentException("댓글 생성 실패! 게시글의 ID 값이 잘못되었습니다.");
        }
        // 엔티티 생성 및 반환
        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );
    }

    public void patch(CommentDto dto) {
        // 예외 발생
        if (this.id != dto.getId()) {
            throw new IllegalArgumentException("댓글 수정 실패");
        }
        // 객체 갱신
        if (this.nickname != dto.getNickname()){
            this.nickname = dto.getNickname();
        }
        if (this.body != dto.getBody()) {
            this.body = dto.getBody();
        }
    }
}
