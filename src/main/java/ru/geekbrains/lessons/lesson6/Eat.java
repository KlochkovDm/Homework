package ru.geekbrains.lessons.lesson6;

public class Eat {


    public static void main(String[] args) {

        Cat cats [] = {
                new Cat ("Pushok", 10),
                new Cat ("Klubok", 11),
                new Cat ("Vaska", 12),
                new Cat ("Barsik", 15),
                new Cat ("Ryzhik", 10)
        };

        Bowl catBowl = new Bowl();
        catBowl.putFood(55);

        for (Cat cat :cats) {
            cat.eat(catBowl);
        }

        for (Cat cat :cats) {
            cat.fullnessStatus();
        }

    }
}
