package ru.geekbrains.lessons.lesson5;

public class RunAndSwim {

    public static void main(String[] args){

        Animal[] animal ={
            new Dog("Bobik"),
            new Dog("Rex"),
            new Dog("Mukhtar"),
            new Cat("Persik"),
            new Cat("Pushok"),
            new Cat("Vaska"),
            new Cat("Murzik"),
        };

        for (Animal a : animal) {
            a.swim(7);
            a.run(150);
            a.swim(15);
            a.run(400);

        }
        System.out.printf("%d - Amimals\n%d - Dogs\n%d - Cats", Animal.getCounter(), Dog.getCounter(),Cat.getCounter());

    }




}
