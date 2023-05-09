package pro.sky.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator.service.CalculatorService;

@RestController
@RequestMapping (path = "/calculator")
public class CalculatorController {
    CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping(path = "/plus")
    public String calculatePlus(@RequestParam(value = "num1", required = false) Integer num1,
                                @RequestParam(value = "num2", required = false) Integer num2) {
        return num1 + " + " + num2 + " = " + calculatorService.calculate(num1, num2, "+");
    }

    @GetMapping(path = "/minus")
    public String calculateMinus(@RequestParam(value = "num1", required = false) Integer num1,
                                 @RequestParam(value = "num2", required = false) Integer num2) {
        return num1 + " - " + num2 + " = " + calculatorService.calculate(num1, num2, "-");
    }

    @GetMapping(path = "/multiply")
    public String calculateMultiply(@RequestParam(value = "num1", required = false) Integer num1,
                                    @RequestParam(value = "num2", required = false) Integer num2) {
        return num1 + " * " + num2 + " = " + calculatorService.calculate(num1, num2, "*");
    }

    @GetMapping(path = "/divide")
    public String calculateDivide(@RequestParam(value = "num1", required = false) Integer num1,
                                  @RequestParam(value = "num2", required = false) Integer num2) {
        return num1 + " / " + num2 + " = " + calculatorService.calculate(num1, num2, "/");
    }
}
