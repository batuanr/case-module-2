package model.product;

import model.Category;

import java.io.Serializable;
import java.time.LocalDate;

public class Milk extends Product implements Serializable {
    private String manufacturer;

    public Milk() {
    }

    public Milk(String code, String name, int price, Category category, int quantity, String manufacturer) {
        super(code, name, price, category, quantity);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


    @Override
    public String toString() {
        return "Milk{" + super.toString() +
                "  manufacturer='" + getManufacturer() + '\'' +
                '}';
    }
}
