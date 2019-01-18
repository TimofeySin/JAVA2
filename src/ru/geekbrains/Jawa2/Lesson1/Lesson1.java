package ru.geekbrains.Jawa2.Lesson1;

import ru.geekbrains.Jawa2.Lesson1.participant.*;
import ru.geekbrains.Jawa2.Lesson1.surface.*;


//2. Добавить класс Team, который будет содержать:
// название команды, массив из 4-х участников
// (т.е. в конструкторе можно сразу всех участников указывать),

public class Lesson1 {

    public static void main(String[] args) {
        Course[] courses;
        Team[] teams;
        Object[] objects;
        Team teamWinner= null;

        objects = (Object[]) initAll();

        courses = (Course[]) objects[0];
        teams = (Team[]) objects[1];

        for (Team team : teams) {
            for (Course course : courses) {
                team.raceThrough(course);
            }
            if (teamWinner == null) teamWinner = team;
            else if (teamWinner.getPoint()<team.getPoint()) teamWinner = team;
            else if (teamWinner.getPoint()==team.getPoint()) teamWinner = null;
        }

        System.out.println("\n");
        for (Team team : teams) {

            team.showResult();
        }

        if (teamWinner == null) {
            System.out.println("Победила дружба!\n обе команды набрали по "+teams[0].getPoint()+" очков.");
        } else {
            System.out.println("Победила команда " + teamWinner.getName() + ", набрав "+teamWinner.getPoint() + " очков!");
            for (Competitor animal: teamWinner.getAnimals()) {
                if (animal instanceof IVoice) {
                    System.out.print(animal.getClassName() + " по имени "+animal.getName()+" сказало ");
                    ((IVoice) animal).voice();
                } else {
                    System.out.println(animal.getClassName() + " по имени "+animal.getName()+" промолчала.");
                }
            }
        }


    }

    public static Object initAll() {


        Competitor[] competitors1 = {
                new Dog("Jack", "black", 10, 1, 2),
                new Cat("Mag", "white", 10, 0, 3),
                new Turtle("Turtle", "green", 5, 10, 0),
                new Human("Rick", "negro", 50, 20, 2)};

        Team team1 = new Team("Team1", competitors1);

        Competitor[] competitors2 = {
                new Bird("Chijz", "yellow", 100, 0, 100),
                new Fish("Fishyyy", "black", 0, 100, 0),
                new Turtle("Castle", "grey", 2, 10, 0),
                new Dog("Jack", "white", 80, 23, 1)};
        Team team2 = new Team("Team2", competitors2);

        Obstacle[] obstacles1 = {
                new Road(8),
                new Wall(2),
                new Water(1),
                new Wall(2)
        };
        Course course1 = new Course("Level1", obstacles1);


        Obstacle[] obstacles2 = {
                new Road(16),
                new Wall(5),
                new Water(10),
                new Wall(1)
        };
        Course course2 = new Course("Level2", obstacles2);

        Course[] courses = new Course[]{course1, course2};

        Team[] teams = new Team[]{team1, team2};


        return new Object[]{courses,teams};


    }
}



