package model.product;

import model.Category;
import model.SizeClothes;

import java.io.Serializable;

public class Clothes extends Product implements Serializable {
    private SizeClothes size;

    public Clothes() {
    }

    public Clothes(String code, String name, int price, Category category, int quantity, SizeClothes size) {
        super(code, name, price, category, quantity);
        this.size = size;
    }

    public SizeClothes getSize() {
        return size;
    }

    public void setSize(SizeClothes size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Clothes{" + super.toString() +
                "size='" + getSize() + '\'' +
                '}';
    }
}
