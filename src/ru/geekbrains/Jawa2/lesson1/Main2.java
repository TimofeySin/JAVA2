package ru.geekbrains.Jawa2.lesson1;

public class Main2 {
    public static void main(String[] args) {
        IVoice[] voiceAnimals = {
                new Cat("Black", "Murzik", 12),
                new Bird("Red", "Peter", 1)
        };

        for (IVoice animal: voiceAnimals){
            animal.voice();
        }
    }
}
