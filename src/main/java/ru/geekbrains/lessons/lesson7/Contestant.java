package ru.geekbrains.lessons.lesson7;

public interface Contestant {

    String getName();
    String getType();
    int getMaxRunLength();
    int getMaxJumpHeight();


    default boolean run (Obstacles obstacle) {
        if (obstacle instanceof Track) {
            if (getMaxRunLength() >= obstacle.getLength()) {
                System.out.println(getType()+ " "+ getName() + " successfully ran " + obstacle.getLength() + " meters over the track");
                return true;
            }else {
                System.out.println(getType()+ " "+ getName() + " could not run " + obstacle.getLength()+ " meters");
                return false;
            }
        } return false;
    }

    default boolean jump (Obstacles obstacle) {
        if (obstacle instanceof Wall) {
            if (getMaxJumpHeight() >= obstacle.getHeight()) {
                System.out.println(getType()+ " "+ getName() + " successfully jumped over " + obstacle.getHeight() + " meters wall");
                return true;
            }else {
                System.out.println(getType()+ " "+ getName() + " could not jump for " + obstacle.getHeight() + " meters");
                return false;
            }
        } return false;
    }

}
