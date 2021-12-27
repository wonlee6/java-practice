package com.example.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity // DB가 해당 객체 인식하도록 선언
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Article {

    @Id // 대표 값을 지정 예) 주민등록번호
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성 어노테이션
    private Long id;

    @Column
    private String title;
    @Column
    private String content;


}
