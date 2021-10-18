package controller;

import model.Order;
import storage.IO;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class OrderManage implements GeneralManage<Order> {
    private IO io = IO.getInstance();
    private final String ORDER_FILE = "order.obj";
    private List<Order> orderList = new ArrayList<>();

    public OrderManage() {
        this.orderList = io.readToFile(ORDER_FILE);
    }

    @Override
    public void add(Order order) {
        orderList.add(order);
        io.writeFile(ORDER_FILE, orderList);
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

    public List<Order> findOrder(String phoneNumber){
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
                io.writeFile(ORDER_FILE, orderList);
                break;
            }
        }
    }

    @Override
    public Order remove(String code) throws FileNotFoundException {
        Order order = find(code);
        orderList.remove(order);
        io.writeFile(ORDER_FILE, orderList);
        return order;
    }
}
