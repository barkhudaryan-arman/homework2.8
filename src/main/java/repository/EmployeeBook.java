package repository;

import exception.EmployeeAlreadyAddedException;
import exception.EmployeeNotFoundException;
import exception.EmployeeStorageIsFullException;
import jakarta.annotation.PostConstruct;
import model.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeBook {
    private final static int maxCapacity = 10;
    private final Map<String, Employee> book = new HashMap<>();

    @PostConstruct
    public void init() {
        Employee generalDirector = new Employee("Лисуненко", "Максим", "Викторович", 1, 220560);
        Employee deputyDirector = new Employee("Барсуков", "Андрей", "Юрьевич", 1, 190800);
        Employee generalAccountant = new Employee("Бятец", "Дмитрий", "Сергеевич", 2, 190800);
        Employee mainEngineer = new Employee("Сахно", "Маргарита", "Сергеевна", 3, 150240);
        Employee mainTechnician = new Employee("Яша", "Лава", "Валерьевна", 3, 155240);
        Employee technician = new Employee("Малень", "Кихрен", "Валентинович", 4, 90800);
        Employee driver = new Employee("Ясосу", "Бибу", "Сергеевич", 4, 88550);
        Employee loader = new Employee("Мамут", "Рахал", "Алексеевич", 4, 65240);
        Employee receptionist = new Employee("Ягон", "Дон", "Викторовна", 5, 58550);
        Employee cleaner = new Employee("Привет", "Пострыжися", "Ивановна", 5, 45240);

        book.put(generalDirector.getFullName(), generalDirector);
        book.put(deputyDirector.getFullName(), deputyDirector);
        book.put(generalAccountant.getFullName(), generalAccountant);
        book.put(mainEngineer.getFullName(), mainEngineer);
        book.put(mainTechnician.getFullName(), mainTechnician);
        book.put(technician.getFullName(), technician);
        book.put(driver.getFullName(), driver);
        book.put(loader.getFullName(), loader);
        book.put(receptionist.getFullName(), receptionist);
        book.put(cleaner.getFullName(), cleaner);
    }

    public Collection<Employee> getEmployeeBook() {
        return this.book.values();
    }

    public Employee add(Employee employee) {
        if (book.size() == maxCapacity) throw new EmployeeStorageIsFullException();
        if (book.containsKey(employee.getFullName())) throw new EmployeeAlreadyAddedException();
        return this.book.put(employee.getFullName(), employee);
    }

    public Employee remove(Employee employee) {
        if (book.containsKey(employee.getFullName())) return book.remove(employee.getFullName());
        throw new EmployeeNotFoundException();
    }

    public Employee find(Employee employee) {
        if (book.get(employee.getFullName()) == null) throw new EmployeeNotFoundException();
        return book.get(employee.getFullName());
    }

}
