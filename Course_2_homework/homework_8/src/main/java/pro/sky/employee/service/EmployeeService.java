package pro.sky.employee.service;

import pro.sky.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
                .toString();
    }

    public String all() {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getDivision))
                .toString();
    }
}
