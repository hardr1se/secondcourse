package pro.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/calculator")
public class CalculatorController {

    private final CalculatorServiceInterface calculatorServiceInterface;

    public CalculatorController(CalculatorServiceInterface calculatorServiceInterface) {
        this.calculatorServiceInterface = calculatorServiceInterface;
    }

    @GetMapping
    public String welcome() {
        return calculatorServiceInterface.welcome();
    }

    @GetMapping(path = "/plus")
    public String calculatePlus(@RequestParam(value = "num1", required = false) Double num1,
                                @RequestParam(value = "num2", required = false) Double num2) {
        if (num1 == null || num2 == null) {
            return "Вы ввели не все значение";
        } else {
            return calculatorServiceInterface.calculatePlus(num1, num2);
        }
    }

    @GetMapping(path = "/minus")
    public String calculateMinus(@RequestParam(value = "num1", required = false) Double num1,
                                 @RequestParam(value = "num2", required = false) Double num2) {
        if (num1 == null || num2 == null) {
            return "Вы ввели не все значение";
        } else {
            return calculatorServiceInterface.calculateMinus(num1, num2);
        }
    }

    @GetMapping(path = "/multiply")
    public String calculateMultiply(@RequestParam(value = "num1", required = false) Double num1,
                                    @RequestParam(value = "num2", required = false) Double num2) {
        if (num1 == null || num2 == null) {
            return "Вы ввели не все значение";
        } else {
            return calculatorServiceInterface.calculateMultiply(num1, num2);
        }
    }

    @GetMapping(path = "/divide")
    public String calculateDivide(@RequestParam(value = "num1", required = false) Double num1,
                                  @RequestParam(value = "num2", required = false) Double num2) {
        if (num1 == null || num2 == null) {
            return "Вы ввели не все значение";
        } else {
            return calculatorServiceInterface.calculateDivide(num1, num2);
        }
    }
}
