package service;

import model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    // Это просто пример, вам необходимо заменить на реальный источник данных, например, репозиторий
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> getEmployeesByDepartment(int departmentId) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .toList();
    }

    @Override
    public double getSalarySumByDepartment(int departmentId) {
        return getEmployeesByDepartment(departmentId)
                .stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    @Override
    public double getMaxSalaryByDepartment(int departmentId) {
        return getEmployeesByDepartment(departmentId)
                .stream()
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0);
    }

    @Override
    public double getMinSalaryByDepartment(int departmentId) {
        return getEmployeesByDepartment(departmentId)
                .stream()
                .mapToDouble(Employee::getSalary)
                .min()
                .orElse(0);
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesGroupedByDepartment() {
        return employeeService.getAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
