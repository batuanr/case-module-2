package model.product;

abstract class Product {
    private String code;
    private String name;
    private int price;
    private String category;
    private int quantity;

    public Product() {
    }

    public Product(String code, String name, int price, String category, int quantity) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
