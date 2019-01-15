package ru.geekbrains.Jawa2.lesson1;

public abstract class Animal {
    protected String color;
    protected String name;
    protected int weight;

    public Animal(String color, String name, int weight) {
        this.color = color;
        this.name = name;
        this.weight = weight;
    }
}
