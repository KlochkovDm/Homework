package ru.geekbrains.lessons.lesson14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lesson14 {

    public static int [] afterFour (int [] arr) {
        int lastFourInArr = -1;
        int[] arrUpd = new int[0];

        for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 4) {lastFourInArr = i;}
        }
        try {
            if(lastFourInArr== -1) throw new RuntimeException();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (lastFourInArr >= arr.length) {
            System.out.println("Provided Array ends with 4");
        } else {arrUpd = Arrays.copyOfRange(arr, lastFourInArr + 1, arr.length);}
        return arrUpd;
    }


    public static boolean oneAndFour (int [] arr) {
        List <Integer> list = new ArrayList<>(Arrays.asList(arr));
        boolean hasFour = list.contains(4);
        boolean hasOne = list.contains(1);
        boolean hasNotElse = true;
        boolean answer;
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i) ==4 )|| (list.get(i) == 1)){
                hasNotElse = true;
            } else {
                hasNotElse = false;
                break;
            }
        }
        if (hasFour&&hasOne&&hasNotElse) {
            answer = true;
        }else answer = false;
        return answer;
    }

    public static void main(String[] args) {
//        int[] arr3   = {1,2 ,5 ,5 ,2 ,3 ,5 ,1,7};
//        afterFour(arr3);
        int[] arr1 = {1,1,1,4,4,1,4,4};
        System.out.println(oneAndFour(arr1));
    }

}
