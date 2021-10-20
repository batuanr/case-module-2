package controller;

import model.person.Customer;
import storage.InputOutFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomerManage implements GeneralManage<Customer>{
    private InputOutFile inputOutFile = InputOutFile.getInstance();
    private List<Customer> customerList = new ArrayList<>();
    private final String CUSTOMER_FILE = "customer.obj";

    public List<Customer> getCustomerList() {
        customerList = inputOutFile.readToFile(CUSTOMER_FILE);
        setTypeCustomer();
        sortName();
        return customerList;
    }

    public String getCUSTOMER_FILE() {
        return CUSTOMER_FILE;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public CustomerManage() {
        this.customerList = inputOutFile.readToFile(CUSTOMER_FILE);
    }

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
        inputOutFile.writeFile(CUSTOMER_FILE, customerList);
    }

    @Override
    public Customer find(String phoneNumber)  {
        customerList = inputOutFile.readToFile(CUSTOMER_FILE);
        for (Customer customer: customerList){
            if (customer.getPhoneNumber().equals(phoneNumber)){
                return customer;
            }
        }
        return null;
    }


    @Override
    public void edit(String phoneNumber, Customer customer) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getPhoneNumber().equals(phoneNumber)){
                customerList.set(i, customer);
                inputOutFile.writeFile(CUSTOMER_FILE, customerList);
                break;
            }
        }
    }

    @Override
    public Customer remove(String phoneNumber) throws FileNotFoundException {
        Customer customer = find(phoneNumber);
        customerList.remove(customer);
        inputOutFile.writeFile(CUSTOMER_FILE, customerList);
        return customer;
    }
    public void setTypeCustomer(){
        for (Customer customer: customerList){
            if (customer.getTotalMoney() > 20000000){
                customer.setType("kim cương");
            }
            else{
                if (customer.getTotalMoney() > 10000000){
                    customer.setType("Vàng");
                }
                else{
                    if (customer.getTotalMoney() > 5000000){
                        customer.setType("Bạc");
                    }
                    else{
                        customer.setType("Đồng");
                    }
                }
            }
        }
    }
    public void sortName(){
        Comparator<Customer> comparator = new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(customerList, comparator);
    }


}
