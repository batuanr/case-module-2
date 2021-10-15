package controller;

import model.person.Customer;
import model.product.Clothes;
import model.product.Milk;
import storage.IO;

import java.util.ArrayList;
import java.util.List;

public class Worker {
    private final String MILK_FILE = "milk.obj";
    private final String CLOTHES_FILE = "clothes.obj";
    private final String CUSTOMER_FILE = "customer.obj";
    private List<Milk> milkList = new ArrayList();
    private List<Clothes> clothesList = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();

    public Worker() {
        milkList = IO.readToFile(MILK_FILE);
        clothesList = IO.readToFile(CLOTHES_FILE);
        customerList = IO.readToFile(CUSTOMER_FILE);
    }

    public List<Milk> getMilkList() {
        return milkList;
    }

    public void setMilkList(List<Milk> milkList) {
        this.milkList = milkList;
    }

    public List<Clothes> getClothesList() {
        return clothesList;
    }

    public void setClothesList(List<Clothes> clothesList) {
        this.clothesList = clothesList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
