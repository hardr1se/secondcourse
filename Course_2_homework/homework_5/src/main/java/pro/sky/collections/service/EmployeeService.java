package pro.sky.collections.service;

import org.springframework.stereotype.Service;
import pro.sky.collections.Employee;
import pro.sky.collections.exceptions.EmployeeAlreadyAddedException;
import pro.sky.collections.exceptions.EmployeeNotFoundException;
import pro.sky.collections.exceptions.EmployeeStoragelsFullException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private List<Employee> people = new ArrayList<>(List.of(
            new Employee("Петр", "Петров"),
            new Employee("Павел", "Павлов"),
            new Employee("Алексей", "Алексеев"),
            new Employee("Николай", "Николаев"),
            new Employee("Александр", "Александров"),
            new Employee("Тихон", "Тихонов"),
            new Employee("Борис", "Борисов"),
            new Employee("Магомед", "Магомедов"),
            new Employee("Виталий", "Витальев"),
            new Employee("Артем", "Артемов")
    ));
    private int state = 10; // Штат этого предприятия насчитывает 10 должностей

    public String addEmployee(String firstName, String lastName) throws EmployeeStoragelsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(firstName, lastName);
        if (people.size() > state) {
            throw new EmployeeStoragelsFullException("Не хаватает места в массиве, нужно удалить одного из сотрудников");
        }
        if (people.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть в списке");
        }
        people.add(employee);
        return "Сотрудник успешно добавлен";
    }

    public String removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (!people.contains(employee)) {
            throw new EmployeeNotFoundException("Удаление сотрудника невозможно, так как его нету в списке");
        } else {
            people.remove(people.stream().filter(x -> x.equals(employee)).findFirst().get());
            return employee.getFirstName() + " " + employee.getLastName() + " успешно удален из списка";
        }
    }

    public String findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (!people.contains(employee)) {
            throw new EmployeeNotFoundException(employee + " не найден в списке");
        } else {
            return employee + " успешно найден в списке";
        }
    }

    public String printEmployeesString() {
        return people.stream().map(Employee::toString).collect(Collectors.joining("\n"));
    }

    public StringBuilder printEmployeesStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        people.forEach(x -> stringBuilder.append(x + "\n"));
        return stringBuilder;
    }
}
