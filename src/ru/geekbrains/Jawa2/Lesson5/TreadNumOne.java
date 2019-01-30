package ru.geekbrains.Jawa2.Lesson5;

public class TreadNumOne extends Thread {

    private float[] partArray;


    public TreadNumOne(float[] partArray) {

        this.partArray = partArray;

    }


    public float[] getPartArray() {
        return partArray;
    }

    @Override
    public void start() {
        super.start();
        for (int i = 0; i < partArray.length; i++) {
            partArray[i] = (float) (partArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

}
