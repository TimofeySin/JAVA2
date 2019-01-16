 package ru.geekbrains.Jawa2.Lesson1.surface;


 import ru.geekbrains.Jawa2.Lesson1.participant.IVoice;

 public class Water extends Obstacle {

    private int dist;

    public Water(int dist) {
        this.dist = dist;
    }

    @Override
    public void doIt(IVoice.Competitor competitor) {
        competitor.swim(dist);
    }
}
