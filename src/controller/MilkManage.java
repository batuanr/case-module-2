package controller;

import model.product.Milk;
import storage.IO;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MilkManage implements GeneralManage<Milk> {
    private IO io = IO.getInstance();
    private final String MILK_FILE = "milk.obj";
    private List<Milk> milkList = new ArrayList<>();

    public MilkManage() {
        this.milkList = io.readToFile(MILK_FILE);
    }

    @Override
    public void add(Milk milk) {
        milkList.add(milk);
        io.writeFile(MILK_FILE, milkList);
    }

    @Override
    public Milk find(String code) throws FileNotFoundException {
        for (Milk milk: milkList){
            if (milk.getCode().equals(code)){
                return milk;
            }
        }
        throw new FileNotFoundException();
    }

    @Override
    public void edit(String code, Milk milk) {
        for (int i = 0; i < milkList.size(); i++) {
            if (milkList.get(i).getCode().equals(code)){
                milkList.set(i, milk);
                io.writeFile(MILK_FILE, milkList);
                break;
            }
        }
    }

    @Override
    public Milk remove(String code) throws FileNotFoundException {
        Milk milk = find(code);
        milkList.remove(milk);
        io.writeFile(MILK_FILE, milkList);
        return milk;
    }

    public List<Milk> findMilkByCategory(String category){
        List<Milk> milks = new ArrayList<>();
        for (Milk milk: milkList){
            if (milk.getCategory().equals(category)){
                milks.add(milk);
            }
        }
        return milks;
    }

    public List<Milk> findMilkByManufacturer(String manufacturer){
        List<Milk> milks = new ArrayList<>();
        for (Milk milk: milkList){
            if (milk.getManufacturer().equals(manufacturer)){
                milks.add(milk);
            }
        }
        return milks;
    }
}
