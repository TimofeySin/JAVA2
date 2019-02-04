package ru.geekbrains.Jawa2.Lesson6;

public class Listen extends Thread{
    private boolean kill = false;

    public boolean isKill() {
        return kill;
    }

    public void setKill(boolean kill) {
        this.kill = kill;
    }

}
