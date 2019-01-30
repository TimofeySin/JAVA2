package ru.geekbrains.Jawa2.Lesson5;

public class Lesson5 {
    static final int size = 10000000;
    static final int numberThread = 1000000;


    public static void main(String[] args) {
        float[] arr = new float[size];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = 1f;
        }

        System.out.println("Затраченное время на вычисления массива: " + size + ", в " + numberThread + " потоков: " + arrayInOne(arr)/1000 + " сек");
        System.out.println("Затраченное время на вычисления массива: " + size + ", без потоков: " + rightMath(arr)/1000 + " сек");

    }


    public static long arrayInOne(float[] arr ) {

        long start = System.currentTimeMillis();
        Object[] allParts = diffArray(arr);

        TreadNumOne[] arrayThread = new TreadNumOne[numberThread];


        for (int i = 0; i < arrayThread.length; i++) {
            arrayThread[i] = new TreadNumOne((float[]) allParts[i]);
            arrayThread[i].start();
        }

        try {
            for (int i = 0; i < arrayThread.length; i++) {
                arrayThread[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < arrayThread.length; i++) {

            float[] temparr =  arrayThread[i].getPartArray();
            int lenTempArr = temparr.length;
            int destPos = 0;

            System.arraycopy(temparr,0,arr, destPos,lenTempArr);
            destPos +=lenTempArr;

        }




        return System.currentTimeMillis() - start;
    }

    public static Object[] diffArray(float[] arr) {

        int modAfterDiff = size % numberThread;

        int sizeOneThread = (size - modAfterDiff) / numberThread;

        Object[] allParts = new Object[numberThread];

        int startPos = 0;

        for (int i = 0; i < numberThread; i++) {
            if (i == numberThread - 1) {
                sizeOneThread += modAfterDiff;
            }
            float[] tempArr = new float[sizeOneThread];

            System.arraycopy(arr, startPos, tempArr, 0, sizeOneThread);
            allParts[i] = tempArr;
            startPos += sizeOneThread;


        }

        return allParts;

    }

    public static long rightMath(float[] arr) {


        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        return System.currentTimeMillis() - start;
    }
}
