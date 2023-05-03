package pro.sky.libraries.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.libraries.exceptions.EmployeeBadRequest;
import pro.sky.libraries.service.EmployeeService;

@RestController
@RequestMapping(
        path = {"/employee"}
)
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(
            path = {"/add"}
    )
    public String addEmployee(@RequestParam(value = "firstName",required = false) String firstName, @RequestParam(value = "lastName",required = false) String lastName) {
        if (!StringUtils.isAnyEmpty(new CharSequence[]{firstName, lastName}) && StringUtils.isAlpha(firstName + lastName)) {
            this.employeeService.addEmployee(firstName, lastName);
            return "Сотрудник успешно добавлен";
        } else {
            throw new EmployeeBadRequest("Введеные данные не соответствует требованиям");
        }
    }

    @GetMapping(
            path = {"/remove"}
    )
    public String removeEmployee(@RequestParam(value = "firstName",required = false) String firstName, @RequestParam(value = "lastName",required = false) String lastName) {
        if (!StringUtils.isAnyEmpty(new CharSequence[]{firstName, lastName}) && StringUtils.isAlpha(firstName + lastName)) {
            return this.employeeService.removeEmployee(firstName, lastName);
        } else {
            throw new EmployeeBadRequest("Введеные данные не соответствует требованиям");
        }
    }

    @GetMapping(
            path = {"/find"}
    )
    public String findEmployee(@RequestParam(value = "firstName",required = false) String firstName, @RequestParam(value = "lastName",required = false) String lastName) {
        if (!StringUtils.isAnyEmpty(new CharSequence[]{firstName, lastName}) && StringUtils.isAlpha(firstName + lastName)) {
            return this.employeeService.findEmployee(firstName, lastName);
        } else {
            throw new EmployeeBadRequest("Введеные данные не соответствует требованиям");
        }
    }

    @GetMapping(
            path = {"/print"}
    )
    public String printAll() {
        return this.employeeService.printEmployeesString();
    }

    @ExceptionHandler({EmployeeBadRequest.class})
    public ResponseEntity<String> employeeBadRequestHandler() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Не корректно введены данные");
    }
}