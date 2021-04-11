package ru.geekbrains.lessons.lesson10;

import java.sql.SQLOutput;
import java.util.*;

public class Phonebook {

    private final TreeMap<String, Set<String>> phonebook = new TreeMap<>() ;


    public void add(String name, String phone) {
//        phonebook.getOrDefault(name.toLowerCase(),new TreeSet<String>());

        phonebook.put(name.toLowerCase(),phonebook.getOrDefault(name.toLowerCase(),new TreeSet<String>()));
        Set <String> phones = phonebook.get(name.toLowerCase());
        phones.add(phone);
    }

    public void getPhone (String name) {
        System.out.println("Contact " + name + " : ");
        for(String phone : phonebook.get(name.toLowerCase())){
            System.out.println("tel: "+ phone);
        };

    }
    public Set <String> getAllContacts(){
        return phonebook.keySet();}
}


