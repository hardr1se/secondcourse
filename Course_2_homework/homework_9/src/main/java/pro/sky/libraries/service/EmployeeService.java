package pro.sky.libraries.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.libraries.Employee;
import pro.sky.libraries.exceptions.EmployeeAlreadyAddedException;
import pro.sky.libraries.exceptions.EmployeeNotFoundException;
import pro.sky.libraries.exceptions.EmployeeStorageIsFullException;

@Service
public class EmployeeService {
    private List<Employee> people = new ArrayList(List.of(new Employee("Петр", "Петров"), new Employee("Павел", "Павлов"), new Employee("Алексей", "Алексеев"), new Employee("Николай", "Николаев"), new Employee("Александр", "Александров"), new Employee("Тихон", "Тихонов"), new Employee("Борис", "Борисов"), new Employee("Магомед", "Магомедов"), new Employee("Виталий", "Витальев"), new Employee("Артем", "Артемов")));
    private int state = 10;

    public EmployeeService() {
    }

    public String addEmployee(String firstName, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(firstName, lastName);
        if (this.people.size() > this.state) {
            throw new EmployeeStorageIsFullException("Не хаватает места в массиве, нужно удалить одного из сотрудников");
        } else if (this.people.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть в списке");
        } else {
            this.people.add(employee);
            return "Сотрудник успешно добавлен";
        }
    }

    public String removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (!this.people.contains(employee)) {
            throw new EmployeeNotFoundException("Удаление сотрудника невозможно, так как его нету в списке");
        } else {
            this.people.remove(this.people.stream().filter((x) -> {
                return x.equals(employee);
            }).findFirst().get());
            String var10000 = employee.getFirstName();
            return var10000 + " " + employee.getLastName() + " успешно удален из списка";
        }
    }

    public String findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName));
        if (!this.people.contains(employee)) {
            throw new EmployeeNotFoundException("" + employee + " не найден в списке");
        } else {
            return "" + employee + " успешно найден в списке";
        }
    }

    public String printEmployeesString() {
        return (String)this.people.stream().map(Employee::toString).collect(Collectors.joining(""));
    }

    public StringBuilder printEmployeesStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        this.people.forEach((x) -> {
            stringBuilder.append("" + x + "\n");
        });
        return stringBuilder;
    }
}