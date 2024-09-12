package service;

import model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Employee> getEmployeesByDepartment(int departmentId);

    double getSalarySumByDepartment(int departmentId);

    double getMaxSalaryByDepartment(int departmentId);

    double getMinSalaryByDepartment(int departmentId);

    Map<Integer, List<Employee>> getEmployeesGroupedByDepartment();
}
