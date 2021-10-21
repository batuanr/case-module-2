package model.product;

import model.Category;
import model.Trademark;

import java.io.Serializable;

public class Milk extends Product implements Serializable {
    private Trademark trademark;

    public Milk() {
    }

    public Milk(String code, String name, int price, Category category, int quantity, Trademark trademark) {
        super(code, name, price, category, quantity);
        this.trademark = trademark;
    }

    public Trademark getTrademark() {
        return trademark;
    }

    public void setTrademark(Trademark trademark) {
        this.trademark = trademark;
    }


    @Override
    public String toString() {
        return "Milk{" + super.toString() +
                "  Trademark: '" + getTrademark() + '\'' +
                '}';
    }
}
