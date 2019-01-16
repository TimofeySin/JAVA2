package ru.geekbrains.Jawa2.Lesson1.participant;

public class Human extends Animal implements IVoice.Competitor {

    public Human(String name, String color, int maxRunDistance, int maxSwimDistance, int maxJumpHeight) {
        super(name, color, maxRunDistance, maxSwimDistance, maxJumpHeight);
    }

//    @Override
//    public void run(int dist) {
//        if (dist <= this.maxRunDistance){
//            System.out.println(name + " пробегает " + dist + "km");
//        }else {
//            System.out.println(name + " не пробегает " + dist + "km");
//            onDistance = false;
//        }
//    }
//
//    @Override
//    public void swim(int dist) {
//        if (dist <= maxSwimDistance){
//            System.out.println(name +" проплывает " + dist + "km");
//        }else {
//            System.out.println(name + " не проплывает " + dist + "km");
//            onDistance = false;
//        }
//    }
//
//    @Override
//    public void jump(int height) {
//        if (height <= maxJumpHeight){
//            System.out.println(name +" перепрыгивает " + height + "m");
//        }else {
//            System.out.println(name + " не перепрыгивает " + height + "m");
//            onDistance = false;
//        }
//    }
//
//    @Override
//    public boolean onDistance() {
//        return onDistance;
//    }

//    @Override
//    public void info() {
//        System.out.println(name + (onDistance ? " прошел" : " не прошел" ));
//    }
}
