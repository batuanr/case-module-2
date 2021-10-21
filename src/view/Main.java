package view;

import model.Order;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static boolean isBoss = false;
    static Scanner s = new Scanner(System.in);
    static Scanner n = new Scanner(System.in);
    private static BossMain bossMain = new BossMain();
    private static CustomerMain customerMain = new CustomerMain();
    private static EmployeeMain employeeMain = new EmployeeMain();
    private static OrderMain orderMain = new OrderMain();
    private static ProductMain productMain = new ProductMain();
    public static void main(String[] args) {
//        System.out.println("login ------------");
//        System.out.println("id or phone number: ");
//        String id = s.nextLine();
//        System.out.println("password");
//        String password = s.nextLine();
//        if (bossMain.getBossManage().getId().equals(id) && bossMain.getBossManage().getPassword().equals(password)){
//            bossRun();
//        }
//        else {
//            try {
//                if(employeeMain.getEmployeeManage().find(id).getPassword().equals(password)){
//                    employeeRun();
//                }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
        run();
    }

    public static void run(){
        while (true){
            System.out.println("Menu:");
            System.out.println("1 quản lý Product");
            System.out.println("2 quản lý Customer");
            System.out.println("3 quản lý Order");
            if (isBoss){
                System.out.println("4  quản lý nhân viên");
                System.out.println("5  change account");
            }
            else{
                System.out.println("4  change password");
            }
            System.out.println("0 exit");
            int choice = n.nextInt();
            switch (choice){
                case 1:
                    productMain.product();
                    break;
                case 2:
                    customerMain.customer();
                    break;
                case 3:
                    orderMain.getRevenue();
                    break;
                case 4:
                    if(isBoss){
                        employeeMain.employee();
                    }
                    else{
                        employeeMain.changePassword();
                    }
                    break;
                case 5:
                    if(isBoss){
                        bossMain.changeAccount();
                    }
                    break;
                case 0:return;
            }
        }
    }
}
