package model.person;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private String name;
    private String birthDay;
    private String gender;
    private String address;
    private String phoneNumber;

    public Person() {
    }

    public Person(String name, String birthDay, String gender, String address, String phoneNumber) {
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
