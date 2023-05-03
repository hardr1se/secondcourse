package pro.sky.employee.service;

import pro.sky.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee(), new Employee(), new Employee(), new Employee(), new Employee(),
            new Employee(), new Employee(), new Employee(), new Employee(), new Employee()
    ));

    public String maxSalaryEmployeeInDepartment(int department) {
        return employees.stream()
                .filter(div -> div.getDivision() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .toString();
    }

    public String minSalaryEmployeeInDepartment(int department) {
        return employees.stream()
                .filter(div -> div.getDivision() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .toString();
    }

    public String allInDepartment(int department) {
        return employees.stream()
                .filter(div -> div.getDivision() == department)
                .toList().toString();
    }

    public String all() {
        int maxDepartment = employees.stream()
                .max(Comparator.comparing(Employee::getDivision))
                .get().getDivision();
        Map<String, List<Employee>> result = new HashMap<>();
        for (int i = 1; i <= maxDepartment; i++) {
            int iEx = i;
            result.put("Сотрудники " + i + " отдела", employees.stream().filter(x -> x.getDivision() == iEx).toList());
        }
        return result.toString();
    }
}
