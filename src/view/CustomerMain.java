package view;

import controller.CustomerManage;
import controller.OrderManage;
import model.Order;
import model.person.Customer;
import storage.InputOutFile;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class CustomerMain {
    private InputOutFile inputOutFile = InputOutFile.getInstance();
    Scanner s = new Scanner(System.in);
    Scanner n = new Scanner(System.in);
    private CustomerManage customerManage = new CustomerManage();
    private OrderManage orderManage = new OrderManage();

    public void customer(){
        System.out.println("1  Thêm");
        System.out.println("2  Sửa");
        System.out.println("3  Xóa");
        System.out.println("4  Tìm kiếm");
        System.out.println("5  Hiển thị toàn bộ khách hàng");
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
        Customer customer = customerManage.find(phoneNumber);
        System.out.println("1  Sửa tên");
        System.out.println("2  sửa tuổi");
        System.out.println("3  Sửa số điện thoại");
        System.out.println("4  Sửa địa chỉ");
        System.out.println("5  Sửa tổng tiền đã mua");
        int choice = n.nextInt();
        switch (choice){
            case 1:
                System.out.println("Nhập tên mới");
                String name = s.nextLine();
                customer.setName(name);
                break;
            case 2:
                System.out.println("Nhập ngày tháng năm sinh");
                String birthDay = s.nextLine();
                customer.setBirthDay(birthDay);
                break;
            case 3:
                System.out.println("Nhập số điện thoại mới");
                String newPhoneNumber = s.nextLine();
                customer.setPhoneNumber(newPhoneNumber);
                break;
            case 4:
                System.out.println("Nhập địa chỉ mới");
                String address = s.nextLine();
                customer.setAddress(address);
                break;
            case 5:
                System.out.println("Tổng tiền khách hàng đã mua");
                int total = n.nextInt();
                customer.setTotalMoney(total);
                break;
        }
//        thay đổi luôn customer trong order
        List<Order> orders = orderManage.findOrderOfPeople(phoneNumber);
        for (int i = 0; i < orders.size(); i++) {
            orders.get(i).setCustomer(customer);
        }
        inputOutFile.writeFile(orderManage.getORDER_FILE(), orders);
        customerManage.edit(phoneNumber, customer);
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
