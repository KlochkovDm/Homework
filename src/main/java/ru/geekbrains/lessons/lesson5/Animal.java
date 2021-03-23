package ru.geekbrains.lessons.lesson5;

public class Animal {

    private static int counter;
    private String type;
    private String name;
    private int maxSwim;
    private int maxRun;

    public Animal (String type, String name, int maxSwim, int maxRun) {
        this.type = type;
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        counter ++;
    }

    public void swim (int swimDistance) {
        if (swimDistance <= maxSwim) {
            System.out.printf("%s %s проплыл %d метров\n", this.type, this.name, swimDistance);
        }
        else System.out.printf("%s %s смог проплыть только %d метров из %d\n", this.type, this.name, this.maxSwim, swimDistance);
    }

    public void run (int runDistance) {
        if (runDistance <= maxRun) {
            System.out.printf("%s %s пробежал %d метров\n", this.type, this.name, runDistance);
        }
        else System.out.printf("%s %s смог пробежать только %d метров из %d\n", this.type, this.name, this.maxRun, runDistance);
    }

    public String getName() {return name;}
    public String getType() {
        return type;
    }

    public static int getCounter() {
        return counter;
    }

}
