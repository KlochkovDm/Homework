package ru.geekbrains.lessons.lesson7;

public class Robot implements Contestant {

    private String type = "Robot";
    private String name;
    private int maxJumpHeight;
    private int maxRunLength;

    public Robot (String name, int maxJumpHeight, int maxRunLength) {
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunLength = maxRunLength;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getMaxRunLength() {
        return maxRunLength;
    }

    @Override
    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }

}
