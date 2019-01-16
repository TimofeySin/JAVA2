package ru.geekbrains.Jawa2.Lesson1.participant;

import ru.geekbrains.Jawa2.Lesson1.surface.Course;
import ru.geekbrains.Jawa2.Lesson1.surface.Obstacle;

// Добавить класс Team, который будет содержать:
// название команды, массив из 4-х участников (т.е. в конструкторе можно сразу всех участников указывать),
// метод для вывода информации о членах команды прошедших дистанцию, метод вывода информации обо всех членах команды.
public class Team {

    private IVoice.Competitor[] animals;
    private String name;
    private int point;


    public Team( String name, IVoice.Competitor[] animals) {
        this.animals = animals;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void raceThrough(Course courses) {
        for (IVoice.Competitor animal:animals) {
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
