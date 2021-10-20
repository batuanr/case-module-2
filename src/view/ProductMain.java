package view;

import controller.ProductManage;
import model.product.Clothes;
import model.product.Milk;
import model.product.Product;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProductMain {
    Scanner s = new Scanner(System.in);
    Scanner n = new Scanner(System.in);
    private ProductManage productManage = new ProductManage();

    public  void product(){
        System.out.println("1 thêm");
        System.out.println("2 Sửa");
        System.out.println("3 Xóa");
        System.out.println("4  Hiển thị theo giá");
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
            case 4:sort();
                break;
            case 5:showAllProduct();
                break;
            case 6:search();
            break;

        }

    }

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
    public void addNewProduct(){
        System.out.println("thêm sữa");
        System.out.println("thêm quần áo");
        int choice = n.nextInt();
        switch (choice){
            case 1:productManage.add(getNewMilk());
                break;
            case 2:productManage.add(getNewClothes());
                break;
        }
    }
    public void editProduct(){
        System.out.println("Nhập code");
        String code = s.nextLine();
        try {
            if(productManage.find(code) instanceof Milk){
                productManage.edit(code,getNewMilk());
            }
            else {
                productManage.edit(code, getNewClothes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void removeProduct(){
        System.out.println("Nhập code");
        String code = s.nextLine();
        try {
            productManage.remove(code);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void search(){
        System.out.println("Nhập code");
        String code = s.nextLine();
        try {
            System.out.println(productManage.find(code));;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public  void searchByCategory(){
        System.out.println("Sữa 6 tháng đến 1,5 tuổi");
        System.out.println("Sữa 1,5 tháng đến 3 tuổi");
        System.out.println("Sữa 3 tháng đến 5 tuổi");
        System.out.println("Sữa 5 tháng đến 10 tuổi");
        System.out.println("áo quần nam");
        System.out.println("áo quần nữ");
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
    public void showAllProduct(){
        for (Product product: productManage.getProductList()){
            System.out.println(product);
        }
    }
    public void sort(){
        System.out.println("1  tăng dần");
        System.out.println("2  giảm dần");
        int choice = n.nextInt();
        switch (choice){
            case 1:
                for (Product product: productManage.sortByPriceToUp()){
                    System.out.println(product);
                }
                break;
            case 2:
                for (Product product: productManage.sortByPriceToDown()){
                    System.out.println(product);
                }
                break;
        }
    }
}
