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
import org.morozov.repository.JavaQuestionRepository;
import org.morozov.service.impl.JavaQuestionService;
import org.morozov.model.Question;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    JavaQuestionRepository javaQuestionRepository;
    @InjectMocks
    JavaQuestionService javaQuestionService = new JavaQuestionService(null);

    @Test
    public void addFirstTest() {
        Mockito.when(javaQuestionRepository.add(new Question("Test", "Testy")))
                .thenReturn(new Question("Test", "Testy"));
        Mockito.when(javaQuestionRepository.getAll())
                .thenReturn(new HashSet<>(Set.of(new Question("Test", "Testy"))));

        Assertions.assertThat(javaQuestionService.add("TeST", "tESTy"))
                .isEqualTo(new Question("Test", "Testy"))
                .isIn(javaQuestionRepository.getAll());
    }

    @Test
    public void addSecondTest() {
        Mockito.when(javaQuestionRepository.add(new Question("Test", "Testy")))
                .thenReturn(new Question("Test", "Testy"));
        Mockito.when(javaQuestionRepository.getAll())
                .thenReturn(new HashSet<>(Set.of(new Question("Test", "Testy"))));

        Assertions.assertThat(javaQuestionService.add(new Question("TeST", "tESTY")))
                .isEqualTo(new Question("Test", "Testy"))
                .isIn(javaQuestionRepository.getAll());
    }

    @Test
    public void removeTest() {
        Mockito.when(javaQuestionRepository.getAll())
                .thenReturn(new HashSet<>(Set.of(new Question("Test", "Testy"))));
        Mockito.when(javaQuestionRepository.remove(new Question("Test", "Testy")))
                .thenReturn(new Question("Test", "Testy"));

        Assertions.assertThat(javaQuestionService.remove(new Question("TEST", "TeSTy")))
                .isEqualTo(new Question("Test", "Testy"));
    }

    @Test
    public void removeNegativeTest() {
        Mockito.when(javaQuestionRepository.getAll())
                .thenReturn(new HashSet<>(Set.of(new Question("Test", "Testy"))));

        Assertions.assertThatExceptionOfType(NotFoundElementException.class)
                .isThrownBy(() -> javaQuestionService.remove(new Question("Test", "Testiye")));
    }

    @Test
    public void findTest() {
        Mockito.when(javaQuestionRepository.getAll())
                .thenReturn(new HashSet<>(Set.of(new Question("Test", "Testy"))));

        Assertions.assertThat(javaQuestionService.find("TEST", "TeSTy"))
                .isEqualTo(new Question("Test", "Testy"));
    }

    @Test
    public void findNegativeTest() {
        Mockito.when(javaQuestionRepository.getAll())
                .thenReturn(new HashSet<>(Set.of(new Question("Test", "Testy"))));

        Assertions.assertThatExceptionOfType(NotFoundElementException.class)
                .isThrownBy(() -> javaQuestionService.find("Test", "Testiye"));
    }

    @Test
    public void getAllTest() {
        Mockito.when(javaQuestionRepository.getAll())
                .thenReturn(new HashSet<>(Set.of(new Question("Test", "Testy"))));

        Assertions.assertThat(javaQuestionService.getAll())
                .isEqualTo(new HashSet<>(Set.of(new Question("Test", "Testy"))));
    }

    @Test
    public void getRandomQuestionTest() {
        Mockito.when(javaQuestionRepository.getAll())
                .thenReturn(new HashSet<>(Set.of(new Question("Test", "Testy"))));

        Assertions.assertThat(javaQuestionService.getRandomQuestion(1))
                .isEqualTo(new Question("Test", "Testy"))
                .isIn(javaQuestionRepository.getAll());
    }

    @Test
    public void getRandomQuestionNegativeTest() {
        Mockito.when(javaQuestionRepository.getAll())
                .thenReturn(new HashSet<>());

        Assertions.assertThatExceptionOfType(StorageIsEmptyException.class)
                .isThrownBy(() -> javaQuestionService.getRandomQuestion(1));
    }

    @Test
    public void getQuestion() {
        Mockito.when(javaQuestionRepository.getAll())
                .thenReturn(new HashSet<>(Set.of(new Question("Test", "Testy"))));

        Assertions.assertThat(javaQuestionService.getQuestion("TESt", "tesTY"))
                .isEqualTo(new Question("Test", "Testy"))
                .isIn(javaQuestionRepository.getAll());
    }

    @Test
    public void getNegativeQuestion() {
        Assertions.assertThatExceptionOfType(IncorrectArgumentException.class)
                .isThrownBy(() -> javaQuestionService.getQuestion("TesT", "tESt"));

        Assertions.assertThatExceptionOfType(IncorrectArgumentException.class)
                .isThrownBy(() -> javaQuestionService.getQuestion("  ", "   "));
    }
}
