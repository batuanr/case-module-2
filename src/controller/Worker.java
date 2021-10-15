package controller;

import model.person.Customer;
import model.product.Clothes;
import model.product.Milk;
import storage.IO;

import java.io.FileNotFoundException;
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
//add
    public void addMilk(Milk milk){
        milkList.add(milk);
        IO.writeFile(MILK_FILE, milkList);
    }
    public void addClothes(Clothes clothes){
        clothesList.add(clothes);
        IO.writeFile(CLOTHES_FILE, clothesList);
    }
    public void addCustomer(Customer customer){
        customerList.add(customer);
        IO.writeFile(CUSTOMER_FILE, customerList);
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
//    edit
    public void editMilk(String code,Milk milk){
        for (int i = 0; i < milkList.size(); i++) {
            if (milkList.get(i).getCode().equals(code)){
                milkList.set(i, milk);
                IO.writeFile(MILK_FILE, milkList);
                break;
            }
        }
    }
    public void editClothes(String code, Clothes clothes){
        for (int i = 0; i < clothesList.size(); i++) {
            if (clothesList.get(i).getCode().equals(code)){
                clothesList.set(i, clothes);
                IO.writeFile(CLOTHES_FILE, clothesList);
                break;
            }
        }
    }
    public void editCustomer(String phoneNumber, Customer customer){
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getPhoneNumber().equals(phoneNumber)){
                customerList.set(i, customer);
                IO.writeFile(CUSTOMER_FILE, customerList);
                break;
            }
        }
    }
//    delete
    public Milk removeMilk(String code) throws FileNotFoundException{
        Milk milk = findMilkByCode(code);
        milkList.remove(milk);
        IO.writeFile(MILK_FILE, milkList);
        return milk;
    }
    public Clothes removeClothes(String code) throws FileNotFoundException{
        Clothes clothes = findClothesByCode(code);
        clothesList.remove(clothes);
        IO.writeFile(CLOTHES_FILE, clothesList);
        return clothes;
    }
    public Customer removeCustomer(String phoneNumber) throws FileNotFoundException{
        Customer customer = findCustomerByPhoneNumber(phoneNumber);
        customerList.remove(customer);
        IO.writeFile(CUSTOMER_FILE, customerList);
        return customer;
    }
}
