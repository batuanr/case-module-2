package controller;


import model.Category;
import model.SizeClothes;
import model.Trademark;
import model.product.Clothes;
import model.product.Milk;
import model.product.Product;
import storage.InputOutFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManage implements GeneralManage<Product> {
    private InputOutFile inputOutFile = InputOutFile.getInstance();
    private final String PRODUCT_FILE = "product.obj";
    private List<Product> productList = new ArrayList<>();

    public ProductManage() {
        this.productList = inputOutFile.readToFile(PRODUCT_FILE);
    }

    public String getPRODUCT_FILE() {
        return PRODUCT_FILE;
    }

    public List<Product> getProductList() {
        return inputOutFile.readToFile(PRODUCT_FILE);
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
        inputOutFile.writeFile(PRODUCT_FILE, productList);
    }

    @Override
    public Product find(String code) throws FileNotFoundException {
        productList = inputOutFile.readToFile(PRODUCT_FILE);
        for (Product product: productList){
            if (product.getCode().equals(code)){
                return product;
            }
        }
        throw new FileNotFoundException();
    }

    @Override
    public void edit(String code, Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getCode().equals(code)){
                productList.set(i, product);
                inputOutFile.writeFile(PRODUCT_FILE, productList);
                break;
            }
        }
    }

    @Override
    public Product remove(String code) throws FileNotFoundException {
        Product product = find(code);
        productList.remove(product);
        inputOutFile.writeFile(PRODUCT_FILE, productList);
        return product;
    }

    public List<Product> findByCategory(Category category){
        List<Product> products = new ArrayList<>();
        for (Product product: productList){
            if (product.getCategory().equals(category)){
                products.add(product);
            }
        }
        return products;
    }

    public List<Product> findByTrademark(Trademark trademark){
        List<Product> products = new ArrayList<>();
        for (Product product: getProductList()){
            if (product instanceof Milk && ((Milk) product).getTrademark().equals(trademark)){
                productList.add(product);
            }
        }
        return products;
    }
    public List<Product> findBySize(SizeClothes size){
        List<Product> products = new ArrayList<>();
        for (Product product: getProductList()){
            if (product instanceof Clothes && ((Clothes) product).getSize().equals(size)){
                products.add(product);
            }
        }
        return products;
    }
    public List<Product> getMlkList(){
        List<Product> products = new ArrayList<>();
        for (Product product: getProductList()){
            if (product instanceof Milk){
                products.add(product);
            }
        }
        return products;
    }
    public List<Product> getClothesList(){
        List<Product> products = new ArrayList<>();
        for (Product product: productList){
            if (product instanceof Clothes){
                products.add(product);
            }
        }
        return products;
    }
    public List<Product> sortByPriceToDown(){
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (o1.getPrice() < o2.getPrice()) ? 1 : -1;
            }
        };
        Collections.sort(productList, comparator);
        return productList;
    }
    public List<Product> sortByPriceToUp(){
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (o1.getPrice() > o2.getPrice()) ? 1 : -1;
            }
        };
        Collections.sort(productList, comparator);
        return productList;
    }
}
