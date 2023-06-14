package org.morozov.controller;

import org.morozov.service.QuestionService;
import org.morozov.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java")
public class JavaController {
    QuestionService questionService;

    public JavaController(@Qualifier("javaQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam(value = "question", required = false) String question,
                                @RequestParam(value = "answer", required = false) String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam(value = "question", required = false) String question,
                                   @RequestParam(value = "answer", required = false) String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping()
    public String getAllQuestion() {
        return questionService.getAll().toString();
    }

    @GetMapping("/find")
    public Question findQuestion(@RequestParam(value = "question", required = false) String question,
                                 @RequestParam(value = "answer", required = false) String answer) {
        return questionService.find(question, answer);
    }
}
