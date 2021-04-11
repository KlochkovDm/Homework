package ru.geekbrains.lessons.lesson10;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    private static String someWords = "Du " +
            "Du hast " +
            "Du hast mich "+
            "Du hast mich "+
            "Du hast mich gefragt " +
            "Du hast mich gefragt " +
            "Du hast mich gefragt " +
            "und ich hab nichts gesagt";

    public static void uniqWords (String s) {
        String[] arr = s.toLowerCase().split(" ");
        TreeMap<String, Integer> mentions = new TreeMap<>();
        for (String word : arr){
            mentions.put(word,(mentions.getOrDefault(word,0)+1));
        }
        System.out.println(mentions);
    }




    public static void main(String[] args) {
        uniqWords(someWords);

        Phonebook p = new Phonebook();
        p.add("Petrov", "88005553535");
        p.add("Sidorov", "8495241141");
        p.add("Ivanov", "8495500600");
        p.add("Sidorov", "8987654321");
        p.getPhone("sidorov");
        System.out.println(p.getAllContacts());
    }



}
