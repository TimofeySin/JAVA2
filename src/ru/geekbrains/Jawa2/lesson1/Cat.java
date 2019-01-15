package ru.geekbrains.Jawa2.lesson1;

public class Cat extends Animal implements IVoice {

    public Cat(String color, String name, int weight) {
        super(color, name, weight);
    }

    @Override
    public void voice() {
        System.out.println("may");
    }

}
