package com.example.app.entity;

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
}
