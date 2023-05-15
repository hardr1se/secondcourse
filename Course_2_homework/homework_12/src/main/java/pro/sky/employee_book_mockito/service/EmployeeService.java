package pro.sky.employee_book_mockito.service;

import org.springframework.stereotype.Repository;
import pro.sky.employee_book_mockito.Employee;

import java.util.*;
import java.util.random.RandomGenerator;

@Repository
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee(generateFullName()), new Employee(generateFullName()),
            new Employee(generateFullName()), new Employee(generateFullName()),
            new Employee(generateFullName()), new Employee(generateFullName()),
            new Employee(generateFullName()), new Employee(generateFullName()),
            new Employee(generateFullName())
    ));
    private final int STATE = 10;

    public boolean addEmployee(Employee employee) {
        if (employee == null || employees.contains(employee)) {
            throw new IllegalArgumentException("Некорректно введены данные");
        } else if (employees.size() >= STATE) {
            throw new IllegalArgumentException("Список сотрудников переполнен");
        }
        return employees.add(employee);
    }

    public boolean findEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Некорректно введены данные");
        }
        return employees.contains(employee);
    }

    public boolean removeEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Некорректно введены данные");
        }
        if (employees.contains(employee)) {
            return employees.remove(employee);
        } else {
            throw new IllegalArgumentException("Пользователь не найден");
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    private String generateFullName() {
        String[] surname = {"Красноперов", "Костин", "Терешев", "Петрушин", "Воронихин"};
        String[] name = {"Петр", "Василий", "Маским", "Виталий", "Кирил"};
        String[] patronymicName = {"Петрович", "Витальевич", "Сергеевич", "Александрович", "Алексеевич"};
        return surname[RandomGenerator.getDefault().nextInt(0, surname.length)] + " " +
                name[RandomGenerator.getDefault().nextInt(0, name.length)] + " " +
                patronymicName[RandomGenerator.getDefault().nextInt(0, patronymicName.length)];
    }
}
