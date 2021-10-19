package model.person;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee extends Person implements Serializable {
    private int salary;
    private int hardSalary;
    private int bonus;
    private String password;

    public Employee() {
    }

    public Employee(String name, LocalDate birthDate, String gender, String address, String phoneNumber, int hardSalary) {
        super(name, birthDate, gender, address, phoneNumber);
        this.hardSalary = hardSalary;
        this.password = "12345678";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getHardSalary() {
        return hardSalary;
    }

    public void setHardSalary(int hardSalary) {
        this.hardSalary = hardSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Employee: " + super.toString();
    }
}
