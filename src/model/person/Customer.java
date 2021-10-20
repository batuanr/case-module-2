package model.person;

import model.CustomerType;

import java.io.Serializable;

public class Customer extends Person implements Serializable {
    private CustomerType type;
    private String id;
    private int totalMoney;

    public Customer() {
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Customer(String name, String birthDate, String gender, String address, String phoneNumber, String id) {
        super(name, birthDate, gender, address, phoneNumber);
        this.id = id;
        type = CustomerType.PLAIN;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Customer: " + "Name: " +super.getName() +
                ", birthDate: " + super.getBirthDay() +
                ", Gender: " + super.getGender() +
                ", Phone Number: " + super.getPhoneNumber() +
                ", type:'" + getType() + '\'' +
                ", id:'" + id + '\'' + " Total money: " + totalMoney;
    }
}
