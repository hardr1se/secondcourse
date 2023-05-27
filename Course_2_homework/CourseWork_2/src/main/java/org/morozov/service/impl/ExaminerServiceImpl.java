package org.morozov.service.impl;

import org.morozov.exception.IncorrectArgumentException;
import org.morozov.service.ExaminerService;
import org.morozov.service.QuestionService;
import org.morozov.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    QuestionService questionService;
    QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService questionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.questionService = questionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(Integer amount) throws IncorrectArgumentException {
        List<Question> result = new ArrayList<>();
        if (amount < 0 || amount > questionService.getAll().size()) {
            throw new IncorrectArgumentException("Incorrect amount of value");
        }
        for (int i = 1; i <= amount; i++) {
            result.add(questionService.getRandomQuestion(i));
        }
        return result;
    }

    @Override
    public Collection<Question> getMathQuestions(Integer amount) throws IncorrectArgumentException {
        List<Question> result = new ArrayList<>();
        if (amount < 0 || amount > mathQuestionService.getAll().size()) {
            throw new IncorrectArgumentException("Incorrect amount of value");
        }
        for (int i = 1; i <= amount; i++) {
            result.add(mathQuestionService.getRandomQuestion(i));
        }
        return result;
    }
}
