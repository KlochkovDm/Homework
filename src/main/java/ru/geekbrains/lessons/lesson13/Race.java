package ru.geekbrains.lessons.lesson13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Race {
    private Lock lock ;

    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        this.lock = new ReentrantLock();
    }

    public boolean winner () {
       return this.lock.tryLock();
    }
}