package ru.skillbench.tasks.basics.entity;

public class EmployeeImpl implements Employee {
    private int salary = 1000;
    private String firstName;
    private String lastName;
    private Employee manager;

    public EmployeeImpl() {
        salary = 1000;
        firstName = "";
        lastName = "";
        manager = null;
    }

    public EmployeeImpl(int salary) {
        this.salary = salary;
        firstName = "";
        lastName = "";
        manager = null;
    }

    public EmployeeImpl(int salary, String firstName, String lastName, Employee manager) {
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
        this.manager = manager;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void increaseSalary(int value) {
        salary += value;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public String getManagerName() {
        if (manager != null) {
            return manager.getFullName();
        } else {
            return "No manager";
        }
    }

    @Override
    public Employee getTopManager() {
        //TODO: рекурсивный вызов getManager()
        if (manager != null) {
            return manager.getTopManager();
        } else {
            return this;
        }
    }
}
