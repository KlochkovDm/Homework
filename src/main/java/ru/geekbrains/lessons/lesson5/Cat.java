package ru.geekbrains.lessons.lesson5;

public class Cat extends Animal {

    private static int counter;

    Cat (String name) {
        super("Cat", name, 0, 200);
        counter++;
    }

    @Override
    public void swim(int swimDistance) {
        System.out.printf("%s %s не умеет плавать!\n", getType(), getName());
    }

    public static int getCounter() {
        return counter;
    }
}
