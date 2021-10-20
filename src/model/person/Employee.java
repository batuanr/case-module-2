package model.person;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee extends Person implements Serializable {
    private int hardSalary;
    private int bonus;
    private String password;
    private int fine;

    public Employee() {
    }

    public Employee(String name, String birthDay, String gender, String address, String phoneNumber, int hardSalary) {
        super(name, birthDay, gender, address, phoneNumber);
        this.hardSalary = hardSalary;
        this.password = "12345678";
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "Employee: Name: " + super.getName() +
                ", birthDate: " + super.getBirthDay() +
                ", Gender: " + super.getGender() +
                ", Phone Number: " + super.getPhoneNumber() +
                ", Lương cứng: " + hardSalary;
    }
}
