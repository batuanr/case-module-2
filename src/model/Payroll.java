package model;

import model.person.Employee;

public class Payroll {
    private String code;
    private Employee employee;
    private int salary;
    private int month;

    public Payroll() {
    }

    public Payroll(String code, Employee employee, int salary, int month) {
        this.code = code;
        this.employee = employee;
        this.salary = salary;
        this.month = month;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Payroll{" +
                "code='" + code + '\'' +
                ", employee=" + employee +
                ", salary=" + salary +
                ", month=" + month +
                '}';
    }
}
