package storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputOutFile<T> {
    private static InputOutFile inputOutFile;

    private InputOutFile() {
    }
    public static InputOutFile getInstance(){
        if (inputOutFile == null){
            inputOutFile = new InputOutFile();
        }
        return inputOutFile;
    }

    public  void writeFile(String url, List<T> list){
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(url);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  List<T> readToFile(String url){
        List<T> list = new ArrayList<>();
        File file = new File(url);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.length() <= 0){
            return list;
        }

        FileInputStream fis;
        try {
            fis = new FileInputStream(url);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<T>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

}
