package org.morozov.service.impl;

import org.morozov.exception.IncorrectArgumentException;
import org.morozov.exception.NotFoundElementException;
import org.morozov.exception.StorageIsEmptyException;
import org.morozov.repository.MathQuestionRepository;
import org.morozov.service.QuestionService;
import org.morozov.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.random.RandomGenerator;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class MathQuestionService implements QuestionService {
    List<Question> copyMathExam;
    MathQuestionRepository mathQuestionRepository;

    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question fullQuestion = getQuestion(question, answer);
        return mathQuestionRepository.add(fullQuestion);
    }

    @Override
    public Question add(Question question) {
        Question fullQuestion = getQuestion(question.getQuestion(), question.getAnswer());
        return mathQuestionRepository.add(fullQuestion);
    }

    @Override
    public Question remove(Question question)
            throws NotFoundElementException {
        Question fullQuestion = getQuestion(question.getQuestion(), question.getAnswer());
        if (!mathQuestionRepository.getAll().contains(fullQuestion)) {
            throw new NotFoundElementException("This question wasn't found");
        }
        return mathQuestionRepository.remove(fullQuestion);
    }

    @Override
    public Question find(String question, String answer)
            throws NotFoundElementException {
        Question fullQuestion = getQuestion(question, answer);
        if (!mathQuestionRepository.getAll().contains(fullQuestion)) {
            throw new NotFoundElementException("This question wasn't found");
        }
        return fullQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion(int i)
            throws StorageIsEmptyException {
        if (mathQuestionRepository.getAll().isEmpty()) {
            throw new StorageIsEmptyException("Fill the storage before using");
        }
        if (i == 1) {
            copyMathExam = new ArrayList<>(mathQuestionRepository.getAll());
        }
        int randomNumber = RandomGenerator.getDefault().nextInt(0, copyMathExam.size());
        Question randomQuestion = copyMathExam.get(randomNumber);
        copyMathExam.remove(randomNumber);
        return randomQuestion;
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
