package controller;

import java.io.FileNotFoundException;


public interface GeneralManage<T> {
    void add(T t);

    T find(String code) throws FileNotFoundException;


    void edit(String code, T t);

    T remove(String code) throws FileNotFoundException;
}
