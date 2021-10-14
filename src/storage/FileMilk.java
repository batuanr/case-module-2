package storage;

import model.product.Milk;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileMilk {
    public static List<Milk> readFile() throws IOException, ClassNotFoundException {
        File file = new File("list.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() >0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            List<Milk> list = (List<Milk>) object;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else return new ArrayList<>();
    }
    public static void writeFile(List<Milk> students) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("list.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(students);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}