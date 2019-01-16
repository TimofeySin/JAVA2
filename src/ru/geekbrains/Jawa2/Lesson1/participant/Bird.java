package ru.geekbrains.Jawa2.Lesson1.participant;

public class Bird extends Animal implements IVoice {

    public Bird(String name, String color, int maxRunDistance, int maxSwimDistance, int maxJumpHeight) {
        super(name, color, maxRunDistance, maxSwimDistance, maxJumpHeight);
    }

    @Override
    public void voice() {
        System.out.println("chirick");
    }
}
