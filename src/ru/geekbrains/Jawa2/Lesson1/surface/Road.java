package ru.geekbrains.Jawa2.Lesson1.surface;

import ru.geekbrains.Jawa2.Lesson1.participant.Competitor;


public class Road extends Obstacle {
    private int dist;

    public Road(int dist) {
        this.dist = dist;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(dist);
    }
}
