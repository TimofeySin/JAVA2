package ru.geekbrains.Jawa2.Lesson1.surface;

import ru.geekbrains.Jawa2.Lesson1.participant.IVoice;

public class Wall extends Obstacle {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(IVoice.Competitor competitor) {
        competitor.jump(height);
    }
}
