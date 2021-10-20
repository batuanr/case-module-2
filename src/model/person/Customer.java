package model.person;

import java.io.Serializable;

public class Customer extends Person implements Serializable {
    private String type;
    private String id;

    public Customer() {
    }

    public Customer(String name, String birthDate, String gender, String address, String phoneNumber, String id) {
        super(name, birthDate, gender, address, phoneNumber);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Customer: " + "Name: " +super.getName() +
                ", birthDate: " + super.getBirthDay() +
                ", Gender: " + super.getGender() +
                ", Phone Number: " + super.getPhoneNumber() +
                ", type:'" + type + '\'' +
                ", id:'" + id + '\'' +
                '}';
    }
}
