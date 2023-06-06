package org.morozov.service.impl;

import org.morozov.exception.IncorrectArgumentException;
import org.morozov.exception.MethodNotAllowedException;
import org.morozov.service.QuestionService;
import org.morozov.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class MathQuestionService implements QuestionService {
    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowedException("Method is unavailable");
    }

    @Override
    public Question add(Question question) {
        throw new MethodNotAllowedException("Method is unavailable");
    }

    @Override
    public Question remove(Question question) {
        throw new MethodNotAllowedException("Method is unavailable");
    }

    @Override
    public Question find(String question, String answer) {
        throw new MethodNotAllowedException("Method is unavailable");
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowedException("Method is unavailable");
    }

    @Override
    public Question getRandomQuestion(int i) {
        int randomNumber = getRandomNumber(true);
        int firstNum = getRandomNumber(false);
        int secondNum = getRandomNumber(false);
        String question;
        Integer answer;
        switch (randomNumber) {
            case 1 -> {
                question = firstNum + " + " + secondNum + " = ";
                answer = firstNum + secondNum;
            }
            case 2 -> {
                question = firstNum + " - " + secondNum + " = ";
                answer = firstNum - secondNum;
            }
            case 3 -> {
                question = firstNum + " * " + secondNum + " = ";
                answer = firstNum * secondNum;
            }
            case 4 -> {
                question = firstNum + " / " + secondNum + " = ";
                answer = firstNum / secondNum;
            }
            default -> throw new IncorrectArgumentException("Unsupported value");
        }
        return new Question(question, String.valueOf(answer));
    }

    public Integer getRandomNumber(boolean checker) {
        return (int) (checker ?
                Math.floor(Math.random() * 4) + 1 :
                Math.floor(Math.random() * 10_000) + 1);
    }

    public Question getQuestion(String question, String answer) {
        if (Objects.equals(question, answer)) {
            throw new IncorrectArgumentException("Question and argument are similar");
        } else if (isBlank(question) || isBlank(answer)) {
            throw new IncorrectArgumentException("Received value is empty");
        }

        Question fullQuestion;

        if (!isNumeric(question) && !isNumeric(answer)) {
            fullQuestion = new Question(
                    capitalize(question.toLowerCase()),
                    capitalize(answer.toLowerCase()));
        } else if (!isNumeric(question) && isNumeric(answer)) {
            fullQuestion = new Question(
                    capitalize(question.toLowerCase()),
                    answer);
        } else {
            throw new IncorrectArgumentException("Unsupported argument");
        }
        return fullQuestion;
    }
}
