package model.product;

import model.Category;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private String code;
    private String name;
    private int price;
    private Category category;
    private int quantity;

    public Product() {
    }

    public Product(String code, String name, int price, Category category, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "code:'" + code + '\'' +
                ", name:'" + name + '\'' +
                ", price: " + price +
                ", category'" + category + '\'' +
                ", quantity:" + quantity ;
    }
}
