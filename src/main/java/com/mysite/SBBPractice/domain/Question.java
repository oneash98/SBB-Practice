package com.mysite.SBBPractice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {
    @Id // 기본 키 (primary key)로 지정. DB에 중복 저장 불가
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1씩 자동으로 증가하여 데이터 저장. GenerationType.IDENTITY는 해당 컬럼만의 독립적인 시퀀스 생성. 해당 옵션 생략하면 @GeneratedValue 애너테이션이 지정된 컬럼들이 모두 동일한 시퀀스로 번호 생성.
    private Integer id;

    @Column(length = 200) // 컬럼의 세부 설정
    private String subject;

    @Column(columnDefinition = "TEXT") // 글자 수 제한 X
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) // mappedBy: 참조 엔티티의 속성명. CascadeType.REMOVE -> 질문 삭제 시 답변들 모두 함께 삭제
    private List<Answer> answerList;
}