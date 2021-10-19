package controller;

import model.person.Employee;
import storage.InputOutFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManage implements GeneralManage<Employee> {
    private InputOutFile inputOutFile = InputOutFile.getInstance();
    private final String EMPLOYEE_FILE = "employee.obj";
    private List<Employee> employeeList = new ArrayList<>();

    public EmployeeManage() {
        this.employeeList = inputOutFile.readToFile(EMPLOYEE_FILE);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    public void editPassword(String phoneNumber, String password){
        for (Employee employee: employeeList){
            if (employee.getPhoneNumber().equals(phoneNumber)){
                employee.setPassword(password);
                inputOutFile.writeFile(EMPLOYEE_FILE, employeeList);
                break;
            }
        }
    }

    @Override
    public void add(Employee employee) {
        employeeList.add(employee);
        inputOutFile.writeFile(EMPLOYEE_FILE, employeeList);
    }

    @Override
    public Employee find(String phoneNumber) throws FileNotFoundException {
        for (Employee employee: employeeList){
            if (employee.getPhoneNumber().equals(phoneNumber)){
                return employee;
            }
        }
        throw new FileNotFoundException();
    }

    @Override
    public void edit(String phoneNumber, Employee employee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getPhoneNumber().equals(phoneNumber)){
                employeeList.set(i, employee);
                inputOutFile.writeFile(EMPLOYEE_FILE, employeeList);
                break;
            }
        }
    }

    @Override
    public Employee remove(String phoneNumber) throws FileNotFoundException {
        Employee employee = find(phoneNumber);
        employeeList.remove(employee);
        inputOutFile.writeFile(EMPLOYEE_FILE, employeeList);
        return employee;
    }
    public void setBonus(int bonus){

    }
}
