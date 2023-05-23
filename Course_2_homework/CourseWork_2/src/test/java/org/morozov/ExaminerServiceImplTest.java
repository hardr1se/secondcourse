package org.morozov;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.morozov.exception.IncorrectArgumentException;
import org.morozov.service.QuestionService;
import org.morozov.service.impl.ExaminerServiceImpl;
import org.morozov.utils.Question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl examinerServiceImpl;

    @BeforeEach
    public void init() {
        when(questionService.getAll()).thenReturn(new HashSet<>(Set.of(
                new Question("Назовите методы Object", "toString(), equals(), hashCode(), wait(), notify(), notifyAll(), finalize(), getClass()"),
                new Question("Чем отличается сравнение по == и по equals",
                        "Сравнение по \"==\" — сравнение по ссылкам\n" + "Сравнение по «equals» — если переопределен equals, то это сравнение эквивалентности объектов по их полям, если нет — по ссылкам на объекты")

        )));
    }

    @AfterEach
    public void afterEach() {

    }

    @Test
    public void getQuestionsTest() {
        when(questionService.getRandomQuestion(anyInt())).thenReturn(new Question("Назовите методы Object", "toString(), equals(), hashCode(), wait(), notify(), notifyAll(), finalize(), getClass()"));
        Assertions.assertThat(examinerServiceImpl.getQuestions(1))
                .isEqualTo(new ArrayList<>(List.of(new Question("Назовите методы Object", "toString(), equals(), hashCode(), wait(), notify(), notifyAll(), finalize(), getClass()"))));
    }

    @Test
    public void getQuestionsNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectArgumentException.class)
                .isThrownBy(() -> examinerServiceImpl.getQuestions(-1));
        Assertions.assertThatExceptionOfType(IncorrectArgumentException.class)
                .isThrownBy(() -> examinerServiceImpl.getQuestions(3));
    }
}
