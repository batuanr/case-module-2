package model;

import model.person.Customer;
import model.product.Product;

import java.time.LocalDate;

public class Order {
    private Customer customer;
    private Product product;
    private int orderQuantity;
    private int total;
    private LocalDate orderDay;

    public Order() {
    }

    public Order(Customer customer, Product product, int orderQuantity, int total, LocalDate orderDay) {
        this.customer = customer;
        this.product = product;
        this.orderQuantity = orderQuantity;
        this.total = total;
        this.orderDay = orderDay;
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
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", product=" + product +
                ", orderQuantity=" + orderQuantity +
                ", total=" + total +
                ", orderDay=" + orderDay +
                '}';
    }
}
