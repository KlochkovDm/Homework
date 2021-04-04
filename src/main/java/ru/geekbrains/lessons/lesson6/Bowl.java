package ru.geekbrains.lessons.lesson6;

public class Bowl {

    public Bowl() {
    }

    private int food;
    public Bowl(int food) {
        this.food = food;
    }

    public void putFood (int amount) {
        this.food +=amount;
        System.out.printf("We have put %d of food to the bowl. Now there is %d of food\n", amount, this.food);
    }

    public void takeFood(int amount) {
        this.food -=amount;
        System.out.printf("We have took %d of food from the bowl. Now there is %d of food\n", amount, this.food);
    }


    public void decreaseFood (int amount) {
        if ((this.food - amount) >= 0){
            this.food -= amount;
            System.out.println("Food decreased. There are " + getFood()+ " of food left in bowl");
        }else System.out.println("Food is not enough to decrease. There are still " + getFood()+ " of food left in bowl");
    }

    public int getFood() {
        return food;
    }
}
