package ru.geekbrains.Jawa2.lesson1;

public class TryStatic {
    static String name = "hello";

    String name2;

    public String getName(){
        return name;
    }

    public static String hello(){
        return name;
    }
}
