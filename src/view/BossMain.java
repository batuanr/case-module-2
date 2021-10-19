package view;

import controller.BossManage;

import java.util.Scanner;

public class BossMain {
    Scanner s = new Scanner(System.in);
    Scanner n = new Scanner(System.in);
    private BossManage bossManage = new BossManage();

    public BossManage getBossManage() {
        return bossManage;
    }

    public void setBossManage(BossManage bossManage) {
        this.bossManage = bossManage;
    }

    public void changeAccount(){
        System.out.println(" 1  change id");
        System.out.println(" 2  change password");
        int choice = n.nextInt();
        if (choice == 1){
            System.out.println("enter new id");
            String id = s.nextLine();
            bossManage.setId(id);
        }
        else{
            if (choice == 2){
                System.out.println("enter new password");
                String password = s.nextLine();
                bossManage.setPassword(password);
            }
        }
    }
}
