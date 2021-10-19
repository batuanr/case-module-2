package controller;

import model.person.Customer;
import storage.InputOutFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CustomerManage implements GeneralManage<Customer>{
    private MoneyMethod moneyMethod = new OrderManage();
    private InputOutFile inputOutFile = InputOutFile.getInstance();
    private List<Customer> customerList = new ArrayList<>();
    private final String CUSTOMER_FILE = "customer.obj";

    public List<Customer> getCustomerList() {
        setTypeCustomer();
        return customerList;
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
            if (moneyMethod.totalMoneyOnePeople(customer.getPhoneNumber()) > 20000000){
                customer.setType("kim cương");
            }
            else{
                if (moneyMethod.totalMoneyOnePeople(customer.getPhoneNumber()) > 10000000){
                    customer.setType("Vàng");
                }
                else{
                    if (moneyMethod.totalMoneyOnePeople(customer.getPhoneNumber()) > 5000000){
                        customer.setType("Bạc");
                    }
                    else{
                        customer.setType("Đồng");
                    }
                }
            }
        }
    }
}
