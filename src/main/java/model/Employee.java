package model;

import java.util.Objects;

public class Employee {
    private static int idGenerator;
    private final int id;
    private final String fullName;
    private int department;
    private int salary;

    public Employee(String lastName, String firstName, String midlName) {
        idGenerator++;
        this.id = idGenerator;
        this.fullName = String.format("%s %s %s", lastName, firstName, midlName);
    }

    public Employee(String lastName, String firstName, String midlName, int department, int salary) {
        idGenerator++;
        this.id = idGenerator;
        this.fullName = String.format("%s %s %s", lastName, firstName, midlName);
        this.department = department;
        this.salary = salary;
    }

    public static int getIdGenerator() {
        return idGenerator;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName);
    }

    @Override
    public String toString() {
        return String.format("id: %d\nФ.И.О.: %s\nОтдел: %d\nЗарплата: %d;\n", id, fullName, department, salary);
    }
}
