package org.morozov;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.morozov.exception.IncorrectArgumentException;
import org.morozov.repository.JavaQuestionRepository;
import org.morozov.service.QuestionService;
import org.morozov.service.impl.ExaminerServiceImpl;
import org.morozov.model.Question;
import org.morozov.service.impl.JavaQuestionService;
import org.morozov.service.impl.MathQuestionService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;
    @Spy
    List<QuestionService> questionServices;
    @InjectMocks
    ExaminerServiceImpl examinerServiceImpl = new ExaminerServiceImpl(
            new JavaQuestionService(new JavaQuestionRepository(new HashSet<>())),
            new MathQuestionService());

    @Test
    public void getQuestionsTest() {
        Mockito.when(questionServices.get(Mockito.anyInt()))
                .thenReturn(questionService);
        Mockito.when(questionService.getAll())
                .thenReturn(new ArrayList<>(List.of(new Question(null, null))));
        Mockito.when(questionService.getRandomQuestion(Mockito.anyInt()))
                .thenReturn(new Question("Test question", "Test answer"));

        Assertions.assertThat(examinerServiceImpl.getQuestions(1))
                .isEqualTo(new ArrayList<>(List.of(new Question("Test question", "Test answer"))));
    }

    @Test
    public void getQuestionsNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectArgumentException.class)
                .isThrownBy(() -> examinerServiceImpl.getQuestions(-1));

        Mockito.when(questionServices.get(0))
                .thenReturn(questionService);
        Mockito.when(questionService.getAll())
                .thenReturn(new ArrayList<>(List.of(new Question("Test question", "Test answer"))));
        Assertions.assertThatExceptionOfType(IncorrectArgumentException.class)
                .isThrownBy(() -> examinerServiceImpl.getQuestions(3));
    }

    @Test
    public void getMathQuestionsTest() {
        Mockito.when(questionServices.get(1))
                .thenReturn(questionService);
        Mockito.when(questionService.getAll())
                .thenReturn(new ArrayList<>(List.of(new Question(null, null))));
        Mockito.when(questionService.getRandomQuestion(Mockito.anyInt()))
                .thenReturn(new Question("Test question", "12"));

        Assertions.assertThat(examinerServiceImpl.getMathQuestions(1))
                .isEqualTo(new ArrayList<>(List.of(new Question("Test question", "12"))));
    }

    @Test
    public void getMathQuestionsNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectArgumentException.class)
                .isThrownBy(() -> examinerServiceImpl.getMathQuestions(-1));

        Mockito.when(questionServices.get(1))
                .thenReturn(questionService);
        Mockito.when(questionService.getAll())
                .thenReturn(new ArrayList<>(List.of(new Question(null, null))));
        Assertions.assertThatExceptionOfType(IncorrectArgumentException.class)
                .isThrownBy(() -> examinerServiceImpl.getMathQuestions(3));
    }
}
