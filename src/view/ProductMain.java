package view;

import controller.ProductManage;
import model.product.Clothes;
import model.product.Milk;
import model.product.Product;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ProductMain {
    Scanner s = new Scanner(System.in);
    Scanner n = new Scanner(System.in);
    private ProductManage productManage = new ProductManage();
    private List<Product> productsToUp = productManage.sortByPriceToUp();
    private List<Product> productsToDown = productManage.sortByPriceToDown();

    public  void product(){
        System.out.println("1 thêm");
        System.out.println("2 Sửa");
        System.out.println("3 Xóa");
        System.out.println("4  Hiển thị theo giá");
        System.out.println("5 tìm kiếm");
        System.out.println("6 show all sản phẩm");
        System.out.println("7 Milk List");
        System.out.println("8 Clothes List");
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
            case 5:find();
            break;
            case 6:showAllProduct();
            break;
            case 7:getMilkList();
            break;
            case 8:getClothesList();
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
        System.out.println("1 thêm sữa");
        System.out.println("2 thêm quần áo");
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
    public void find(){
        System.out.println("1  Tìm theo mã sản phẩm");
        System.out.println("2  Tìm theo danh mục");
        int choice = n.nextInt();
        switch (choice){
            case 1: findByCode();
            break;
            case 2: findByCategory();
            break;
        }
    }
    public void findByCode(){
        System.out.println("Nhập code");
        String code = s.nextLine();
        try {
            Product product = productManage.find(code);
            System.out.println(product);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public  void findByCategory(){
        System.out.println("1 Sữa 6 tháng đến 1,5 tuổi");
        System.out.println("2 Sữa 1,5 tháng đến 3 tuổi");
        System.out.println("3 Sữa 3 tháng đến 5 tuổi");
        System.out.println("4 Sữa 5 tháng đến 10 tuổi");
        System.out.println("5 áo quần bé trai");
        System.out.println("6 áo quần bé gái");
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
    public List<Milk> getMilkList(){
        List<Milk> milks = productManage.getMlkList();
        return milks;
    }
    public List<Clothes> getClothesList(){
        List<Clothes> clothesList =productManage.getClothesList();
        return clothesList;
    }
    public void sort(){
        System.out.println("1  sữa");
        System.out.println("1  quần áo");
        int choice = n.nextInt();
        switch (choice){
            case 1:sortMilk();
            break;
            case 2:sortClothes();
            break;
        }
    }
    public void sortMilk(){
        System.out.println("1  tăng dần");
        System.out.println("2  giảm dần");
        int choice = n.nextInt();
        switch (choice){
            case 1:
                for (Product product: productsToUp){
                    if (product instanceof Milk){
                        System.out.println(product);
                    }
                }
                break;
            case 2:
                for (Product product: productsToDown){
                    if (product instanceof Milk){
                        System.out.println(product);
                    }
                }
                break;
        }
    }
    public void sortClothes(){
        System.out.println("1  tăng dần");
        System.out.println("2  giảm dần");
        int choice = n.nextInt();
        switch (choice){
            case 1:
                for (Product product: productsToUp){
                    if (product instanceof Clothes){
                        System.out.println(product);
                    }
                }
                break;
            case 2:
                for (Product product: productsToDown){
                    if (product instanceof Clothes){
                        System.out.println(product);
                    }
                }
                break;
        }
    }
}
