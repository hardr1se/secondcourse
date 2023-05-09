package pro.sky.collections;

import org.junit.jupiter.api.Test;
import pro.sky.calculator.service.CalculatorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CollectionsApplicationTests {
	private final CalculatorService calculatorService = new CalculatorService();
	private final Integer num1 = 5;
	private final Integer num2 = 5;
	private final Integer num3 = 10;
	private final Integer num4 = 10;

	@Test
	void exceptionsTest() {
		assertThrows(IllegalArgumentException.class, () -> calculatorService.calculate(num1, 0, "/"));
		assertThrows(IllegalArgumentException.class, () -> calculatorService.calculate(num1, null, "/"));
		assertThrows(IllegalArgumentException.class, () -> calculatorService.calculate(null, num2, "/"));
		assertThrows(IllegalArgumentException.class, () -> calculatorService.calculate(null, null, "/"));
	}

	@Test
	void plusTest() {
		Integer result = num1 + num2;
		assertEquals(result, calculatorService.calculate(num1, num2, "+"));
		result = num3 + num4;
		assertEquals(result, calculatorService.calculate(num3, num4, "+"));
	}

	@Test
	void minusTest() {
		Integer result = num1 - num2;
		assertEquals(result, calculatorService.calculate(num1, num2, "-"));
		result = num3 - num4;
		assertEquals(result, calculatorService.calculate(num3, num4, "-"));
	}

	@Test
	void multiplyTest() {
		Integer result = num1 * num2;
		assertEquals(result, calculatorService.calculate(num1, num2, "*"));
		result = num3 * num4;
		assertEquals(result, calculatorService.calculate(num3, num4, "*"));
	}

	@Test
	void divideTest() {
		Integer result = num1 / num2;
		assertEquals(result, calculatorService.calculate(num1, num2, "/"));
		result = num3 / num4;
		assertEquals(result, calculatorService.calculate(num3, num4, "/"));
	}
}
