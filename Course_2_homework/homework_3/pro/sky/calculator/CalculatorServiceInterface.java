package pro.sky.calculator;

public interface CalculatorServiceInterface {

    String welcome();
    String calculatePlus(Double num1, Double num2);
    String calculateMinus(Double num1, Double num2);
    String calculateMultiply(Double num1, Double num2);
    String calculateDivide(Double num1, Double num2);
}
