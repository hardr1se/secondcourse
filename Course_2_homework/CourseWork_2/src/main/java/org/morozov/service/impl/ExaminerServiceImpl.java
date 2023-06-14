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
    List<QuestionService> questionServices;

    public ExaminerServiceImpl(
            @Qualifier("javaQuestionService") QuestionService questionService,
            @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.questionServices = new ArrayList<>(List.of(questionService, mathQuestionService));
    }

    @Override
    public Collection<Question> getQuestions(Integer amount) {
        List<Question> result = new ArrayList<>();
        if (amount < 0 || amount > questionServices.get(0).getAll().size()) {
            throw new IncorrectArgumentException("Incorrect amount of value");
        }
        for (int i = 1; i <= amount; i++) {
            result.add(questionServices.get(0).getRandomQuestion(i));
        }
        return result;
    }

    @Override
    public Collection<Question> getMathQuestions(Integer amount) {
        List<Question> result = new ArrayList<>();
        if (amount < 0 || amount > questionServices.get(1).getAll().size()) {
            throw new IncorrectArgumentException("Incorrect amount of value");
        }
        for (int i = 1; i <= amount; i++) {
            result.add(questionServices.get(1).getRandomQuestion(i));
        }
        return result;
    }
}
