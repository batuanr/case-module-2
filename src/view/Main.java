package view;


import java.util.Scanner;

public class Main {
    static boolean isBoss = false;
    static boolean checkLogin = false;
    static Scanner s = new Scanner(System.in);
    static Scanner n = new Scanner(System.in);
    private static BossMain bossMain = new BossMain();
    private static CustomerMain customerMain = new CustomerMain();
    private static EmployeeMain employeeMain = new EmployeeMain();
    private static OrderMain orderMain = new OrderMain();
    private static ProductMain productMain = new ProductMain();
    public static void main(String[] args) {
        do {
            System.out.println("login ------------");
            System.out.println("id or phone number: ");
            String id = s.nextLine();
            System.out.println("password");
            String password = s.nextLine();
            String bossId = bossMain.getBossManage().getId();
            String bossPassword = bossMain.getBossManage().getPassword();

            if (bossId.equals(id) && bossPassword.equals(password)){
                isBoss = true;
                run();
            }
            else {
                if (employeeMain.checkLogin(id , password)){
                    isBoss = false;
                    run();
                }
                else {
                    System.out.println("Sai rồi, nhập lại đi");
                }
            }
        }while (!checkLogin);
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
            String choice = s.nextLine();
            switch (choice){
                case "1":
                    productMain.product();
                    break;
                case "2":
                    customerMain.customer();
                    break;
                case "3":
                    orderMain.getRevenue();
                    break;
                case "4":
                    if(isBoss){
                        employeeMain.employee();
                    }
                    else{
                        employeeMain.changePassword();
                    }
                    break;
                case "5":
                    if(isBoss){
                        bossMain.changeAccount();
                    }
                    break;
                case "0":return;
                default:
                    System.out.println("chọn lại");
            }
        }
    }
}
