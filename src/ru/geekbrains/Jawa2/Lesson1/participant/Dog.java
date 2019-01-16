package ru.geekbrains.Jawa2.Lesson1.participant;

public class Dog extends Animal implements IVoice {
    public Dog(String name, String color, int maxRunDistance, int maxSwimDistance, int maxJumpHeight) {
        super(name, color, maxRunDistance, maxSwimDistance, maxJumpHeight,"Собака");
    }
    @Override
    public void voice() {
        System.out.println("gav");
    }
}
