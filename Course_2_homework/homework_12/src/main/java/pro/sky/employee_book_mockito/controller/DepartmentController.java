package pro.sky.employee_book_mockito.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employee_book_mockito.Employee;
import pro.sky.employee_book_mockito.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "/{id}/employees", method = RequestMethod.GET)
    public String getAllEmployeesInDepartment(@PathVariable Integer id) {
        return "Список сотрудников " + id + " отдела\n" +
        departmentService.allInDepartment(id).toString();
    }

    @RequestMapping(value = "/{id}/salary/sum", method = RequestMethod.GET)
    public String getSumSalariesInDepartment(@PathVariable Integer id) {
        return "Сумма зарплат сотрудников " + id + " отдела равняется " +
                departmentService.sumSalariesInDepartment(id);
    }

    @RequestMapping(value = "/{id}/salary/max", method = RequestMethod.GET)
    public String getEmployeeMaxSalaryInDepartment(@PathVariable Integer id) {
        return "Сотрудник с самой большой зарплатой в " + id + " отделе - " +
                departmentService.maxSalaryEmployeeInDepartment(id);
    }

    @RequestMapping(value = "/{id}/salary/min", method = RequestMethod.GET)
    public String getEmployeeMinSalaryInDepartment(@PathVariable Integer id) {
        return "Сотрудник с самой маленькой зарплатой в " + id + " отделе - " +
                departmentService.minSalaryEmployeeInDepartment(id);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public Map<Integer, List<Employee>> getAllEmployeesInMap() {
        return departmentService.allByDepartment();
    }
}
