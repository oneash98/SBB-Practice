package com.mysite.SBBPractice.repository;

import com.mysite.SBBPractice.domain.Answer;
import com.mysite.SBBPractice.domain.Question;
import com.mysite.SBBPractice.repository.QuestionRepository;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QuestionAnswerRepositoryTest {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private  AnswerRepository answerRepository;


    @Test
    void testJpa() {
        Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가요?");
        q1.setContent("sbb에 대해서 알고 싶습니다.");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);  // 첫번째 질문 저장

        Question q2 = new Question();
        q2.setSubject("스프링부트 모델 질문입니다.");
        q2.setContent("id는 자동으로 생성되나요?");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);  // 두번째 질문 저장

        List<Question> all = this.questionRepository.findAll();
        assertThat(2).isEqualTo(all.size());

        Optional<Question> oq1 = this.questionRepository.findById(1);
        if(oq1.isPresent()) {
            Question q = oq1.get();
            assertThat("sbb가 무엇인가요?").isEqualTo(q.getSubject());
        }

        Question testQ1 = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
        assertThat(1).isEqualTo(testQ1.getId());

        this.questionRepository.delete(testQ1);
        assertThat(1).isEqualTo(this.questionRepository.count());


        Optional<Question> oq2 = this.questionRepository.findById(2);
        assertThat(oq2.isPresent());
        Question testQ2 = oq2.get();

        Answer a2 = new Answer();
        a2.setContent("네 자동으로 생성됩니다.");
        a2.setQuestion(testQ2);
        a2.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a2);

        Optional<Answer> oa = this.answerRepository.findById(1);
        assertThat(oa.isPresent());
        Answer testA2 = oa.get();
        assertThat(2).isEqualTo(testA2.getQuestion().getId());

        Optional<Question> oq222 = this.questionRepository.findById(2);
        assertThat(oq222.isPresent());
        Question testQ222 = oq222.get();

        List<Answer> answerList = testQ222.getAnswerList();

        assertThat(1).isEqualTo(answerList.size());
        assertThat("네 자동으로 생성됩니다.").isEqualTo(answerList.get(0).getContent());

    }
}
