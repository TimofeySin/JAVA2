package ru.geekbrains.Jawa2.Lesson1.participant;

public class Cat extends Animal implements IVoice {

    public Cat(String name, String color, int maxRunDistance, int maxSwimDistance, int maxJumpHeight) {
        super(name, color, maxRunDistance, maxSwimDistance, maxJumpHeight,"Кошка");
    }

    @Override
    public void voice() {
        System.out.println("may");
    }

}
