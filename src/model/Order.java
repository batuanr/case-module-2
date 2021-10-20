package model;

import model.person.Customer;
import model.product.Product;

import java.io.Serializable;
import java.time.LocalDate;

public class Order implements Serializable {
    private String code;
    private Customer customer;
    private Product product;
    private int orderQuantity;
    private int total;
    private LocalDate orderDay;

    public Order() {
    }

    public Order(String code, Customer customer, Product product, int orderQuantity) {
        this.code = code;
        this.customer = customer;
        this.product = product;
        this.orderQuantity = orderQuantity;
        this.orderDay = LocalDate.now();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(LocalDate orderDay) {
        this.orderDay = orderDay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public int getTotal() {
        if (checkQuantity()){
            total = product.getPrice() * orderQuantity;
            product.setQuantity(product.getQuantity() - orderQuantity);
            if(customer.getType().equals("kim cương")){
                total = total * 90/100;
            }
            else {
                if(customer.getType().equals("Vàng")){
                    total = total * 95/100;
                }
                else{
                    if(customer.getType().equals("Bạc")){
                        total = total*98/100;
                    }
                }
            }

            return total;
        }
        throw new RuntimeException("Hết hàng");
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public boolean checkQuantity(){
        return (product.getQuantity() >= orderQuantity);
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", product=" + product +
                ", orderQuantity=" + orderQuantity +
                ", total=" + getTotal() +
                ", orderDay=" + orderDay +
                '}';
    }
}
