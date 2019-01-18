package ru.geekbrains.Jawa2.Lesson1.surface;


import ru.geekbrains.Jawa2.Lesson1.participant.Team;

//3. Добавить класс Course (полоса препятствий),
// в котором будут находиться: массив препятствий,
// метод который будет просить команду пройти всю полосу;
public class Course {
    private  String name;
    private Obstacle[] obstacle;

    public Course(String name, Obstacle[] obstacle) {
        this.name = name;
        this.obstacle = obstacle;
    }

    public String getName() {
        return name;
    }

    public Obstacle[] getObstacle() {
        return obstacle;
    }

    public void gooo(Team team){


        //
    }
}
