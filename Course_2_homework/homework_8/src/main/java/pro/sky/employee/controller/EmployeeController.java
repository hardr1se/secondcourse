package pro.sky.employee.controller;

import pro.sky.employee.Employee;
import pro.sky.employee.service.EmployeeService;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/max-salary")
    @NotNull
    public String maxSalaryEmployeeInDepartment
            (@RequestParam(value = "departmentId", required = false) Integer department) {
        if (department < 1 || department > 5) {
            return "У нас имеется только 5 отделов";
        } else {
            String employeeMax = employeeService.maxSalaryEmployeeInDepartment(department);
            return employeeMax.isEmpty() ? "В этом отделе нету сотрудников" : employeeMax;
        }
    }

    @GetMapping(path = "/min-salary")
    @NotNull
    public String minSalaryEmployeeInDepartment
            (@RequestParam(value = "departmentId", required = false) Integer department) {
        if (department < 1 || department > 5) {
            return "У нас имеется только 5 отделов";
        } else {
            String employeeMin = employeeService.minSalaryEmployeeInDepartment(department);
            return employeeMin.isEmpty() ? "В этом отделе нету сотрудников" : employeeMin;
        }
    }

    @GetMapping ("/all")
    public String allInDepartment
            (@RequestParam(value = "departmentId", required = false) Integer department) {
        if (department == null){
            return employeeService.all();
        } else if (department < 1 || department > 5) {
            return "У нас имеется только 5 отделов";
        } else {
            String result = employeeService.allInDepartment(department);
            return result.isEmpty() ? "В этом отделе нету сотрудников" : result;
        }
    }
}