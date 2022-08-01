package com.mysite.SBBPractice.repository;

import com.mysite.SBBPractice.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    Question findBySubject(String subject); // 메서드 선언만 하고 구현하지 않아도, JPA가 메서드명 분석하여 쿼리를 만들고 실행. (findBy + 엔티티 속성명)

    Question findBySubjectAndContent(String subject, String content); // And 사용하여 두 개의 속성으로 조회 가능. 이 외에도 Or, In 등 다양한 조건식 존재
}
