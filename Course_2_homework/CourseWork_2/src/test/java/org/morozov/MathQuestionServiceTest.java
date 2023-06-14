package org.morozov;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.morozov.exception.IncorrectArgumentException;
import org.morozov.exception.MethodNotAllowedException;
import org.morozov.model.Question;
import org.morozov.service.impl.MathQuestionService;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {
    @Spy
    MathQuestionService mathQuestionService = new MathQuestionService();

    @Test
    public void methodsConnectedWithRepositoryTest() {
        Assertions.assertThatExceptionOfType(MethodNotAllowedException.class)
                .isThrownBy(() -> mathQuestionService.add("TeST", "12"));
        Assertions.assertThatExceptionOfType(MethodNotAllowedException.class)
                .isThrownBy(() -> mathQuestionService.add(new Question("TeST", "12")));
        Assertions.assertThatExceptionOfType(MethodNotAllowedException.class)
                .isThrownBy(() -> mathQuestionService.remove(new Question("TeST", "12")));
        Assertions.assertThatExceptionOfType(MethodNotAllowedException.class)
                .isThrownBy(() -> mathQuestionService.find("TeST", "12"));
        Assertions.assertThatExceptionOfType(MethodNotAllowedException.class)
                .isThrownBy(() -> mathQuestionService.getAll());
    }

    @Test
    public void getRandomQuestionTest() {
        Mockito.when(mathQuestionService.getRandomNumber(true))
                .thenReturn(1);
        Mockito.when(mathQuestionService.getRandomNumber(false))
                .thenReturn(2);
        Assertions.assertThat(mathQuestionService.getRandomQuestion(Mockito.anyInt()))
                .isEqualTo(new Question("2 + 2 = ", "4"));

        Mockito.when(mathQuestionService.getRandomNumber(true))
                .thenReturn(2);
        Assertions.assertThat(mathQuestionService.getRandomQuestion(Mockito.anyInt()))
                .isEqualTo(new Question("2 - 2 = ", "0"));

        Mockito.when(mathQuestionService.getRandomNumber(true))
                .thenReturn(3);
        Assertions.assertThat(mathQuestionService.getRandomQuestion(Mockito.anyInt()))
                .isEqualTo(new Question("2 * 2 = ", "4"));

        Mockito.when(mathQuestionService.getRandomNumber(true))
                .thenReturn(4);
        Assertions.assertThat(mathQuestionService.getRandomQuestion(Mockito.anyInt()))
                .isEqualTo(new Question("2 / 2 = ", "1"));
    }

    @Test
    public void getRandomQuestionNegativeTest() {
        Mockito.when(mathQuestionService.getRandomNumber(true))
                .thenReturn(5);
        Assertions.assertThatExceptionOfType(IncorrectArgumentException.class)
                .isThrownBy(() -> mathQuestionService.getRandomQuestion(Mockito.anyInt()));
    }

    @Test
    public void getQuestion() {
        Assertions.assertThat(mathQuestionService.getQuestion("TESt", "12"))
                .isEqualTo(new Question("Test", "12"));
        Assertions.assertThat(mathQuestionService.getQuestion("TESt", "TEStY"))
                .isEqualTo(new Question("Test", "Testy"));
    }

    @Test
    public void getNegativeQuestion() {
        Assertions.assertThatExceptionOfType(IncorrectArgumentException.class)
                .isThrownBy(() -> mathQuestionService.getQuestion("12", "12"));
        Assertions.assertThatExceptionOfType(IncorrectArgumentException.class)
                .isThrownBy(() -> mathQuestionService.getQuestion("  ", "   "));
        Assertions.assertThatExceptionOfType(IncorrectArgumentException.class)
                .isThrownBy(() -> mathQuestionService.getQuestion("12", "Test"));
    }
}
