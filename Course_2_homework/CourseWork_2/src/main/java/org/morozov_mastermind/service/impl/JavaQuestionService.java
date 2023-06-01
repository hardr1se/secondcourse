package org.morozov.service.impl;

import org.morozov.exception.IncorrectArgumentException;
import org.morozov.exception.NotFoundElementException;
import org.morozov.exception.StorageIsEmptyException;
import org.morozov.repository.JavaQuestionRepository;
import org.morozov.service.QuestionService;
import org.morozov.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.random.RandomGenerator;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class JavaQuestionService implements QuestionService {
    List<Question> copyExamQuestions;
    JavaQuestionRepository javaQuestionRepository;

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question fullQuestion = getQuestion(question, answer);
        return javaQuestionRepository.add(fullQuestion);
    }

    @Override
    public Question add(Question question) {
        Question fullQuestion = getQuestion(question.getQuestion(), question.getAnswer());
        return javaQuestionRepository.add(fullQuestion);
    }

    @Override
    public Question remove(Question question)
            throws NotFoundElementException {
        Question fullQuestion = getQuestion(question.getQuestion(), question.getAnswer());
        if (!javaQuestionRepository.getAll().contains(fullQuestion)) {
            throw new NotFoundElementException("This question wasn't found");
        }
        return javaQuestionRepository.remove(fullQuestion);
    }

    @Override
    public Question find(String question, String answer)
            throws NotFoundElementException {
        Question fullQuestion = getQuestion(question, answer);
        if (!javaQuestionRepository.getAll().contains(fullQuestion)) {
            throw new NotFoundElementException("This question wasn't found");
        }
        return fullQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion(int i)
            throws StorageIsEmptyException {
        if (javaQuestionRepository.getAll().isEmpty()) {
            throw new StorageIsEmptyException("Fill the storage before using");
        }
        if (i == 1) {
            copyExamQuestions = new ArrayList<>(javaQuestionRepository.getAll());
        }
        int randomNumber = RandomGenerator.getDefault().nextInt(0, copyExamQuestions.size());
        Question randomQuestion = copyExamQuestions.get(randomNumber);
        copyExamQuestions.remove(randomNumber);
        return randomQuestion;
    }

    public Question getQuestion(String question, String answer)
            throws IncorrectArgumentException {

        Question fullQuestion = new Question(
                capitalize(question.toLowerCase()),
                capitalize(answer.toLowerCase()));
        if (Objects.equals(fullQuestion.getQuestion(), fullQuestion.getAnswer())) {
            throw new IncorrectArgumentException("Question and argument are similar");
        } else if (isBlank(fullQuestion.getQuestion()) || isBlank(fullQuestion.getAnswer())) {
            throw new IncorrectArgumentException("Received value is empty");
        }
        return fullQuestion;
    }
}
