package com.mysite.SBBPractice.repository;

import com.mysite.SBBPractice.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
