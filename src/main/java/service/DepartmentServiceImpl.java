package service;

import exception.EmployeeNotFoundException;
import model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int departmentId) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee getEmployeeWithMinSalary(int departmentId) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> getAll(Integer departmentId) {
        if (departmentId == null) {
            return employeeService.getAll().stream()
                    .sorted(Comparator.comparingInt(Employee::getDepartment)).toList();
        } else {
            return employeeService.getAll().stream()
                    .filter(e -> e.getDepartment() == departmentId).toList();
        }
    }
}

