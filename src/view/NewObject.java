package view;

import controller.CustomerManage;
import controller.EmployeeManage;
import controller.ProductManage;
import model.Order;
import model.Payroll;
import model.person.Customer;
import model.person.Employee;
import model.product.Clothes;
import model.product.Milk;
import model.product.Product;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class NewObject {
    private EmployeeManage employeeManage = new EmployeeManage();
    private ProductManage productManage = new ProductManage();
    private CustomerManage customerManage = new CustomerManage();
    Scanner s = new Scanner(System.in);
    Scanner n = new Scanner(System.in);
    public Milk getNewMilk(){

        System.out.println("code");
        String code = s.nextLine();
        System.out.println("name");
        String name = s.nextLine();
        System.out.println("price");
        int price = n.nextInt();
        System.out.println("category");
        String category = s.nextLine();
        System.out.println("quantity");
        int quantity = n.nextInt();
        System.out.println("manufacturer");
        String manufacturer = s.nextLine();

        return new Milk(code, name, price, category, quantity, manufacturer);
    }
    public Clothes getNewClothes(){
        System.out.println("Code");
        String code = s.nextLine();
        System.out.println("Name");
        String name = s.nextLine();
        System.out.println("Price");
        int price = n.nextInt();
        System.out.println("category");
        String category = s.nextLine();
        System.out.println("Quantity");
        int quantity = n.nextInt();
        System.out.println("size");
        String size = s.nextLine();

        return new Clothes(code, name, price, category, quantity, size);
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
    public Order getNewOrder() throws FileNotFoundException {
        System.out.println("Code");
        String code = s.nextLine();
        System.out.println("enter phone number");
        String phoneNumber = s.nextLine();
        System.out.println("enter code product");
        String codeProduct = s.nextLine();
        System.out.println("quantity");
        int quantity = n.nextInt();

        Customer customer;
        if ((customer = customerManage.find(phoneNumber)) == null){
            customer = getNewCustomer();
        }
        Product product = productManage.find(codeProduct);


        return new Order(code, customer, product, quantity);
    }
    public Employee getNewEmployee(){
        System.out.println("Name");
        String name = s.nextLine();
        System.out.println("birthDay");
        String birthDay = s.nextLine();
        System.out.println("Gender");
        String gender = s.nextLine();
        System.out.println("Address");
        String address = s.nextLine();
        System.out.println("Phone number");
        String phoneNumber = s.nextLine();
        System.out.println("hardSalary");
        int hardSalary = n.nextInt();

        return new Employee(name, birthDay, gender, address, phoneNumber, hardSalary);
    }
    public Payroll getNewPayroll() throws FileNotFoundException {
        System.out.println("code");
        String code = s.nextLine();
        System.out.println("Phone number");
        String phoneNumber = s.nextLine();
        System.out.println("Month");
        int month = n.nextInt();
        System.out.println("Bonus");
        int bonus = n.nextInt();
        System.out.println("fine");
        int fine = n.nextInt();

        Employee employee = employeeManage.find(phoneNumber);

        return new Payroll(code, employee, month, bonus, fine);
    }
}
