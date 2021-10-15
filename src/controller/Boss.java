package controller;

import model.person.Employee;

import java.util.ArrayList;
import java.util.List;

public class Boss extends Worker {
    private final String EMPLOYEE_FILE = "employee.obj";
    private final String BOSS_FILE = "boss.obj";
    private List<Employee> employeeList = new ArrayList<>();
    private String id;
    private String password;

    public Boss(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
