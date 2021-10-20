package view;

import controller.CustomerManage;
import model.person.Customer;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomerMain {
    Scanner s = new Scanner(System.in);
    Scanner n = new Scanner(System.in);
    private CustomerManage customerManage = new CustomerManage();

    public void customer(){
        System.out.println("1  thêm");
        System.out.println("2  Sửa");
        System.out.println("3  Xóa");
        System.out.println("4  Tìm kiếm");
        System.out.println("5  hiển thị toàn bộ khách hàng");
        int choice = n.nextInt();
        switch (choice){
            case 1:addNewProduct();
                break;
            case 2:editCustomer();
                break;
            case 3:removeCustomer();
                break;
            case 4:find();
                break;
            case 5:showAll();
                break;
        }
    }
    public void addNewProduct(){
        customerManage.add(getNewCustomer());
    }
    public void editCustomer(){
        System.out.println("Nhập phone number");
        String phoneNumber = s.nextLine();
        customerManage.edit(phoneNumber, getNewCustomer());
    }
    public void removeCustomer(){
        System.out.println("Nhập phone number");
        String phoneNumber = s.nextLine();
        try {
            customerManage.remove(phoneNumber);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void find(){
        System.out.println("Nhập phone number");
        String phoneNumber = s.nextLine();
        Customer customer = customerManage.find(phoneNumber);
        System.out.println(customer);
    }
    public void showAll(){
        for (Customer customer: customerManage.getCustomerList()){
            System.out.println(customer);
        }
    }
    public Customer getNewCustomer(){
        System.out.println("Name");
        String name = s.nextLine();
        System.out.println("birth Day");
        String birthDay = s.nextLine();
        System.out.println("Gender");
        String gender = s.nextLine();
        System.out.println("Address");
        String address = s.nextLine();
        System.out.println("Phone number");
        String phoneNumber = s.nextLine();
        System.out.println("id");
        String id = s.nextLine();

        return new Customer(name, birthDay, gender, address, phoneNumber, id);
    }
}
