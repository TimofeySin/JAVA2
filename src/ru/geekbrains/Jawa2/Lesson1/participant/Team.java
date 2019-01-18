package ru.geekbrains.Jawa2.Lesson1.participant;

import ru.geekbrains.Jawa2.Lesson1.surface.Course;
import ru.geekbrains.Jawa2.Lesson1.surface.Obstacle;

// Добавить класс Team, который будет содержать:
// название команды, массив из 4-х участников (т.е. в конструкторе можно сразу всех участников указывать),
// метод для вывода информации о членах команды прошедших дистанцию, метод вывода информации обо всех членах команды.
public class Team {

    private Competitor[] animals;
    private String name;
    private int point;

    public Competitor[] getAnimals() {
        return animals;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Team(String name, Competitor[] animals) {
        this.animals = animals;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void raceThrough(Course courses) {
        for (Competitor animal:animals) {
            for (Obstacle course: courses.getObstacle()) {
                course.doIt(animal);
                if (animal.onDistance()) point++;
            }
        }
    }

    public void showResult(){

        System.out.println("Команда "+name+" набрала "+point+" очков.");


    }

    public int getPoint() {
        return point;
    }
}
