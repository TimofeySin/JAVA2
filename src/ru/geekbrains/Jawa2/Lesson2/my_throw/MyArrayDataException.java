package ru.geekbrains.Jawa2.Lesson2.my_throw;

import java.util.ArrayList;
import java.util.List;

public class MyArrayDataException  extends NumberFormatException{
    String message;
    List<String> listError = new ArrayList<String>();


    public MyArrayDataException() {
        this.message = "В ячейке массива по адресу: %d : %d содержится символ %s"; }

    public void setMessage(int i, int j, String s) {
        listError.add(String.format(this.message, i, j,s));
    }

    public List<String> getListError() {
        return listError;
    }
}
