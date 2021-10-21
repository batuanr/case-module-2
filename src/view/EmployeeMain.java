package view;

import controller.EmployeeManage;
import controller.PayrollManage;
import model.Payroll;
import model.person.Customer;
import model.person.Employee;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class EmployeeMain {
    Scanner s = new Scanner(System.in);
    Scanner n = new Scanner(System.in);
    private PayrollManage payrollManage = new PayrollManage();
    private EmployeeManage employeeManage = new EmployeeManage();

    public EmployeeManage getEmployeeManage() {
        return employeeManage;
    }

    public void setEmployeeManage(EmployeeManage employeeManage) {
        this.employeeManage = employeeManage;
    }

    public void employee(){
        System.out.println("1 thêm nhân viên");
        System.out.println("2 Sửa");
        System.out.println("3 Xóa");
        System.out.println("4 Tìm kiếm");
        System.out.println("5 all nhân viên");
        System.out.println("6 add phiếu lương");
        System.out.println("7 sửa phiếu lương");
        System.out.println("8 xóa phiếu lương");
        System.out.println("9 bảng lương tháng");
        int choice = n.nextInt();
        switch (choice){
            case 1:addNewEmployee();
            break;
            case 2:editEmployee();
            break;
            case 3:removeEmployee();
            break;
            case 4:findEmployee();
            break;
            case 5:showAllEmployee();
            break;
            case 6:addPayroll();
            break;
            case 7:editPayroll();
            break;
            case 8:removePayroll();
            break;
            case 9:getAllPayrollOneMonth();
            break;
        }
    }
    public void addNewEmployee(){
        employeeManage.add(getNewEmployee());
    }
    public void editEmployee(){
        System.out.println("Nhập sdt");
        String phoneNumber = s.nextLine();
        employeeManage.edit(phoneNumber, getNewEmployee());
    }
    public void removeEmployee(){
        System.out.println("Nhập sdt");
        String phoneNumber = s.nextLine();
        try {
            employeeManage.remove(phoneNumber);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void findEmployee(){
        System.out.println("Nhập sdt");
        String phoneNumber = s.nextLine();
        try {
            employeeManage.find(phoneNumber);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void showAllEmployee(){
        for (Employee employee: employeeManage.getEmployeeList()){
            System.out.println(employee);
        }
    }
    public void addPayroll(){
        try {
            payrollManage.add(getNewPayroll());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void editPayroll(){
        System.out.println("Nhập code");
        String code = s.nextLine();
        try {
            payrollManage.edit(code, getNewPayroll());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void removePayroll(){
        System.out.println("Nhập code");
        String code = s.nextLine();
        try {
            payrollManage.remove(code);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void getAllPayrollOneMonth(){
        System.out.println("enter month");
        int month = n.nextInt();
        List<Payroll> payrolls = payrollManage.getPayrollOneMonth(month);
        for (Payroll payroll: payrolls){
            System.out.println(payroll);
        }

    }
    public Payroll getNewPayroll() throws FileNotFoundException {
        System.out.println("Nhập code");
        String code = s.nextLine();
        System.out.println("Nhập phone number");
        String phoneNumber = s.nextLine();
        System.out.println("Month");
        int month = n.nextInt();
        System.out.println("Bonus");
        int bonus = n.nextInt();
        System.out.println("Fine");
        int fine = n.nextInt();

        Employee employee = employeeManage.find(phoneNumber);

        return new Payroll(code, employee, month, bonus, fine);

    }
    public void changePassword(){
        System.out.println("enter phone number");
        String phoneNumber = s.nextLine();
        System.out.println("new password");
        String password = s.nextLine();
        employeeManage.editPassword(phoneNumber, password);
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

}
