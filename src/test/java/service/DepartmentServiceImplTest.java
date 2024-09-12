package service;

import model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.EmployeeBook;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    EmployeeServiceImpl employeeService;
    @InjectMocks
    DepartmentServiceImpl departmentService;
    Employee generalDirector = new Employee("Лисуненко", "Максим", "Викторович", 1, 220560);
    Employee deputyDirector = new Employee("Барсуков", "Андрей", "Юрьевич", 1, 190800);
    Employee generalAccountant = new Employee("Бятец", "Дмитрий", "Сергеевич", 2, 190800);
    Employee mainEngineer = new Employee("Сахно", "Маргарита", "Сергеевна", 3, 150240);
    @BeforeEach
    void init(){
        Mockito.when(employeeService.getAll()).thenReturn(List.of(generalAccountant,generalDirector,deputyDirector,mainEngineer));
    }
    @Test
    void getEmployeesByDepartment() {
        List<Employee> employeesByDepartment = departmentService.getEmployeesByDepartment(1);
        Assertions.assertIterableEquals(employeesByDepartment,List.of(generalDirector,deputyDirector));
    }

    @Test
    void getSalarySumByDepartment() {
        Assertions.assertEquals(departmentService.getSalarySumByDepartment(1),generalDirector.getSalary() + deputyDirector.getSalary());
    }

    @Test
    void getMaxSalaryByDepartment() {
        Assertions.assertEquals(departmentService.getMaxSalaryByDepartment(2),generalAccountant.getSalary());
    }

    @Test
    void getMinSalaryByDepartment() {
        Assertions.assertEquals(departmentService.getMinSalaryByDepartment(3),mainEngineer.getSalary());
    }

    @Test
    void getEmployeesGroupedByDepartment() {
        Map<Integer, List<Employee>> integerListMap = Map.of(1, List.of(deputyDirector, generalDirector), 2, List.of(generalAccountant), 3, List.of(mainEngineer));
        Map<Integer, List<Employee>> employeesGroupedByDepartment = departmentService.getEmployeesGroupedByDepartment();
        Assertions.assertEquals(integerListMap.size(), employeesGroupedByDepartment.size());
    }
}