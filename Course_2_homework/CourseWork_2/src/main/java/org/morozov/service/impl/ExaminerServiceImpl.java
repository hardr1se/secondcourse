package org.morozov.service.impl;

import org.morozov.exception.IncorrectArgumentException;
import org.morozov.service.ExaminerService;
import org.morozov.service.QuestionService;
import org.morozov.utils.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<Question> result = new ArrayList<>();
        if (amount < 0 || amount > questionService.getAll().size()) {
            throw new IncorrectArgumentException("Incorrect amount of value");
        }
        for (int i = 1; i <= amount; i++) {
            result.add(questionService.getRandomQuestion(i));
        }
        return result;
    }
}
