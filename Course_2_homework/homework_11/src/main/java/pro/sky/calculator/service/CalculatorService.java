package pro.sky.calculator.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@Service
public class CalculatorService {
    public Integer calculate(Integer num1, Integer num2, String operation) {
        if (num1 == null || num2 == null || (Objects.equals(operation, "/") && num2 == 0)) {
            throw new IllegalArgumentException();
        }
        switch (operation) {
            case "+" -> { return num1 + num2; }
            case "-" -> { return num1 - num2; }
            case "*" -> { return num1 * num2; }
            case "/" -> { return num1 / num2; }
            default -> { throw new IllegalArgumentException(); }
        }
    }

    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
    private String illegalArgumentArgumentExceptionHandler() {
        return "Вы ввели некорректные значения";
    }
}

