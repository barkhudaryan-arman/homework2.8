package controller;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // Возвращает список сотрудников по департаменту
    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByDepartment(@PathVariable int id) {
        return departmentService.getEmployeesByDepartment(id);
    }

    // Возвращает сумму зарплат по департаменту
    @GetMapping("/{id}/salary/sum")
    public double getSalarySumByDepartment(@PathVariable int id) {
        return departmentService.getSalarySumByDepartment(id);
    }

    // Возвращает максимальную зарплату по департаменту
    @GetMapping("/{id}/salary/max")
    public double getMaxSalaryByDepartment(@PathVariable int id) {
        return departmentService.getMaxSalaryByDepartment(id);
    }

    // Возвращает минимальную зарплату по департаменту
    @GetMapping("/{id}/salary/min")
    public double getMinSalaryByDepartment(@PathVariable int id) {
        return departmentService.getMinSalaryByDepartment(id);
    }

    // Возвращает сотрудников, сгруппированых по отделам
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployeesGroupedByDepartment() {
        return departmentService.getEmployeesGroupedByDepartment();
    }
}
