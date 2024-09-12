package service;

import model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.EmployeeBook;
import service.EmployeeService;
import service.EmployeeServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
   @Mock
   EmployeeBook employeeBook;
   @InjectMocks
   EmployeeServiceImpl employeeServiceImpl;
   Employee generalDirector = new Employee("Лисуненко", "Максим", "Викторович", 1, 220560);
    @Test
    void testGetAll(){
        Mockito.when(employeeBook.getEmployeeBook()).thenReturn(List.of(generalDirector));
        Collection<Employee> all = employeeServiceImpl.getAll();
        Assertions.assertEquals(all.size(),1);
    }
    @Test
    void testAdd(){
        Mockito.when(employeeBook.add(generalDirector)).thenReturn(generalDirector);
        Assertions.assertEquals(employeeServiceImpl.add(generalDirector),generalDirector);
    }
    @Test
    void testRemove(){
        Mockito.when(employeeBook.remove(generalDirector)).thenReturn(generalDirector);
        Assertions.assertEquals(employeeServiceImpl.remove(generalDirector),generalDirector);
    }
    @Test
    void testFind(){
        Mockito.when(employeeBook.find(generalDirector)).thenReturn(generalDirector);
        Assertions.assertEquals(employeeServiceImpl.find(generalDirector),generalDirector);
    }

}
