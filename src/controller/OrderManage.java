package controller;

import model.Order;
import storage.InputOutFile;

import java.io.FileNotFoundException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class OrderManage implements GeneralManage<Order>{
    private InputOutFile inputOutFile = InputOutFile.getInstance();
    private final String ORDER_FILE = "order.obj";
    private List<Order> orderList = new ArrayList<>();


    public List<Order> getOrderList() {
        return inputOutFile.readToFile(ORDER_FILE);
    }

    public OrderManage() {
        orderList = inputOutFile.readToFile(ORDER_FILE);
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public void add(Order order) {
        orderList.add(order);
        inputOutFile.writeFile(ORDER_FILE, orderList);
    }

    @Override
    public Order find(String code) throws FileNotFoundException {
        for (Order order: orderList){
            if (order.getCode().equals(code)){
                return order;
            }
        }
        throw new FileNotFoundException();
    }
    public List<Order> findOrderOneMonth(int month){
        List<Order> orders = new ArrayList<>();

        for (Order order: getOrderList()){
            int  getMonth = order.getOrderDay().getMonthValue();
            if (getMonth == month){
                orders.add(order);
            }
        }
        return orders;
    }

    public List<Order> findOrderOfPeople(String phoneNumber){
        List<Order> orders = new ArrayList<>();
        for (Order order: orderList){
            if (order.getCustomer().getPhoneNumber().equals(phoneNumber)){
                orders.add(order);
            }
        }
        return orders;
    }

    @Override
    public void edit(String code, Order order) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getCode().equals(code)){
                orderList.set(i, order);
                inputOutFile.writeFile(ORDER_FILE, orderList);
                break;
            }
        }
    }

    @Override
    public Order remove(String code) throws FileNotFoundException {
        Order order = find(code);
        orderList.remove(order);
        inputOutFile.writeFile(ORDER_FILE, orderList);
        return order;
    }
    public int totalMoneyOneMonth (int month){
        int total = 0;
        for (Order order: findOrderOneMonth(month)){
            total += order.getTotal();
        }
        return total;
    }
    public int totalMoneyOnePeople(String phoneNumber){
        int total = 0;
        for (Order order: findOrderOfPeople(phoneNumber)){
            total += order.getTotal();
        }
        return total;
    }
}
