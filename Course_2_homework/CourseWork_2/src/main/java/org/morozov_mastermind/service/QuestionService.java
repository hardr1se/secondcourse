package org.morozov.service;

import org.morozov.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Question find(String question, String answer);
    Collection<Question> getAll();
    Question getRandomQuestion(int i);
}
