package service;

import model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface EmployeeService {
    Employee add(Employee employee);

    Employee remove(Employee employee);

    Employee find(Employee employee);

    Collection<Employee> getAll();

}
