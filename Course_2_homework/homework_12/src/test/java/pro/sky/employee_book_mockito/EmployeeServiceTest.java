package pro.sky.employee_book_mockito;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pro.sky.employee_book_mockito.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {
	EmployeeService employeeService = new EmployeeService();
	Employee alreadyAddedEmployee = employeeService.getEmployees().get(0);
	Employee newEmployee = new Employee("Попов Петр Сергеевич");

	@Test
	public void addEmployeeTest() {
		assertTrue(employeeService.addEmployee(newEmployee));
	}

	@Test
	public void addEmployeeNegativeTest() {
		assertThrows(IllegalArgumentException.class, () -> employeeService.addEmployee(alreadyAddedEmployee));
		employeeService.addEmployee(new Employee("Петров Сергей Николаевич"));
		assertThrows(IllegalArgumentException.class, () ->
				employeeService.addEmployee(new Employee("Петров Николай Сергеевич")));
		assertThrows(IllegalArgumentException.class, () -> employeeService.addEmployee(null));
	}

	@Test
	public void findEmployeeTest() {
		assertTrue(employeeService.findEmployee(alreadyAddedEmployee));
	}

	@Test
	public void findEmployeeNegativeTest() {
		assertThrows(IllegalArgumentException.class, () -> employeeService.findEmployee(null));
	}

	@Test
	public void removeEmployeeTest() {
		assertTrue(employeeService.removeEmployee(alreadyAddedEmployee));
	}

	@Test
	public void removeEmployeeNegativeTest() {
		assertThrows(IllegalArgumentException.class, () -> employeeService.removeEmployee(null));
		assertThrows(IllegalArgumentException.class, () -> employeeService.removeEmployee(newEmployee));
	}
}
