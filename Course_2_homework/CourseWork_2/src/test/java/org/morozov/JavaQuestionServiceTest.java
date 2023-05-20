package org.morozov;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.morozov.exception.NotFoundElementException;
import org.morozov.exception.StorageIsEmptyException;
import org.morozov.service.impl.JavaQuestionService;
import org.morozov.utils.Question;

import java.util.ArrayList;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    JavaQuestionService javaQuestionService;
    Question question = new Question("Test question", "Test answer");
    Question repeatedValues = new Question("Test", "Test");

    @Test
    public void addFirstTest() {
        when(javaQuestionService.add(question.getQuestion(), question.getAnswer())).thenReturn(question);
        assertEquals(question, javaQuestionService.add(question.getQuestion(), question.getAnswer()));
    }

    @Test
    public void addFirstNegativeTest() {
        when(javaQuestionService.add(repeatedValues.getQuestion(), repeatedValues.getAnswer()))
                .thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () ->
                javaQuestionService.add(repeatedValues.getQuestion(), repeatedValues.getAnswer()));
    }

    @Test
    public void addSecondTest() {
        when(javaQuestionService.add(question)).thenReturn(question);
        assertEquals(question, javaQuestionService.add(question));
    }

    @Test
    public void addSecondNegativeTest() {
        when(javaQuestionService.add(repeatedValues)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> javaQuestionService.add(repeatedValues));
    }

    @Test
    public void removeTest() {
        when(javaQuestionService.remove(question)).thenReturn(question);
        assertEquals(question, javaQuestionService.remove(question));
    }

    @Test
    public void removeNegativeTest() {
        when(javaQuestionService.remove(question)).thenThrow(NotFoundElementException.class);
        assertThrows(NotFoundElementException.class, () -> javaQuestionService.remove(question));
    }

    @Test
    public void findTest() {
        when(javaQuestionService.find(question.getQuestion(), question.getAnswer())).thenReturn(question);
        assertEquals(question, javaQuestionService.find(question.getQuestion(), question.getAnswer()));
    }

    @Test
    public void findNegativeTest() {
        when(javaQuestionService.find(question.getQuestion(), question.getAnswer())).thenThrow(NotFoundElementException.class);
        assertThrows(NotFoundElementException.class, () ->
                javaQuestionService.find(question.getQuestion(), question.getAnswer()));
    }

    @Test
    public void getAllTest() {
        when(javaQuestionService.getAll()).thenReturn(new ArrayList<>(of(question)));
        assertEquals(new ArrayList<>(of(question)), javaQuestionService.getAll());
    }

    @Test
    public void getRandomQuestionTest() {
        when(javaQuestionService.getRandomQuestion(anyInt())).thenReturn(question);
        assertEquals(question, javaQuestionService.getRandomQuestion(anyInt()));
    }

    @Test
    public void getRandomQuestionNegativeTest() {
        when(javaQuestionService.getRandomQuestion(anyInt())).thenThrow(StorageIsEmptyException.class);
        assertThrows(StorageIsEmptyException.class, () -> javaQuestionService.getRandomQuestion(anyInt()));
    }
}
