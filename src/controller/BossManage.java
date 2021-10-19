package controller;

import model.Boss;
import storage.BossFile;

import java.io.IOException;

public class BossManage {
    private BossFile bossFile = BossFile.getInstance();
    private Boss boss;

    public BossManage() {
        try {
            boss = bossFile.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getId() {
        return boss.getId();
    }

    public void setId(String id) {
        boss.setId(id);
        try {
            bossFile.writeFile(boss);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPassword() {
        return boss.getPassword();
    }

    public void setPassword(String password) {
        boss.setPassword(password);
        try {
            bossFile.writeFile(boss);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
