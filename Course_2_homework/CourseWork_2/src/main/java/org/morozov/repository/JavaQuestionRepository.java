package org.morozov.repository;

import org.morozov.model.Question;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository {
    Set<Question> commonExam;

    public JavaQuestionRepository(HashSet<Question> commonExam) {
        this.commonExam = commonExam;
    }

    @PostConstruct
    public void init() {
        Question question1 = new Question("Назовите методы Object", "toString(), equals(), hashCode(), wait(), notify(), notifyAll(), finalize(), getClass()");
        Question question2 = new Question("Чем отличается сравнение по == и по equals",
                "Сравнение по \"==\" — сравнение по ссылкам\n" + "Сравнение по «equals» — если переопределен equals, то это сравнение эквивалентности объектов по их полям, если нет — по ссылкам на объекты");
        commonExam.add(question1);
        commonExam.add(question2);
    }

    public Set<Question> getAll() {
        return commonExam;
    }

    public Question add(Question question) {
        commonExam.add(question);
        return question;
    }

    public Question remove(Question question) {
        commonExam.remove(question);
        return question;
    }
}
