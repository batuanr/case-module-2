package model.person;

import java.time.LocalDate;

public class Employee extends Person{
    private int salary;
    private int hardSalary;
    private int bonus;
    private String password;

    public Employee() {
    }

    public Employee(String name, LocalDate birthDate, String gender, String address, String phoneNumber, int salary, int hardSalary, int bonus) {
        super(name, birthDate, gender, address, phoneNumber);
        this.salary = salary;
        this.hardSalary = hardSalary;
        this.bonus = bonus;
        this.password = "12345";
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
}
