package service;

import model.Employee;

import java.util.Collection;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalary(int departmentId);

    Employee getEmployeeWithMinSalary(int departmentId);

    Collection<Employee> getAll(Integer departmentId);

}
