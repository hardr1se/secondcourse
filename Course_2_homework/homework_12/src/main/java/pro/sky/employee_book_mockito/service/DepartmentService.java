package pro.sky.employee_book_mockito.service;

import org.springframework.stereotype.Service;
import pro.sky.employee_book_mockito.Employee;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {
    EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee maxSalaryEmployeeInDepartment(int division) {
        return employeeService.getEmployees().stream()
                .filter(div -> div.getDivision() == division)
                .max(Comparator.comparing(Employee::getSalary))
                .get();
    }

    public Employee minSalaryEmployeeInDepartment(int division) {
        return employeeService.getEmployees().stream()
                .filter(div -> div.getDivision() == division)
                .min(Comparator.comparing(Employee::getSalary))
                .get();
    }

    public List<Employee> allInDepartment(int division) {
        return employeeService.getEmployees().stream()
                .filter(div -> div.getDivision() == division)
                .toList();
    }

    public Integer sumSalariesInDepartment(int division) {
        return employeeService.getEmployees().stream()
                .filter(div -> div.getDivision() == division)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public Map<Integer, List<Employee>> allByDepartment() {
        int maxDepartment = employeeService.getEmployees().stream()
                .max(Comparator.comparing(Employee::getDivision))
                .get().getDivision();
        Map<Integer, List<Employee>> result = new HashMap<>();
        for (int i = 1; i <= maxDepartment; i++) {
            int key = i;
            result.put(key, employeeService.getEmployees().stream()
                    .filter(x -> x.getDivision() == key)
                    .toList());
        }
        return result;
    }
}
