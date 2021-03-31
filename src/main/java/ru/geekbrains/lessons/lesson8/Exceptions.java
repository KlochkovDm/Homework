package ru.geekbrains.lessons.lesson8;

public class Exceptions {

    public static void main(String[] args) {

        String[][] arr1 = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};

        String[][] arr2 = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "Hello", "11", "12"},
                {"13", "14", "15", "16"}};

        String[][] arr3 = new String[][]{
                {"1", "2", "3"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15"}};

        try {
            myArraySum(arr1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            myArraySum(arr2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            myArraySum(arr3);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void myArraySum (String arr [][]) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (arr.length != 4) throw new MyArraySizeException("not a 4x4 array!");

        for (int i = 0; i < 4; i++) {
            if (arr[i].length != 4) throw new MyArraySizeException("not a 4x4 array!");
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt (arr[i][j]);
                    } catch (NumberFormatException e) {
                    throw new MyArrayDataException ("Element "+ (j+1) +" in line " + (i+1) + " is not a number");
                }
            }
        }
        System.out.println("Sum of all array elements is " + sum);
    }

}
