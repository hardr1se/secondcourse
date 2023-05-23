package org.morozov.service.impl;

import org.morozov.exception.IncorrectArgumentException;
import org.morozov.exception.NotFoundElementException;
import org.morozov.exception.StorageIsEmptyException;
import org.morozov.service.QuestionService;
import org.morozov.utils.Question;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.random.RandomGenerator;

import static org.apache.commons.lang3.StringUtils.capitalize;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> examQuestions = new HashSet<>();
    private List<Question> copyExamQuestions = new ArrayList<>();

    @Override
    public Question add(String question, String answer) {
        Question fullQuestion = new Question(
                capitalize(question.toLowerCase()),
                capitalize(answer.toLowerCase()));
        if (Objects.equals(fullQuestion.getQuestion(), fullQuestion.getAnswer())) {
            throw new IncorrectArgumentException("Question and argument are similar");
        }
        examQuestions.add(fullQuestion);
        return fullQuestion;
    }

    @Override
    public Question add(Question question) {
        Question fullQuestion = new Question(
                capitalize(question.getQuestion().toLowerCase()),
                capitalize(question.getAnswer().toLowerCase()));
        if (Objects.equals(fullQuestion.getQuestion(), fullQuestion.getAnswer())) {
            throw new IncorrectArgumentException("Question and argument are similar");
        }
        examQuestions.add(fullQuestion);
        return fullQuestion;
    }

    @Override
    public Question remove(Question question) {
        Question fullQuestion = new Question(
                capitalize(question.getQuestion().toLowerCase()),
                capitalize(question.getAnswer().toLowerCase()));
        if (!examQuestions.contains(fullQuestion)) {
            throw new NotFoundElementException("This question wasn't found");
        }
        examQuestions.remove(fullQuestion);
        return fullQuestion;
    }

    @Override
    public Question find(String question, String answer) {
        Question fullQuestion = new Question(
                capitalize(question.toLowerCase()),
                capitalize(answer.toLowerCase()));
        if (!examQuestions.contains(fullQuestion)) {
            throw new NotFoundElementException("This question wasn't found");
        }
        return fullQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return examQuestions;
    }

    @Override
    public Question getRandomQuestion(int i) {
        if (examQuestions.isEmpty()) {
            throw new StorageIsEmptyException("Fill the storage before using");
        }
        if (i == 1) {
            copyExamQuestions = new ArrayList<>(examQuestions);
        }
        int randomNumber = RandomGenerator.getDefault().nextInt(0, copyExamQuestions.size());
        Question randomQuestion = copyExamQuestions.get(randomNumber);
        copyExamQuestions.remove(randomNumber);
        return randomQuestion;
    }
}
