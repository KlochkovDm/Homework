package ru.geekbrains.lessons;

public class lesson1 {

    // Метод 1
    private static double calculate(int a, int b, int c, int d) {
        return a * (b + (c * 1.0 / d));
    }

    // Метод 2
    private static boolean checkNumbers (int first, int second) {
        return (first + second) <= 20 && (first + second) >= 10;
    }

    // Метод 3
    private static boolean findPositiveNumber (int number) {return number >= 0;}

    // Метод 4
    private static String Greeting (String name) {
        return "Привет " + name + '!';
    }

    // Метод 5
    private static boolean leapYearCheck (int year) { return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0) ;}



    public static void main (String[] args) {

        int var1 = 4;
        int var2 = 5;
        int var3 = 6;
        int var4 = 7;
        int userYear = 2007;

        System.out.println("Calculation result is " + calculate(var1, var2, var3, var4));
        System.out.println("Does the sum of two numbers fit the range? " + checkNumbers(var1, var2));
        System.out.println("Number is " + (findPositiveNumber(var3) ? "positive" : "negative"));
        System.out.println(Greeting("Дима"));
        System.out.println("This is " + (leapYearCheck(userYear) ? "a leap" : "not a leap" + " year"));

    }
}
















