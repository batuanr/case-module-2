package view;

import controller.ProductManage;
import model.Category;
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
            case 1:
                try {
                    productManage.add(getNewProduct());
                } catch (Exception e) {
                    e.printStackTrace();
                }
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

    public Product getNewProduct() throws Exception {
        System.out.println("1  thêm sữa");
        System.out.println("2  thêm quần áo");
        int choice = n.nextInt();
        while (choice == 2 || choice == 1){
            System.out.println("code");
            String code = s.nextLine();
            System.out.println("name");
            String name = s.nextLine();
            System.out.println("price");
            int price = n.nextInt();
            System.out.println("category");
            Category category = selectCategory();
            System.out.println("quantity");
            int quantity = n.nextInt();
            if (choice == 1){
                System.out.println("manufacturer");
                String manufacturer = s.nextLine();

                return new Milk(code, name, price, category, quantity, manufacturer);
            }
            else{
                System.out.println("size");
                String size = s.nextLine();

                return new Clothes(code, name, price, category, quantity, size);
            }
        }
        throw new Exception("sai choice");
    }
    public Clothes getNewClothes(){
        System.out.println("Code");
        String code = s.nextLine();
        System.out.println("Name");
        String name = s.nextLine();
        System.out.println("Price");
        int price = n.nextInt();
        System.out.println("category");
        Category category = selectCategory();
        System.out.println("Quantity");
        int quantity = n.nextInt();
        System.out.println("size");
        String size = s.nextLine();

        return new Clothes(code, name, price, category, quantity, size);
    }
//    public void addNewProduct(){
//        System.out.println("1 thêm sữa");
//        System.out.println("2 thêm quần áo");
//        int choice = n.nextInt();
//        switch (choice){
//            case 1:productManage.add(getNewMilk());
//                break;
//            case 2:productManage.add(getNewClothes());
//                break;
//        }
//    }
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
                System.out.println(productManage.findByCategory(Category.I));
                break;
            case 2:
                System.out.println(productManage.findByCategory(Category.II));
                break;
            case 3:
                System.out.println(productManage.findByCategory(Category.III));
                break;
            case 4:
                System.out.println(productManage.findByCategory(Category.IV));
                break;
            case 5:
                System.out.println(productManage.findByCategory(Category.V));
                break;
            case 6:
                System.out.println(productManage.findByCategory(Category.VI));
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
    public void editProduct(){
        System.out.println("Nhập mã sản phẩm cần sửa");
        String code = s.nextLine();
        try {
            Product product = productManage.find(code);
            System.out.println("1  Sửa mã sản phẩm");
            System.out.println("2  Sửa tên sản phẩm");
            System.out.println("3  Sửa giá");
            System.out.println("4  sửa danh mục");
            System.out.println("5  Sửa số lượng");
            if (product instanceof Milk){
                System.out.println("6  Sửa hãng sữa");
            }
            else{
                System.out.println("6  Sửa size quần áo");
            }
            int choice = n.nextInt();
            switch (choice){
                case 1:
                    System.out.println("nhập mã mới");
                    String newCode = s.nextLine();
                    product.setCode(newCode);
                    break;
                case 2:
                    System.out.println("Nhập tên mới");
                    String name = s.nextLine();
                    product.setName(name);
                    break;
                case 3:
                    System.out.println("Nhập giá mới");
                    int price = n.nextInt();
                    product.setPrice(price);
                    break;
                case 4:
                    System.out.println("danh mục ?");
                    Category category = selectCategory();
                    product.setCategory(category);
                    break;
                case 5:
                    System.out.println("Số lượng mới");
                    int quantity = n.nextInt();
                    product.setQuantity(quantity);
                    break;
                case 6:
                    if(product instanceof Milk){
                        System.out.println("Nhập hãng sữa");
                        String manufacturer = s.nextLine();
                        ((Milk)product).setManufacturer(manufacturer);
                    }
                    else{
                        System.out.println("Nhập size quần áo");
                        String size = s.nextLine();
                        ((Clothes)product).setSize(size);
                    }
                    break;
            }
            productManage.edit(code, product);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public Category selectCategory(){
        System.out.println("1 Danh mục I : Sữa 6 tháng đến 1,5 tuổi");
        System.out.println("2 Danh mục II : Sữa 1,5 tháng đến 3 tuổi");
        System.out.println("3 Danh mục III :Sữa 3 tháng đến 5 tuổi");
        System.out.println("4 Danh mục IV :Sữa 5 tháng đến 10 tuổi");
        System.out.println("5 Danh mục V :áo quần bé trai");
        System.out.println("6 Danh mục VI :áo quần bé gái");
        int choice = n.nextInt();
        int indexCategory = choice - 1;
        Category category = Category.values()[indexCategory];
        return category;
    }
}
