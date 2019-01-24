package ru.geekbrains.Jawa2.Lesson2;


import ru.geekbrains.Jawa2.Lesson2.my_throw.MyArrayDataException;
import ru.geekbrains.Jawa2.Lesson2.my_throw.MyArraySizeException;

public class Lesson2 {
    static int MAX_SIZE_ARRAY = 4;

    public static void main(String[] args) throws Exception {
        String[][] arrayles2 = {{"1", "2", "r", "r"}, {"1", "3", "g"}, {"c0", "3", "4", "4", "4"}, {"2", "3", "4"}, {"2", "3", "4"}};
        startCheckArray(0, arrayles2);
        int sum = CheckData(arrayles2);
        System.out.println("Сумма массива равна: "+sum);

    }

    private static int CheckData(String[][] arrayles2) {

        MyArrayDataException throwData = new MyArrayDataException();
        int sum = 0;
        for (int i = 0; i < arrayles2.length; i++) {
            for (int j = 0; j < arrayles2[i].length; j++) {
                try {
                    sum += Integer.parseInt(arrayles2[i][j]);
                } catch (NumberFormatException e) {
                    throwData.setMessage(i,j,arrayles2[i][j]);
                }
            }
        }
        for (String str : throwData.getListError()) {
            System.out.println(str);
        }

        System.out.println();
        return sum;
    }

    public static void startCheckArray(int i, String[][] arrays) {
        MyArraySizeException throwSize = new MyArraySizeException();
        throwSize.setStageLevel(StageCheck.LEVEL1);
        checkArray(arrays, throwSize);
        for (String str : throwSize.getListError()) {
            System.out.println(str);
        }
    }

    public static void checkArray(String[][] arrays, MyArraySizeException throwSize) {
        if (throwSize.getStageLevel() == StageCheck.LEVEL1) {
            if (arrays.length != MAX_SIZE_ARRAY) {
                throwSize.setMessage("основного", MAX_SIZE_ARRAY, arrays.length);
                throwSize.setStageLevel(StageCheck.OTHERS);
            }
        }

        if (throwSize.getStageLevel() == StageCheck.OTHERS) {
            for (int i = 0; i < arrays.length; i++) {
                if (arrays[i].length != MAX_SIZE_ARRAY) {
                    throwSize.setMessage("Встроенного по адресу " + i, MAX_SIZE_ARRAY, arrays[i].length);
                }
            }
        }
    }
}
