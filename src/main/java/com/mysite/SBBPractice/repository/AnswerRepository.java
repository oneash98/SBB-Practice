package com.mysite.SBBPractice.repository;

import com.mysite.SBBPractice.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    Answer findByContent(String content);
}
