package org.morozov.service.impl;

import org.morozov.exception.IncorrectArgumentException;
import org.morozov.exception.NotFoundElementException;
import org.morozov.service.QuestionService;
import org.morozov.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.random.RandomGenerator;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class MathQuestionService implements QuestionService {
    Set<Question> mathQuestionRepository;

    public MathQuestionService(HashSet<Question> mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question fullQuestion = getQuestion(question, answer);
        return mathQuestionRepository.add(fullQuestion) ? fullQuestion : null;
    }

    @Override
    public Question add(Question question) {
        Question fullQuestion = getQuestion(question.getQuestion(), question.getAnswer());
        return mathQuestionRepository.add(fullQuestion) ? fullQuestion : null;
    }

    @Override
    public Question remove(Question question)
            throws NotFoundElementException {
        Question fullQuestion = getQuestion(question.getQuestion(), question.getAnswer());
        if (!mathQuestionRepository.contains(fullQuestion)) {
            throw new NotFoundElementException("This question wasn't found");
        }
        return mathQuestionRepository.remove(fullQuestion) ? fullQuestion : null;
    }

    @Override
    public Question find(String question, String answer)
            throws NotFoundElementException {
        Question fullQuestion = getQuestion(question, answer);
        if (!mathQuestionRepository.contains(fullQuestion)) {
            throw new NotFoundElementException("This question wasn't found");
        }
        return fullQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository;
    }

    @Override
    public Question getRandomQuestion(int i)
            throws IncorrectArgumentException {
        int randomNumber = RandomGenerator.getDefault().nextInt(1, 5);
        int firstNum = RandomGenerator.getDefault().nextInt(1, 10_000);
        int secondNum = RandomGenerator.getDefault().nextInt(1, 10_000);
        String question;
        Integer answer;
        switch (randomNumber) {
            case 1 -> {
                question = firstNum + " + " + secondNum;
                answer = firstNum + secondNum;
            }
            case 2 -> {
                question = firstNum + " - " + secondNum;
                answer = firstNum - secondNum;
            }
            case 3 -> {
                question = firstNum + " * " + secondNum;
                answer = firstNum * secondNum;
            }
            case 4 -> {
                question = firstNum + " / " + secondNum;
                answer = firstNum / secondNum;
            }
            default -> throw new IncorrectArgumentException("Unsupported value");
        }
        return new Question(question, String.valueOf(answer));
    }

    public Question getQuestion(String question, String answer)
            throws IncorrectArgumentException {
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
