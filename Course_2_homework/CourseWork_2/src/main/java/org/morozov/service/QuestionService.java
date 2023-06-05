package org.morozov.service;

import org.morozov.exception.MethodNotAllowedException;
import org.morozov.model.Question;

import java.util.Collection;

public interface QuestionService {
    default Question add(String question, String answer) {
        throw new MethodNotAllowedException("Method is unavailable");
    }
    default Question add(Question question) {
        throw new MethodNotAllowedException("Method is unavailable");
    }
    default Question remove(Question question) {
        throw new MethodNotAllowedException("Method is unavailable");
    }
    default Question find(String question, String answer) {
        throw new MethodNotAllowedException("Method is unavailable");
    }
    default Collection<Question> getAll() {
        throw new MethodNotAllowedException("Method is unavailable");
    }
    Question getRandomQuestion(int i);
}
