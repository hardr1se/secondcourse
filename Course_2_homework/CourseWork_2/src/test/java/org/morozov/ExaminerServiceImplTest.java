package org.morozov;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.morozov.exception.IncorrectArgumentException;
import org.morozov.service.impl.ExaminerServiceImpl;
import org.morozov.utils.Question;

import java.util.ArrayList;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    ExaminerServiceImpl examinerServiceImpl;
    Question question = new Question("Test question", "Test answer");

    @Test
    public void getQuestionsTest() {
        when(examinerServiceImpl.getQuestions(anyInt())).thenReturn(new ArrayList<>(of(question)));
        assertEquals(new ArrayList<>(of(question)), examinerServiceImpl.getQuestions(anyInt()));
    }

    @Test
    public void getQuestionsNegativeTest() {
        when(examinerServiceImpl.getQuestions(-anyInt())).thenThrow(IncorrectArgumentException.class);
        assertThrows(IncorrectArgumentException.class, () ->
                examinerServiceImpl.getQuestions(-anyInt()));
    }
}
