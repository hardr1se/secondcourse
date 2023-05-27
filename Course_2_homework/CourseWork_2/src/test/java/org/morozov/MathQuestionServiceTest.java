package org.morozov;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.morozov.exception.IncorrectArgumentException;
import org.morozov.exception.NotFoundElementException;
import org.morozov.exception.StorageIsEmptyException;
import org.morozov.model.Question;
import org.morozov.repository.MathQuestionRepository;
import org.morozov.service.impl.MathQuestionService;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {
    @Mock
    MathQuestionRepository mathQuestionRepository;
    @InjectMocks
    MathQuestionService mathQuestionService = new MathQuestionService(null);

    @Test
    public void addFirstTest() {
        Mockito.when(mathQuestionRepository.getAll())
                .thenReturn(new HashSet<>(Set.of(new Question("Test", "12"))));
        Mockito.when(mathQuestionRepository.add(new Question("Test", "12")))
                .thenReturn(new Question("Test", "12"));

        Assertions.assertThat(mathQuestionService.add(new Question("TeST", "12")))
                .isEqualTo(new Question("Test", "12"))
                .isIn(mathQuestionRepository.getAll());
    }

    @Test
    public void addSecondTest() {
        Mockito.when(mathQuestionRepository.getAll())
                .thenReturn(new HashSet<>(Set.of(new Question("Test", "12"))));
        Mockito.when(mathQuestionRepository.add(new Question("Test", "12")))
                .thenReturn(new Question("Test", "12"));

        Assertions.assertThat(mathQuestionService.add("TeST", "12"))
                .isEqualTo(new Question("Test", "12"))
                .isIn(mathQuestionRepository.getAll());
    }

    @Test
    public void removeTest() {
        Mockito.when(mathQuestionRepository.getAll())
                .thenReturn(new HashSet<>(Set.of(new Question("Test", "12"))));
        Mockito.when(mathQuestionRepository.remove(new Question("Test", "12")))
                .thenReturn(new Question("Test", "12"));

        Assertions.assertThat(mathQuestionService.remove(new Question("TeST", "12")))
                .isEqualTo(new Question("Test", "12"));
    }

    @Test
    public void removeNegativeTest() {
        Mockito.when(mathQuestionRepository.getAll())
                .thenReturn(new HashSet<>(Set.of(new Question("Test", "12"))));

        Assertions.assertThatExceptionOfType(NotFoundElementException.class)
                .isThrownBy(() -> mathQuestionService.remove(new Question("Test 1", "16")));
    }

    @Test
    public void findTest() {
        Mockito.when(mathQuestionRepository.getAll())
                .thenReturn(new HashSet<>(Set.of(new Question("Test", "12"))));

        Assertions.assertThat(mathQuestionService.find("TeST", "12"))
                .isEqualTo(new Question("Test", "12"))
                .isIn(mathQuestionRepository.getAll());
    }

    @Test
    public void findNegativeTest() {
        Mockito.when(mathQuestionRepository.getAll())
                .thenReturn(new HashSet<>(Set.of(new Question("Test", "12"))));

        Assertions.assertThatExceptionOfType(NotFoundElementException.class)
                .isThrownBy(() -> mathQuestionService.find("Test 1", "16"));
    }

    @Test
    public void getAllTest() {
        Mockito.when(mathQuestionRepository.getAll())
                .thenReturn(new HashSet<>(Set.of(new Question("Test", "12"))));

        Assertions.assertThat(mathQuestionRepository.getAll())
                .isEqualTo(new HashSet<>(Set.of(new Question("Test", "12"))));
    }

    @Test
    public void getRandomQuestionTest() {
        Mockito.when(mathQuestionRepository.getAll())
                .thenReturn(new HashSet<>(Set.of(new Question("Test", "12"))));

        Assertions.assertThat(mathQuestionService.getRandomQuestion(1))
                .isEqualTo(new Question("Test", "12"))
                .isIn(mathQuestionRepository.getAll());
    }

    @Test
    public void getRandomQuestionNegativeTest() {
        Mockito.when(mathQuestionService.getAll())
                .thenReturn(new HashSet<>());

        Assertions.assertThatExceptionOfType(StorageIsEmptyException.class)
                .isThrownBy(() -> mathQuestionService.getRandomQuestion(1));
    }

    @Test
    public void getQuestion() {
        Mockito.when(mathQuestionRepository.getAll())
                .thenReturn(new HashSet<>(Set.of(new Question("Test", "12"))));

        Assertions.assertThat(mathQuestionService.getQuestion("TESt", "12"))
                .isEqualTo(new Question("Test", "12"))
                .isIn(mathQuestionRepository.getAll());
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
