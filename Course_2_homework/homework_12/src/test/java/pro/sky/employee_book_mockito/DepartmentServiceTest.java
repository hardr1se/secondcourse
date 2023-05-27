package pro.sky.employee_book_mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.employee_book_mockito.service.DepartmentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    DepartmentService departmentService;
    Employee employee = new Employee("Скороходов Виталий Петрович");

    @Test
    public void maxSalaryEmployeeInDepartmentTest() {
        Mockito.when(departmentService.maxSalaryEmployeeInDepartment(anyInt())).thenReturn(employee);
        assertEquals(employee, departmentService.maxSalaryEmployeeInDepartment(anyInt()));
    }

    @Test
    public void minSalaryEmployeeInDepartmentTest() {
        Mockito.when(departmentService.minSalaryEmployeeInDepartment(anyInt())).thenReturn(employee);
        assertEquals(employee, departmentService.minSalaryEmployeeInDepartment(anyInt()));
    }

    @Test
    public void allEmployeeInDepartmentTest() {
        Mockito.when(departmentService.allInDepartment(anyInt())).thenReturn(new ArrayList<>(List.of(employee)));
        assertEquals(new ArrayList<>(List.of(employee)), departmentService.allInDepartment(anyInt()));
    }

    @Test
    public void sumSalariesInDepartmentTest() {
        int actual = 60_000;
        Mockito.when(departmentService.sumSalariesInDepartment(anyInt())).thenReturn(actual);
        assertEquals(actual, departmentService.sumSalariesInDepartment(anyInt()));
    }

    @Test
    public void allByDepartmentTest() {
        Map<Integer, List<Employee>> actual = new HashMap<>(Map.of(1, new ArrayList<>(List.of(employee))));
        Mockito.when(departmentService.allByDepartment()).thenReturn(actual);
        assertEquals(actual, departmentService.allByDepartment());
    }
}
