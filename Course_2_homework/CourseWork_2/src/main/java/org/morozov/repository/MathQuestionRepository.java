package org.morozov.repository;

import org.morozov.model.Question;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository {
    Set<Question> mathExam;

    public MathQuestionRepository(HashSet<Question> mathExam) {
        this.mathExam = mathExam;
    }

    @PostConstruct
    public void init() {
        Question question1 = new Question("Один велосипедист 12 с двигался со скоростью 6 м/с, а второй проехал этот же участок пути за 9 с. Какова средняя скорость второго велосипедиста на этом участке пути?", "8");
        Question question2 = new Question("Какова вероятность того, что случайно выбранный телефонный номер оканчивается двумя чётными цифрами?", "0,25");
        mathExam.add(question1);
        mathExam.add(question2);
    }

    public Set<Question> getAll() {
        return mathExam;
    }

    public Question add(Question question) {
        mathExam.add(question);
        return question;
    }

    public Question remove(Question question) {
        mathExam.remove(question);
        return question;
    }
}
