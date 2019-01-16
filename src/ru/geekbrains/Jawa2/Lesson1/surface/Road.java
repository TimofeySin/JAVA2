package ru.geekbrains.Jawa2.Lesson1.surface;

import ru.geekbrains.Jawa2.Lesson1.participant.IVoice;

public class Road extends Obstacle {
    private int dist;

    public Road(int dist) {
        this.dist = dist;
    }

    @Override
    public void doIt(IVoice.Competitor competitor) {
        competitor.run(dist);
    }
}
