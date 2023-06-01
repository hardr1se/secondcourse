package org.morozov;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.morozov.exception.IncorrectArgumentException;
import org.morozov.service.QuestionService;
import org.morozov.service.impl.ExaminerServiceImpl;
import org.morozov.model.Question;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;
    @Mock
    QuestionService mathQuestionService;
    @InjectMocks
    ExaminerServiceImpl examinerServiceImpl = new ExaminerServiceImpl(null, null);

    @Test
    public void getQuestionsTest() {
        Question question = new Question("Test question", "Test answer");

        Mockito.when(questionService.getAll())
                .thenReturn(new ArrayList<>(List.of(new Question(null, null))));
        Mockito.when(questionService.getRandomQuestion(Mockito.anyInt()))
                .thenReturn(new Question("Test question", "Test answer"));

        Assertions.assertThat(examinerServiceImpl.getQuestions(1))
                .isEqualTo(new ArrayList<>(List.of(question)));
    }

    @Test
    public void getQuestionsNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectArgumentException.class)
                .isThrownBy(() -> examinerServiceImpl.getQuestions(-1));

        Mockito.when(questionService.getAll())
                .thenReturn(new ArrayList<>(List.of(new Question("Test question", "Test answer"))));
        Assertions.assertThatExceptionOfType(IncorrectArgumentException.class)
                .isThrownBy(() -> examinerServiceImpl.getQuestions(3));
    }

    @Test
    public void getMathQuestionsTest() {
        Question question = new Question("Test question", "12");

        Mockito.when(mathQuestionService.getAll())
                .thenReturn(new ArrayList<>(List.of(new Question(null, null))));
        Mockito.when(mathQuestionService.getRandomQuestion(Mockito.anyInt()))
                .thenReturn(new Question("Test question", "12"));

        Assertions.assertThat(examinerServiceImpl.getMathQuestions(1))
                .isEqualTo(new ArrayList<>(List.of(question)));
    }

    @Test
    public void getMathQuestionsNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectArgumentException.class)
                .isThrownBy(() -> examinerServiceImpl.getMathQuestions(-1));

        Mockito.when(mathQuestionService.getAll())
                .thenReturn(new ArrayList<>(List.of(new Question(null, null))));
        Assertions.assertThatExceptionOfType(IncorrectArgumentException.class)
                .isThrownBy(() -> examinerServiceImpl.getMathQuestions(3));
    }
}
