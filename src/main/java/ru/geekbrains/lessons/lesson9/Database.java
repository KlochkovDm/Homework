package ru.geekbrains.lessons.lesson9;

import java.sql.*;

public class Database {


    public static void main(String[] args) {

        Cat c1 = new Cat ("Barsik","White", 1);
        Cat c2 = new Cat ("Murzik","Black", 2);
        Cat c3 = new Cat ("Pushok","Brown", 3);
        Cat c4 = new Cat ("Persik","Orange", 2);

        CatBase cb = new CatBase ();

        try {

            cb.connect();
            cb.dropCreate();

            cb.insertCat(c1);
            cb.insertCat(c2);
            cb.insertCat(c3);
            cb.insertCat(c4);

            cb.updateCatByID(c3,2);
            cb.deleteCatByID(3);
            cb.printCatByID(1);

            System.out.println(cb.getCatByID(1).toString());



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            cb.disconnect();
        }

    }

}
