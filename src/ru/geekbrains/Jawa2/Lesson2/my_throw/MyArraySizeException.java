package ru.geekbrains.Jawa2.Lesson2.my_throw;


import ru.geekbrains.Jawa2.Lesson2.StageCheck;

import java.util.ArrayList;
import java.util.List;

public class MyArraySizeException extends Exception {

    String message;
    List<String> listError = new ArrayList<String>();
    StageCheck StageLevel = StageCheck.LEVEL1;

    public List<String> getListError() {
        return listError;
    }

    public MyArraySizeException() {
        this.StageLevel = StageCheck.LEVEL1;
        this.message = ("Размер %s массива равен %d , а должен быть равен %d");
    }

    public StageCheck getStageLevel() {
        return StageLevel;
    }

    public void setStageLevel(StageCheck stageLevel) {
        StageLevel = stageLevel;
    }

    public void setMessage(String type, int right, int current) {
        listError.add(String.format(this.message, type, current,right));


    }
}


