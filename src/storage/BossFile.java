package storage;

import model.Boss;

import java.io.*;


public class BossFile {
    private static BossFile bossFile;
    private final  String BOSS_FILE = "boss.obj";

    private BossFile() {
    }

    public static BossFile getInstance(){
        if (bossFile == null){
            bossFile = new BossFile();
        }
        return bossFile;
    }


    public  Boss readFile() throws IOException, ClassNotFoundException {
        File file = new File(BOSS_FILE);
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() >0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            Boss boss = (Boss) object;
            objectInputStream.close();
            fileInputStream.close();
            return boss;
        }
        else return new Boss("admin", "12345678");
    }
    public  void writeFile(Boss boss) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(BOSS_FILE);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(boss);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}