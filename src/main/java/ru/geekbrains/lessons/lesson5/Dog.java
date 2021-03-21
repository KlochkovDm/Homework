package ru.geekbrains.lessons.lesson5;

public class Dog extends Animal {

    private static int counter;

    Dog(String name) {
        super("Dog", name, 10, 500);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
