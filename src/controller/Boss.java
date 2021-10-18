package controller;

import storage.IO;

public class Boss {
    private IO io = IO.getInstance();
    private final String BOSS_FILE = "boss.obj";
    private String id;
    private String password;
    private ClothesManage clothesManage;
    private EmployeeManage employeeManage;
    private MilkManage milkManage;
    private OrderManage orderManage;

    public Boss(String id, String password) {
        this.id = id;
        this.password = password;
        this.clothesManage = new ClothesManage();
        this.employeeManage = new EmployeeManage();
        this.milkManage = new MilkManage();
        this.orderManage = new OrderManage();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ClothesManage getClothesManage() {
        return clothesManage;
    }

    public void setClothesManage(ClothesManage clothesManage) {
        this.clothesManage = clothesManage;
    }

    public EmployeeManage getEmployeeManage() {
        return employeeManage;
    }

    public void setEmployeeManage(EmployeeManage employeeManage) {
        this.employeeManage = employeeManage;
    }

    public MilkManage getMilkManage() {
        return milkManage;
    }

    public void setMilkManage(MilkManage milkManage) {
        this.milkManage = milkManage;
    }

    public OrderManage getOrderManage() {
        return orderManage;
    }

    public void setOrderManage(OrderManage orderManage) {
        this.orderManage = orderManage;
    }
}
