package org.morozov.controller;

import org.morozov.exception.IncorrectArgumentException;
import org.morozov.service.QuestionService;
import org.morozov.utils.Question;
import org.springframework.web.bind.annotation.*;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.isBlank;

@RestController
@RequestMapping("/exam")
public class JavaController {
    QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/java/add")
    public Question addQuestion(@RequestParam(value = "question", required = false) String question,
                                @RequestParam(value = "answer", required = false) String answer) {
        if (isBlank(question) || isBlank(answer)) {
            throw new IncorrectArgumentException("Received value is incorrect");
        }
        return questionService.add(question, answer);
    }

    @GetMapping("/java/remove")
    public Question removeQuestion(@RequestParam(value = "question", required = false) String question,
                                   @RequestParam(value = "answer", required = false) String answer) {
        if (isBlank(question) || isBlank(answer)) {
            throw new IncorrectArgumentException("Received value is incorrect");
        }
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping("/java")
    public String getAllQuestion() {
        return questionService.getAll().toString();
    }

    @GetMapping("/java/find")
    public Question findQuestion(@RequestParam(value = "question", required = false) String question,
                                 @RequestParam(value = "answer", required = false) String answer) {
        if (isBlank(question) || isBlank(answer)) {
            throw new IncorrectArgumentException("Received value is incorrect");
        }
        return questionService.find(question, answer);
    }
}
