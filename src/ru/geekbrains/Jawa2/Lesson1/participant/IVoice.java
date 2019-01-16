package ru.geekbrains.Jawa2.Lesson1.participant;

public interface IVoice {
    public void voice();

    interface Competitor {

        void run(int dist);
        void swim(int dist);
        void jump(int height);

        boolean onDistance();
        void info();
    }
}
