package ru.geekbrains.lessons.lesson2;

import java.util.Arrays;

public class lesson2 {

    // Задание 1
    private static int [] invertArr(int [] arr) {
        for (int i =0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {arr[i] = 1;}
        } return arr;
    }

    // Задание 2
    private static int [] fillArr( int size, int step) {
        int [] arr = new int [size];
        for (int i =0; i < arr.length; i++) {
            arr[i] = i * step;
        } return arr;
    }

    // Задание 3
    private static int [] moreThanSix1 (int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {arr[i] = arr[i] * 2;}
        } return arr;
    }
    private static int [] moreThanSix2 (int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] < 6 ? arr [i] * 2 : arr [i];
        } return arr;
    }

    // Задание 4 + ПЕЧАТЬ МАССИВА
    private static int [][] diagonalArr (int size) {
        int [][] arr = new int [size][size];
            for (int y=0; y < size; y++) {
                for (int x = 0; x < size; x++) {
                    if (x == y || x == size - y - 1) {
                        arr[y][x] = 1;
                    } else arr[y][x] = 0;
                }
            } return arr;
    }
    static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    // Задание 5
    private static int findMin(int ... arr) {
            int min = arr[0];
            for (int i : arr) {
                if (min > i) min =i;
            }
            return min;
    }

    private static int findMax(int ... arr) {
        int max = arr[0];
        for (int i : arr) {
            if (max < i) max =i;
        }
        return max;
    }

    // Задание 6

    private static boolean checkBalance (int arr []) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum +=arr[i];
            }
        if (sum % 2 != 0) return false;
        sum /=2;
        int left = 0;
        for (int i : arr) {
            left += i;
            if (left  == sum) return true;
            // if (left > sum) return false;
        } return false;

    }
    // Задание 7

    static void shift(int[] arr, int n) {
        int shift = (arr.length + n % arr.length) % arr.length;
        for (int i = 0; i < shift; i++) {
            int temp = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }
    }

    public static void main(String [] args) {

        // Задание 1
        System.out.println("Задание 1");
        int [] straightArr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        System.out.println(Arrays.toString(straightArr));
        System.out.println(Arrays.toString(invertArr(straightArr)));


        // Задание 2
        System.out.println("Задание 2");
        int [] eightArr = fillArr(8, 3);
                System.out.println(Arrays.toString(eightArr));

        // Задание 3
        System.out.println("Задание 3");
        int [] sixArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(sixArr));
        System.out.println(Arrays.toString(moreThanSix1(sixArr)));
        int [] sixArr2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(moreThanSix2(sixArr2)));

        // Задание 4
        System.out.println("Задание 4");
        printArr(diagonalArr(11));


        // Задание 5
        System.out.println("Задание 5");
        int [] minMaxArr = {1, 100, -99, 5, 89, -176, -55, 98};
        int min = findMin(minMaxArr);
        int max = findMax(minMaxArr);
        System.out.printf("Min = %d \r\nMax = %d\r\n", min, max);

        // Задание 6
        System.out.println("Задание 6");
        int [] checkArray = {5, 6 , 7 , 5, 1 , 3 , 7, 2 , 1 , 1 };
        System.out.println(Arrays.toString(checkArray));
        System.out.println(checkBalance(checkArray));
        int[] someArr = {10, 9, 8, 7, 5, 1, 4, 7, 8, 9, 10};
        System.out.println(Arrays.toString(someArr));
        System.out.println(checkBalance(someArr));

        //  Задание 7
        int[] arrToShift = {1,2,3,4,5,6,7};
        shift(arrToShift, 4);
        System.out.println(Arrays.toString(arrToShift));

    }
}
