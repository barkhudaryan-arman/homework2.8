package service;

import model.Employee;
import org.springframework.stereotype.Service;
import repository.EmployeeBook;

import java.util.Collection;
import java.util.Comparator;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeBook employeeBook;

    public EmployeeServiceImpl(EmployeeBook employeeBook) {
        this.employeeBook = employeeBook;
    }

    @Override
    public Employee add(Employee employee) {
        return employeeBook.add(employee);
    }

    @Override
    public Employee remove(Employee employee) {
        return employeeBook.remove(employee);
    }


    @Override
    public Employee find(Employee employee) {
        return employeeBook.find(employee);
    }

    @Override
    public Collection<Employee> getAll() {
        return employeeBook.getEmployeeBook().stream()
                .sorted(Comparator.comparing(Employee::getFullName)).toList();
    }
}
