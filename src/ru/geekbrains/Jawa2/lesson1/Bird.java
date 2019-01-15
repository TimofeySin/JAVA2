package ru.geekbrains.Jawa2.lesson1;

public class Bird extends Animal implements IVoice{
    public Bird(String color, String name, int weight) {
        super(color, name, weight);
    }

    @Override
    public void voice() {
        System.out.println("chirick");
    }
}
