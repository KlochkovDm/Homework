package ru.geekbrains.lessons.lesson11;

import sun.net.www.ApplicationLaunchException;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class lesson11 {

    public static void changeElements (Object [] arr, int i, int j) {
        if ((0<= i && i < arr.length && 0<= j && j < arr.length)){
           Object temporary = arr[i];
           arr [i] = arr [j];
           arr [j] = temporary;
        } else {
            System.out.println("Values are out of array bounds");
        }
    }

    public static <T> ArrayList <T> arrayToArrayList (T[] arr) {
       ArrayList <T> arrayList = new ArrayList<>();
       for ( T obj : arr) {
            arrayList.add(obj);
       } return arrayList;
    }

    public static void main(String[] args) {
        ArrayList<Apple> appleList = new ArrayList<Apple>(Arrays.asList(new Apple(),new Apple()));
        Box<Apple> appleBox1 = new Box <> (appleList);
        Box<Apple> appleBox2 = new Box <> (new Apple());
        Box<Orange> orangeBox = new Box <> (new Orange());

        System.out.println(appleBox1.compare(appleBox2));
        System.out.println(appleBox1.compare(orangeBox) + "\n1st box weight is " + appleBox1.getWeight() + " : 2nd box weight is " + orangeBox.getWeight());
        appleBox1.transferFrom(appleBox2);
        System.out.println(appleBox2.getWeight());
        orangeBox.addFruit(new Orange());
        System.out.println(appleBox1.compare(orangeBox) + "\n1st box weight is " + appleBox1.getWeight() + " : 2nd box weight is " + orangeBox.getWeight());



    }

}
