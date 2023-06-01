package org.morozov.service;

import org.morozov.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(Integer amount);
    Collection<Question> getMathQuestions(Integer amount);
}
