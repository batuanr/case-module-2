package view;

import controller.*;
import model.Order;
import model.person.Customer;
import model.product.Product;
import storage.InputOutFile;

import java.io.FileNotFoundException;
import java.time.Month;
import java.util.List;
import java.util.Scanner;

public class OrderMain {
    private InputOutFile inputOutFile = InputOutFile.getInstance();
    Scanner s = new Scanner(System.in);
    Scanner n = new Scanner(System.in);
    private CustomerMain customerMain = new CustomerMain();
    private CustomerManage customerManage = new CustomerManage();
    private ProductManage productManage = new ProductManage();

    private OrderManage orderManage = new OrderManage();

    public void getRevenue(){
        System.out.println("1 Thêm order");
        System.out.println("2 Sửa");
        System.out.println("3 Xóa");
        System.out.println("4 tìm kiếm");
        System.out.println("5 Doanh thu tháng ");
        System.out.println("6 all order");
        int choice = n.nextInt();
        switch (choice){
            case 1:addOrder();
            break;
            case 2:editOrder();
            break;
            case 3:removeOrder();
            break;
            case 4:findOrder();
            break;
            case 5:getMoneyOneMonth();
            break;
            case 6:allOrder();
            break;
        }

    }
    public void addOrder() {

        try {
            Order order = getNewOrder();
            orderManage.add(order);
            List<Product> products = productManage.getProductList();

            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                if(product.getCode().equals(order.getProduct().getCode())){
                    int quantity = product.getQuantity() - order.getOrderQuantity();
                    product.setQuantity(quantity);
                    inputOutFile.writeFile(productManage.getPRODUCT_FILE(), products);
                    break;
                }
            }
            List<Customer> customers = customerManage.getCustomerList();
            for (int i = 0; i < customers.size(); i++){
                Customer customer = customers.get(i);
                if(customer.getPhoneNumber().equals(order.getCustomer().getPhoneNumber())){
                    int totalMoney = customer.getTotalMoney() + order.getTotal();
                    customer.setTotalMoney(totalMoney);
                    inputOutFile.writeFile(customerManage.getCUSTOMER_FILE(), customers);
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void editOrder(){
        System.out.println("Code");
        String code = s.nextLine();
        try {
            orderManage.edit(code, getNewOrder());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void removeOrder(){
        System.out.println("Code");
        String code = s.nextLine();
        try {
            orderManage.remove(code);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void ShowOrder(){
        System.out.println("Code");
        String code = s.nextLine();
        try {
            orderManage.find(code);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void findOrder(){
        System.out.println("Tìm 1 order");
        System.out.println("order của 1 người");
        System.out.println("order của 1 month");
        int choice = n.nextInt();
        switch (choice){
            case 1:
                System.out.println("Code");
                String code = s.nextLine();
                try {
                    System.out.println(orderManage.find(code));;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.println("enter phoneNumber");
                String phoneNumber = n.nextLine();
                for (Order order: orderManage.findOrderOfPeople(phoneNumber)){
                    System.out.println(order);
                }
                break;
            case 3:
                System.out.println("enter month");
                int month = n.nextInt();
                for (Order order: orderManage.findOrderOneMonth(month)){
                    System.out.println(order);
                }
        }

    }
    public void getMoneyOneMonth(){
        System.out.println("enter month");
        int month = n.nextInt();
        System.out.println(orderManage.totalMoneyOneMonth(month));;
    }
    public Order getNewOrder() throws FileNotFoundException {
        System.out.println("Code");
        String code = s.nextLine();
        System.out.println("enter phone number");
        String phoneNumber = s.nextLine();
        System.out.println("enter code product");
        String codeProduct = s.nextLine();
        System.out.println("quantity");
        int quantity = n.nextInt();

        Customer customer = customerManage.find(phoneNumber);

        Product product = productManage.find(codeProduct);

        return new Order(code, customer, product, quantity);
    }
    public void allOrder(){
        for (Order order: orderManage.getOrderList()){
            System.out.println(order);
        }
    }
}
