package model.product;

public class Clothes extends Product{
    private String size;

    public Clothes() {
    }

    public Clothes(String name, int price, String category, String size) {
        super(name, price, category);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
