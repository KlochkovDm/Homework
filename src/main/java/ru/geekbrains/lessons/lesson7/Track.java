package ru.geekbrains.lessons.lesson7;

public class Track implements Obstacles {

    private int length;

    public Track(int length) {
        this.length = length;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
