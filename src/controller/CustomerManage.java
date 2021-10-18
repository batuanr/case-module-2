package controller;

import model.person.Customer;
import storage.IO;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CustomerManage implements GeneralManage<Customer>{
    private IO io = IO.getInstance();
    private List<Customer> customerList = new ArrayList<>();
    private final String CUSTOMER_FILE = "customer.obj";

    public CustomerManage() {
        this.customerList = io.readToFile(CUSTOMER_FILE);
    }

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
        io.writeFile(CUSTOMER_FILE, customerList);
    }

    @Override
    public Customer find(String phoneNumber) throws FileNotFoundException {
        for (Customer customer: customerList){
            if (customer.getPhoneNumber().equals(phoneNumber)){
                return customer;
            }
        }
        throw new FileNotFoundException();
    }


    @Override
    public void edit(String phoneNumber, Customer customer) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getPhoneNumber().equals(phoneNumber)){
                customerList.set(i, customer);
                io.writeFile(CUSTOMER_FILE, customerList);
                break;
            }
        }
    }

    @Override
    public Customer remove(String phoneNumber) throws FileNotFoundException {
        Customer customer = find(phoneNumber);
        customerList.remove(customer);
        io.writeFile(CUSTOMER_FILE, customerList);
        return customer;
    }
}
