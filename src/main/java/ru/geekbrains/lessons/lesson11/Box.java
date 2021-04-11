package ru.geekbrains.lessons.lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box  <F extends Fruit >{
    private ArrayList<F> box = new ArrayList<>();

    public Box(ArrayList<F> box) {
        this.box = box;
    }

    public Box() {
    }
    public Box(F... fruits) {
        this.box = new ArrayList<>(Arrays.asList(fruits));
    }

    public double getWeight () {
        double weight = 0;
        for (F fruit : box) {
            weight += fruit.getWeight();
        } return weight;
    }

    public boolean compare (Box <?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void transferFrom (Box <F> anotherBox) {
        if (this == anotherBox) return;
        this.box.addAll(anotherBox.box);
        anotherBox.box.clear();
    }

    public void addFruit (F fruit) {
        this.box.add(fruit);
    }

}
