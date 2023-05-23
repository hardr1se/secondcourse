package org.morozov;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.morozov.exception.IncorrectArgumentException;
import org.morozov.exception.NotFoundElementException;
import org.morozov.exception.StorageIsEmptyException;
import org.morozov.service.impl.JavaQuestionService;
import org.morozov.utils.Question;

import java.util.HashSet;
import java.util.Set;

public class JavaQuestionServiceTest {
    @InjectMocks
    private JavaQuestionService javaQuestionService = new JavaQuestionService();

    @BeforeEach
    public void beforeEach() {
        javaQuestionService = new JavaQuestionService();
        javaQuestionService.add("TeST 1", "TesT");
        javaQuestionService.add("TEST 2", "TeST");
        javaQuestionService.add("TesT 3", "TEST");
    }

    @Test
    public void addFirstTest() {
        Assertions.assertThat(javaQuestionService.add("PoSiTIVe test", "TeST"))
                .isEqualTo(new Question("Positive test", "Test"))
                .isIn(javaQuestionService.getAll());
    }

    @Test
    public void addFirstNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectArgumentException.class)
                .isThrownBy(() -> javaQuestionService.add("TeST", "test"))
                .isNotIn(javaQuestionService.getAll());
    }

    @Test
    public void addSecondTest() {
        Assertions.assertThat(javaQuestionService.add(new Question("PoSiTIVe test", "TeST")))
                .isEqualTo(new Question("Positive test", "Test"))
                .isIn(javaQuestionService.getAll());
    }

    @Test
    public void addSecondNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectArgumentException.class)
                .isThrownBy(() -> javaQuestionService.add(new Question("TeST", "test")))
                .isNotIn(javaQuestionService.getAll());
    }

    @Test
    public void removeTest() {
        Assertions.assertThat(javaQuestionService.remove(new Question("TeST 1", "TesT")))
                .isEqualTo(new Question("Test 1", "Test"))
                .isNotIn(javaQuestionService.getAll());
    }

    @Test
    public void removeNegativeTest() {
        Assertions.assertThatExceptionOfType(NotFoundElementException.class)
                .isThrownBy(() -> javaQuestionService.remove(new Question("NegaTIvE tEsT", "test")))
                .isNotIn(javaQuestionService.getAll());
    }

    @Test
    public void findTest() {
        Assertions.assertThat(javaQuestionService.find("TeST 1", "TEST"))
                .isEqualTo(new Question("Test 1", "Test"))
                .isIn(javaQuestionService.getAll());
    }

    @Test
    public void findNegativeTest() {
        Assertions.assertThatExceptionOfType(NotFoundElementException.class)
                .isThrownBy(() -> javaQuestionService.find("NegaTIvE tEsT", "test"))
                .isNotIn(javaQuestionService.getAll());
    }

    @Test
    public void getAllTest() {
        Assertions.assertThat(javaQuestionService.getAll())
                .isEqualTo(new HashSet<>(Set.of(
                        new Question("Test 1", "Test"),
                        new Question("Test 2", "Test"),
                        new Question("Test 3", "Test"))));
    }

    @Test
    public void getRandomQuestionTest() {
        javaQuestionService.remove(new Question("TEST 2", "TeST"));
        javaQuestionService.remove(new Question("TesT 3", "TEST"));
        Assertions.assertThat(javaQuestionService.getRandomQuestion(1))
                .isEqualTo(new Question("Test 1", "Test"))
                .isIn(javaQuestionService.getAll());
    }

    @Test
    public void getRandomQuestionNegativeTest() {
        javaQuestionService.remove(new Question("TeST 1", "TesT"));
        javaQuestionService.remove(new Question("TEST 2", "TeST"));
        javaQuestionService.remove(new Question("TesT 3", "TEST"));
        Assertions.assertThatExceptionOfType(StorageIsEmptyException.class)
                .isThrownBy(() -> javaQuestionService.getRandomQuestion(1));
    }
}
