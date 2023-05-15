package pro.sky.collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.calculator.service.CalculatorService;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CollectionsApplicationParameterizedTests {
    CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("provideParams")
    void countTest(Integer num1, Integer num2, String operation) {
        Integer result = 0;
        switch (operation) {
            case "+" -> { result = num1 + num2; }
            case "-" -> { result = num1 - num2; }
            case "*" -> { result = num1 * num2; }
            case "/" -> { result = num1 / num2; }
        }
        assertEquals(result, calculatorService.calculate(num1, num2, operation));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForException")
    void exceptionsTest(Integer num1, Integer num2, String operation) {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.calculate(num1, num2, operation));
    }

    public static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of(5, 5, "-"),
                Arguments.of(5, 5, "+"),
                Arguments.of(5, 5, "*"),
                Arguments.of(5, 5, "/"),
                Arguments.of(10, 10, "-"),
                Arguments.of(10, 10, "+"),
                Arguments.of(10, 10, "*"),
                Arguments.of(10, 10, "/")
        );
    }

    public static Stream<Arguments> provideParamsForException() {
        return Stream.of(
                Arguments.of(5, 0, "/"),
                Arguments.of(5, null, "/"),
                Arguments.of(null, 5, "/"),
                Arguments.of(null, null, "/")
        );
    }
}
