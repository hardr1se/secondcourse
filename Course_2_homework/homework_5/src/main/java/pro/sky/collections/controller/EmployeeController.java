package pro.sky.collections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collections.exceptions.EmployeeAlreadyAddedException;
import pro.sky.collections.exceptions.EmployeeNotFoundException;
import pro.sky.collections.exceptions.EmployeeStoragelsFullException;
import pro.sky.collections.service.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    EmployeeService employeeService = new EmployeeService();

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                              @RequestParam(value = "lastName", required = false) String lastName) {
        if (firstName == null || lastName == null) {
            return "Вы не ввели все значения";
        }
        try {
            employeeService.addEmployee(firstName, lastName);
            return "Сотрудник успешно добавлен";
        } catch (EmployeeStoragelsFullException | EmployeeAlreadyAddedException e) {
            return e.getMessage();
        }

    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                                 @RequestParam(value = "lastName", required = false) String lastName) {
        if (firstName == null || lastName == null) {
            return "Вы не ввели все значения";
        }
        try {
            return employeeService.removeEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                               @RequestParam(value = "lastName", required = false) String lastName) {
        if (firstName == null || lastName == null) {
            return "Вы не ввели все значения";
        }
        try {
            return employeeService.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/print")
    public String printAll() {
        return employeeService.printEmployeesString();
    }
}
