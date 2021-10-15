package model.product;

import java.time.LocalDate;

public class Milk extends Product{
    private String manufacturer;
    private LocalDate manufactureDate;
    private LocalDate expiryDate;

    public Milk() {
    }

    public Milk(String code, String name, int price, String category, int quantity, String manufacturer) {
        super(code, name, price, category, quantity);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Milk{" +
                "manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
