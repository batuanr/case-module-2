package controller;

import model.Order;
import model.person.Customer;
import model.product.Clothes;
import model.product.Milk;
import storage.IO;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Worker {
    private IO io = IO.getInstance();
    private final String ORDER_FILE = "order.obj";
    private final String MILK_FILE = "milk.obj";
    private final String CLOTHES_FILE = "clothes.obj";
    private final String CUSTOMER_FILE = "customer.obj";
    private List<Order> orderList = new ArrayList<>();
    private List<Milk> milkList = new ArrayList();
    private List<Clothes> clothesList = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();

    public Worker() {
        orderList = io.readToFile(ORDER_FILE);
        milkList = io.readToFile(MILK_FILE);
        clothesList = io.readToFile(CLOTHES_FILE);
        customerList = io.readToFile(CUSTOMER_FILE);
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
//add
    public void addOrder(Order order){
        orderList.add(order);
        io.writeFile(ORDER_FILE, orderList);
    }
    public void addMilk(Milk milk){
        milkList.add(milk);
        io.writeFile(MILK_FILE, milkList);
    }
    public void addClothes(Clothes clothes){
        clothesList.add(clothes);
        io.writeFile(CLOTHES_FILE, clothesList);
    }
    public void addCustomer(Customer customer){
        customerList.add(customer);
        io.writeFile(CUSTOMER_FILE, customerList);
    }
//    find
    public Milk findMilkByCode(String code) throws FileNotFoundException {
        for (Milk milk: milkList){
            if (milk.getCode().equals(code)){
                return milk;
            }
        }
        throw new FileNotFoundException();
    }
    public Clothes findClothesByCode(String code) throws FileNotFoundException {
        for (Clothes clothes: clothesList){
            if (clothes.getCode().equals(code)){
                return clothes;
            }
        }
        throw new FileNotFoundException();
    }
    public Customer findCustomerByPhoneNumber(String phoneNumber) throws FileNotFoundException {
        for (Customer customer: customerList){
            if (customer.getPhoneNumber().equals(phoneNumber)){
                return customer;
            }
        }
        throw new FileNotFoundException();
    }
    public List<Milk> findMilkByCategory(String category){
        List<Milk> milks = new ArrayList<>();
        for (Milk milk: milkList){
            if (milk.getCategory().equals(category)){
                milks.add(milk);
            }
        }
        return milks;
    }
    public List<Milk> findMilkByManufacturer(String manufacturer){
        List<Milk> milks = new ArrayList<>();
        for (Milk milk: milkList){
            if (milk.getManufacturer().equals(manufacturer)){
                milks.add(milk);
            }
        }
        return milks;
    }
    public List<Clothes> findClothesByCategory(String category){
        List<Clothes> clothess = new ArrayList<>();
        for (Clothes clothes: clothesList){
            if (clothes.getCategory().equals(category)){
                clothesList.add(clothes);
            }
        }
        return clothess;
    }
    public List<Order> findOrderByPhoneNumber(String phoneNumber){
        List<Order> orders = new ArrayList<>();
        for (Order order: orderList){
            if (order.getCustomer().getPhoneNumber().equals(phoneNumber)){
                orders.add(order);
            }
        }
        return orders;
    }

//    edit
    public void editMilk(String code,Milk milk){
        for (int i = 0; i < milkList.size(); i++) {
            if (milkList.get(i).getCode().equals(code)){
                milkList.set(i, milk);
                io.writeFile(MILK_FILE, milkList);
                break;
            }
        }
    }
    public void editClothes(String code, Clothes clothes){
        for (int i = 0; i < clothesList.size(); i++) {
            if (clothesList.get(i).getCode().equals(code)){
                clothesList.set(i, clothes);
                io.writeFile(CLOTHES_FILE, clothesList);
                break;
            }
        }
    }
    public void editCustomer(String phoneNumber, Customer customer){
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getPhoneNumber().equals(phoneNumber)){
                customerList.set(i, customer);
                io.writeFile(CUSTOMER_FILE, customerList);
                break;
            }
        }
    }
//    delete
    public Milk removeMilk(String code) throws FileNotFoundException{
        Milk milk = findMilkByCode(code);
        milkList.remove(milk);
        io.writeFile(MILK_FILE, milkList);
        return milk;
    }
    public Clothes removeClothes(String code) throws FileNotFoundException{
        Clothes clothes = findClothesByCode(code);
        clothesList.remove(clothes);
        io.writeFile(CLOTHES_FILE, clothesList);
        return clothes;
    }
    public Customer removeCustomer(String phoneNumber) throws FileNotFoundException{
        Customer customer = findCustomerByPhoneNumber(phoneNumber);
        customerList.remove(customer);
        io.writeFile(CUSTOMER_FILE, customerList);
        return customer;
    }
}
