package controller;

import model.product.Clothes;
import storage.InputOutFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ClothesManage implements GeneralManage<Clothes> {
    private InputOutFile inputOutFile = InputOutFile.getInstance();
    private final String CLOTHES_FILE = "clothes.obj";
    private List<Clothes> clothesList = new ArrayList<>();

    public ClothesManage() {
        this.clothesList = inputOutFile.readToFile(CLOTHES_FILE);
    }

    @Override
    public void add(Clothes clothes) {
       clothesList.add(clothes);
       inputOutFile.writeFile(CLOTHES_FILE, clothesList);
    }

    @Override
    public Clothes find(String code) throws FileNotFoundException {
        for (Clothes clothes: clothesList){
            if (clothes.getCode().equals(code)){
                return clothes;
            }
        }
        throw new FileNotFoundException();
    }

    @Override
    public void edit(String code, Clothes clothes) {
        for (int i = 0; i < clothesList.size(); i++) {
            if (clothesList.get(i).getCode().equals(code)){
                clothesList.set(i, clothes);
                inputOutFile.writeFile(CLOTHES_FILE, clothesList);
                break;
            }
        }
    }

    @Override
    public Clothes remove(String code) throws FileNotFoundException {
        Clothes clothes = find(code);
        clothesList.remove(clothes);
        inputOutFile.writeFile(CLOTHES_FILE, clothesList);
        return clothes;
    }
}
