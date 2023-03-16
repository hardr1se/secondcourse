package pro.sky.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements pro.sky.calculator.CalculatorServiceInterface {

    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    public String calculatePlus(Double num1, Double num2) {
        Double result = num1 + num2;
        if (num1 % 1 != 0 || num2 % 1 != 0) {
            return num1 + " + " + num2 + " = " + result;
        } else {
            return String.format("%.0f + %.0f = %.0f", num1, num2, result);
        }
    }

    public String calculateMinus(Double num1, Double num2) {
        double result = num1 - num2;
        if (num1 % 1 != 0 || num2 % 1 != 0) {
            return num1 + " - " + num2 + " = " + result;
        } else {
            return String.format("%.0f - %.0f = %.0f", num1, num2, result);
        }
    }

    public String calculateMultiply(Double num1, Double num2) {
        double result = num1 * num2;
        if (num1 % 1 != 0 || num2 % 1 != 0) {
            return num1 + " * " + num2 + " = " + result;
        } else {
            return String.format("%.0f * %.0f = %.0f", num1, num2, result);
        }
    }

    public String calculateDivide(Double num1, Double num2) {
        if (num2 == 0) {
            return "Делить на ноль нельзя";
        }
        double result = num1 / num2;
        if (num1 % 1 != 0 || num2 % 1 != 0 || result % 1 != 0) {
            return num1 + " / " + num2 + " = " + result;
        } else {
            return String.format("%.0f / %.0f = %.0f", num1, num2, result);
        }
    }
}

