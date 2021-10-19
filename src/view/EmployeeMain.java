package view;

import controller.*;
import model.Payroll;
import model.product.Milk;
import model.product.Product;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmployeeMain {
     static Scanner s = new Scanner(System.in);
    static Scanner n = new Scanner(System.in);
    private static NewObject newObject = new NewObject();
    private static final BossManage bossManage = new BossManage();
    private static final ClothesManage clothesManage = new ClothesManage();
    private static final EmployeeManage employeeManage = new EmployeeManage();
    private static final ProductManage productManage = new ProductManage();
    private static final OrderManage orderManage = new OrderManage();
    private  static final PayrollManage payrollManage = new PayrollManage();

    public static void main(String[] args) {
        run();
    }
    public static void run(){
        while (true){
            System.out.println("sản phẩm");
            System.out.println("khách hàng");
            System.out.println("nhân viên");
            System.out.println("Doanh thu");
            System.out.println("");
            int choice = n.nextInt();
            switch (choice){
                case 1:product();
                break;
            }
        }

    }
    public static void product(){
        System.out.println("1 thêm");
        System.out.println("2 Sửa");
        System.out.println("3 Xóa");
        System.out.println("4 tìm kiếm");
        System.out.println("5 show all sản phẩm");
        int choice = n.nextInt();
        switch (choice){
            case 1:addNewProduct();
            break;
            case 2:editProduct();
            break;
            case 3:removeProduct();
                break;
            case 4:search();
                break;
            case 5:showAllProduct();
            break;

        }

    }
    public static void customer(){
        System.out.println("thêm");
        System.out.println("Sửa");
        System.out.println("Xóa");
        System.out.println("Tìm kiếm");
        System.out.println("hiển thị toàn bộ khách hàng");
    }
    public static void employee(){
        System.out.println("1 thêm");
        System.out.println("2 Sửa");
        System.out.println("3 Xóa");
        System.out.println("4 Tìm kiếm");
        System.out.println("5 Tìm kiếm theo danh mục");
        System.out.println("6 xem thông tin");
        System.out.println("7 tính lương");
    }
    public static void getRevenue(){
        System.out.println("Doanh thu tháng này");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public static void addNewProduct(){
        System.out.println("thêm sữa");
        System.out.println("thêm quần áo");
        int choice = n.nextInt();
        switch (choice){
            case 1:productManage.add(newObject.getNewMilk());
                break;
            case 2:productManage.add(newObject.getNewClothes());
                break;
        }
    }
    public static void editProduct(){
        System.out.println("Nhập code");
        String code = s.nextLine();
        try {
            if(productManage.find(code) instanceof Milk){
                productManage.edit(code, newObject.getNewMilk());
            }
            else {
                productManage.edit(code, newObject.getNewClothes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void removeProduct(){
        System.out.println("Nhập code");
        String code = s.nextLine();
        try {
            productManage.remove(code);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void search(){
        System.out.println("Nhập code");
        String code = s.nextLine();
        try {
            System.out.println(productManage.find(code));;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void searchByCategory(){
        System.out.println("Sữa 6 tháng đến 1,5 tuổi");
        System.out.println("Sữa 1,5 tháng đến 3 tuổi");
        System.out.println("Sữa 3 tháng đến 5 tuổi");
        System.out.println("Sữa 5 tháng đến 10 tuổi");
        System.out.println("áo quần nam");
        System.out.println("áo quần nữ");
        System.out.println("dày dép nữ");
        System.out.println("dày dép nam");
        int choice = n.nextInt();
        switch (choice){
            case 1:
                System.out.println(productManage.findByCategory("1"));
                break;
            case 2:
                System.out.println(productManage.findByCategory("2"));
                break;
            case 3:
                System.out.println(productManage.findByCategory("3"));
                break;
            case 4:
                System.out.println(productManage.findByCategory("4"));
                break;
            case 5:
                System.out.println(productManage.findByCategory("5"));
                break;
            case 6:
                System.out.println(productManage.findByCategory("6"));
                break;
        }
    }
    public static void showAllProduct(){
        for (Product product: productManage.getProductList()){
            System.out.println(product);
        }
    }


}
