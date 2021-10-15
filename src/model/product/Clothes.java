package model.product;

public class Clothes extends Product{
    private String size;

    public Clothes() {
    }

    public Clothes(String name, int price, String category, int quantity, String size) {
        super(name, price, category, quantity);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
