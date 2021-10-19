package model.product;

import java.io.Serializable;

public class Clothes extends Product implements Serializable {
    private String size;

    public Clothes() {
    }

    public Clothes(String code, String name, int price, String category, int quantity, String size) {
        super(code, name, price, category, quantity);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Clothes{" + super.toString() +
                "size='" + size + '\'' +
                '}';
    }
}
