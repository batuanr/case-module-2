package model;

import model.person.Employee;

import java.io.Serializable;

public class Payroll implements Serializable {
    private String code;
    private Employee employee;
    private int salary;
    private int month;

    public Payroll() {
    }

    public Payroll(String code, Employee employee, int month, int bonus, int fine) {
        this.code = code;
        this.employee = employee;
        this.month = month;
        this.employee.setFine(fine);
        this.employee.setBonus(bonus);
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
        salary = employee.getHardSalary() + employee.getBonus() - employee.getFine();
        return salary;
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
                "code:'" + code + '\'' +
                ", Name: " + employee.getName() +
                ", lương cứng " + employee.getHardSalary() +
                ", thưởng : " + employee.getBonus() + "VND" +
                ", phạt: " + employee.getFine() + "VND" +
                ", salary: " + getSalary() + "VND" +
                ", month " + month +
                '}';
    }
}
