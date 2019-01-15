package ru.geekbrains.Jawa2.lesson1.marathon;

public class Main {
    public static void main(String[] args) {
        Competitor[] competitors = {
                new Dog("Jack", "black", 10, 1, 2),
                new Cat("Mag", "white", 10, 0, 3),
                new Turtle("Turtle", "green", 100, 10, 0),
                new Human("Rick", 8, 10, 2)
        };
        Obstacle[] obstacles = {
                new Road(8),
                new Wall(2),
                new Water(1),
                new Wall(2)
        };

        for (Competitor competitor: competitors){
            for (Obstacle obstacle: obstacles){
                obstacle.doIt(competitor);
                if (!competitor.onDistance()) break;
            }
        }

        for (Competitor competitor: competitors){
            competitor.info();
        }
    }
}
