package org.morozov.controller;

import org.morozov.exception.IncorrectArgumentException;
import org.morozov.service.ExaminerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam")
public class ExamController {
    ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @RequestMapping(value = "/get/{amount}")
    public String getQuestions(@PathVariable("amount") Integer amount) {
        return examinerService.getQuestions(amount).toString();
    }
}