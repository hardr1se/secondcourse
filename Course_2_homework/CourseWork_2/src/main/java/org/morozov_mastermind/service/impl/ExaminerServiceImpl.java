package org.morozov.service.impl;

import org.morozov.exception.IncorrectArgumentException;
import org.morozov.service.ExaminerService;
import org.morozov.service.QuestionService;
import org.morozov.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    ArrayList<QuestionService> questionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService,
                               MathQuestionService mathQuestionService) {
        this.questionService = new ArrayList<>(List.of(javaQuestionService, mathQuestionService));
    }

    @Override
    public Collection<Question> getQuestions(Integer amount) throws IncorrectArgumentException {
        List<Question> result = new ArrayList<>();
        if (amount < 0 || amount > questionService.get(0).getAll().size()) {
            throw new IncorrectArgumentException("Incorrect amount of value");
        }
        for (int i = 1; i <= amount; i++) {
            result.add(questionService.get(0).getRandomQuestion(i));
        }
        return result;
    }

    @Override
    public Collection<Question> getMathQuestions(Integer amount) throws IncorrectArgumentException {
        List<Question> result = new ArrayList<>();
        if (amount < 0 || amount > questionService.get(1).getAll().size()) {
            throw new IncorrectArgumentException("Incorrect amount of value");
        }
        for (int i = 1; i <= amount; i++) {
            result.add(questionService.get(1).getRandomQuestion(i));
        }
        return result;
    }
}
