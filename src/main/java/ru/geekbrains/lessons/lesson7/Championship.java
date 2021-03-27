package ru.geekbrains.lessons.lesson7;

public class Championship {

    public static void main(String[] args) {

        Contestant[] contestants = {
                new Cat("Persik",2,200),
                new Cat("Barsik",1,500),
                new Human("Usain Bolt",2,2000),
                new Human("Isinbaeva",10,1000),
                new Robot("WallE",2,1500),
                new Robot("Megatron",15,2500),
            };

        Obstacles [] obstacles = {
                new Track (100),
                new Wall (1),
                new Track (1200),
                new Wall (3),
                new Track (2000),
                new Wall (5),

        };

        for (Contestant c :contestants){
            for (Obstacles o : obstacles){
                if(!(c.jump(o) || c.run(o))) {
                    System.out.println(c.getName() + " stopped");
                    break;
                }
            }
        }
    }
}
