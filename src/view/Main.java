package view;

import controller.Boss;

import model.product.Milk;

import java.util.Scanner;

public class Main {
    static Boss boss = new Boss("admin", "12345678");
    public static void main(String[] args) {
        run();
    }
    static void run(){
        Scanner s = new Scanner(System.in);
        while (true){
            System.out.println("1  add");
            System.out.println("2  edit");
            System.out.println("3  remove");
            System.out.println("4  show");
            System.out.println("4  find");
            System.out.println("0  exit");
            int choice = s.nextInt();
            switch (choice){
                case 1:add();
                break;
                case 4:
                    for (Milk milk: boss.getMilkManage().getMilkList()){
                        System.out.println(milk);
                    }
                    break;
                case 0: return;
            }
        }
    }
    static void add(){
        Scanner s = new Scanner(System.in);
        Scanner n = new Scanner(System.in);
        System.out.println("1  ");
        System.out.println("2  ");
        System.out.println("3  ");
        int choice = s.nextInt();
        switch (choice){
            case 1:boss.getMilkManage().add(getNewMilk());
            break;
        }
    }
    static Milk getNewMilk(){
        Scanner s = new Scanner(System.in);
        Scanner n = new Scanner(System.in);
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
}
