package view;

import controller.ProductManage;
import model.Category;
import model.SizeClothes;
import model.Trademark;
import model.product.Clothes;
import model.product.Milk;
import model.product.Product;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProductMain {
    int choice = 0;
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
        choice = n.nextInt();
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
        choice = n.nextInt();
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
                System.out.println("Trademark");
                Trademark trademark = selectTrademark();

                return new Milk(code, name, price, category, quantity, trademark);
            }
            else{
                System.out.println("size");
                SizeClothes size = selectSize();

                return new Clothes(code, name, price, category, quantity, size);
            }
        }
        throw new Exception("sai choice");
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
        System.out.println("2  Tìm theo hãng sữa");
        System.out.println("2  Tìm theo size");
        choice = n.nextInt();
        switch (choice){
            case 1: findByCode();
            break;
            case 2: findByCategory();
            break;
            case 3: findByTrademark();
            break;
            case 4: findBySize();
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
        Category category = selectCategory();
        List<Product> products = productManage.findByCategory(category);
        for (Product product: products){
            System.out.println(product);
        }
    }
    public void findByTrademark(){
        Trademark trademark = selectTrademark();
        List<Product> products = productManage.findByTrademark(trademark);
        for (Product product: products){
            System.out.println(product);
        }
    }
    public void findBySize(){
        SizeClothes size = selectSize();
        List<Product> products = productManage.findBySize(size);
        for (Product product: products);
    }
    public void showAllProduct(){
        for (Product product: productManage.getProductList()){
            System.out.println(product);
        }
    }
    public void getMilkList(){
        List<Product> milks = productManage.getMlkList();
        for (Product product: milks){
            System.out.println(product);
        }
    }
    public void getClothesList(){
        List<Product> clothesList =productManage.getClothesList();
        for (Product product: clothesList){
            System.out.println(product);
        }
    }
    public void sort(){
        System.out.println("1  sữa");
        System.out.println("1  quần áo");
        choice = n.nextInt();
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
        choice = n.nextInt();
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
        choice = n.nextInt();
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
                        Trademark trademark = selectTrademark();
                        ((Milk)product).setTrademark(trademark);
                    }
                    else{
                        System.out.println("Nhập size quần áo");
                        SizeClothes size = selectSize();
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
        choice = n.nextInt();
        int indexCategory = choice - 1;
        Category category = Category.values()[indexCategory];
        return category;
    }
    public Trademark selectTrademark(){
        System.out.println("1 Thương hiệu: Royal AUSNZ");
        System.out.println("2 Thương hiệu: Nestlé");
        System.out.println("3 Thương hiệu: Aptamil");
        System.out.println("4 Thương hiệu: Abbott");
        System.out.println("5 Thương hiệu: Meiji");
        System.out.println("6 Thương hiệu: Vinamilk");
        choice = n.nextInt();
        int indexTrademark = choice - 1;
        Trademark trademark = Trademark.values()[indexTrademark];
        return trademark;
    }
    public SizeClothes selectSize(){
        System.out.println("1 - Size số 1 dành cho bé từ: 8 - 10kg");
        System.out.println("2 - Size số 2 dành cho bé từ: 10 – 12kg");
        System.out.println("3 - Size số 3 dành cho bé từ: 12 -14kg");
        System.out.println("4 - Size số 4 dành cho bé từ: 14 – 15kg");
        System.out.println("5 - Size số 5 dành cho bé từ: 15 -17kg");
        System.out.println("6 - Size số 6 dành cho bé từ: 17 – 19kg");
        System.out.println("7 - Size số 7 dành cho bé từ: 19 – 22kg");
        System.out.println("8 - Size số 8 dành cho bé từ: 22 – 26kg");
        System.out.println("9 - Size số 9 dành cho bé từ: 27 – 32kg");
        System.out.println("10 - Size số 10 dành cho bé từ: 32 – 35kg");
        choice = n.nextInt();
        int indexSizeClothes = choice - 1;
        SizeClothes size = SizeClothes.values()[indexSizeClothes];
        return size;
    }
}
