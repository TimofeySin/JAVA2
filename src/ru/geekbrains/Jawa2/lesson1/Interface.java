package ru.geekbrains.Jawa2.lesson1;

public interface Interface {
    public int A = 1;
    public void method();

    default void method2(){
        System.out.println("123");
    }
}
