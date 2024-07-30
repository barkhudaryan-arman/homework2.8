package controller;

import model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeBookController {
    private final EmployeeService employeeService;

    public EmployeeBookController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Collection<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("lastName") String lastName,
                        @RequestParam("firstName") String firstName,
                        @RequestParam("midlName") String midlName) {
        Employee employee = new Employee(lastName, firstName, midlName);
        employeeService.add(employee);
        return employee;
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("lastName") String lastName,
                           @RequestParam("firstName") String firstName,
                           @RequestParam("midlName") String midlName) {
        return employeeService.remove(new Employee(lastName, firstName, midlName));
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("lastName") String lastName,
                         @RequestParam("firstName") String firstName,
                         @RequestParam("midlName") String midlName) {
        return employeeService.find(new Employee(lastName, firstName, midlName));
    }
}
