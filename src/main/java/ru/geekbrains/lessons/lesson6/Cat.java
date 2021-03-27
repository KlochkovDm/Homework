package ru.geekbrains.lessons.lesson6;

public class Cat {

    private String name;
    private int appetite;
    private boolean fullness;


    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    public void eat(Bowl b){

        if (b.getFood() >= this.appetite) {
            System.out.printf("Cat %s ate %d food\n", this.name, this.appetite);
            b.decreaseFood(this.appetite);
            this.fullness = true;
        }
        else{
            System.out.println("Cat "+ this.name + " didn't ate anything");
            b.decreaseFood(this.appetite);
        }


    }

    public void fullnessStatus() {
        System.out.println("Cat " + this.name + (getFullness() ? " is full" : " is not full"));
    }

    public boolean getFullness() {
        return fullness;
    }
}
