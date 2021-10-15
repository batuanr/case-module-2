package model.person;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer extends Person implements Serializable {
    private String type;
    private String id;

    public Customer() {
    }

    public Customer(String name, LocalDate birthDate, String gender, String address, String phoneNumber, String type, String id) {
        super(name, birthDate, gender, address, phoneNumber);
        this.type = type;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
