package ru.geekbrains.Jawa2.Lesson1;

import ru.geekbrains.Jawa2.Lesson1.participant.*;
import ru.geekbrains.Jawa2.Lesson1.surface.*;
//import ru.geekbrains.Jawa2.Lesson1.surface.Obstacle;
//import ru.geekbrains.Jawa2.Lesson1.surface.Road;
//import ru.geekbrains.Jawa2.Lesson1.surface.Wall;
//import ru.geekbrains.Jawa2.Lesson1.surface.Water;


//2. Добавить класс Team, который будет содержать:
// название команды, массив из 4-х участников
// (т.е. в конструкторе можно сразу всех участников указывать),

    public class Lesson1 {
        public static void main(String[] args) {
            IVoice.Competitor[] competitors = {
                    new Dog("Jack", "black", 10, 1, 2),
                    new Cat("Mag", "white", 10, 0, 3),
                    new Turtle("Turtle", "green", 100, 10, 0),
                    new Human("Rick", "negro", 50, 20,2)
            };
            Obstacle[] obstacles = {
                    new Road(8),
                    new Wall(2),
                    new Water(1),
                    new Wall(2)
            };

            for (IVoice.Competitor competitor: competitors){
                for (Obstacle obstacle: obstacles){
                    obstacle.doIt(competitor);
                    if (!competitor.onDistance()) break;
                }
            }

            for (IVoice.Competitor competitor: competitors){
                competitor.info();
            }
        }
    }

