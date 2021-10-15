package view;

import controller.Worker;
import model.product.Milk;

import java.util.Scanner;

public class Main {
    static Worker worker = new Worker();
    public static void main(String[] args) {

    }
    static void run(){
        Scanner s = new Scanner(System.in);
        while (true){
            System.out.println("1  add");
            System.out.println("2  edit");
            System.out.println("3  remove");
            System.out.println("4  find");
            System.out.println("0  exit");
            int choice = s.nextInt();
            switch (choice){
                case 1:
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
            case 1:
        }
    }
    static Milk getNewMilk(){
        Scanner s = new Scanner(System.in);
        Scanner n = new Scanner(System.in);
        System.out.println("code");
        System.out.println("name");
        System.out.println("price");
        System.out.println("category");
        System.out.println("quantity");
        System.out.println("manufacturer");
    }
}
