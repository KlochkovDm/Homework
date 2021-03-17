package ru.geekbrains.lessons.lesson3;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {


    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY= '.';

    private static char [][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int winLineSize =4;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static int scoreHuman = 0;
    private static int scoreAi = 0;

    public static void main(String[] args) {

        while (true) {
            initField();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, "HUMAN WINS!!!")) {
                    break;
                }
                aiTurn();
                printField();
                if (gameCheck(DOT_AI, "AI WINS!!!")) {
                    break;
                }
            }
            System.out.printf("SCORE IS: HUMAN AI\n            %d   %d\n", scoreHuman,scoreAi);
            System.out.println("Do you want to play again? >> Y or N");
            if (!SCANNER.next().toLowerCase().equals("y")) break;
        }
    }

    private static boolean gameCheck(char dot, String s) {
        if (checkWin(dot)) {
            if (dot == DOT_HUMAN) scoreHuman++;
            else scoreAi++;
            System.out.println(s);
            return true;
        }
        if (checkDraw()){
            System.out.println("DRAW!");
            return true;
        }
        return false;
    }



    private static boolean checkWin(char c) {
        int rowX=0;
        int rowY=0;
        int diagonalPositive=0;
        int diagonalNegative=0;
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                for (int i = 1; i < winLineSize; i++) {

                    if ((x + i < fieldSizeX) && (field[y][x] == c) && (field[y][x+i] == field[y][x])) {
                        rowX++;}
                    if ((y + i < fieldSizeY) && (field[y][x] == c && field[y + i][x] == field[y][x])) {
                        rowY++;}
                    if ((x+i< fieldSizeX && y+i < fieldSizeY) && (field[y][x] == c && field[y][x] == field[y+i][x+i])) {
                        diagonalPositive++;}
                    if ((x-i+1 >= 0 && y - i+1 >= 0 ) && (field[y][x] == c && field[y][x]== field[y-i+1][x-i+1])) {
                        diagonalNegative++;}
                }
                if (rowX >= winLineSize || rowY >= winLineSize || diagonalPositive >= winLineSize || diagonalNegative >= winLineSize) return true;
            }
        }return false;
    }

    private static int [] winOpportunity(char c) {
        int [] winTurn = new int[2];
        int [] noWinTurn = {-1,-1};
        int rowX=0;
        int rowY=0;
        int diagonalPositive=0;
        int diagonalNegative=0;
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                for (int i = 0; i < winLineSize; i++) {

                    if ((x + i < fieldSizeX) && (field[y][x] == c) && (field[y][x+i] == field[y][x])) {
                        rowX++;
                        if(rowX == winLineSize-1) {
                            if (isCellValid(x-1,y) && isCellEmpty(x-1,y)) {
                                winTurn[0] = y;
                                winTurn[1] = x-1;
                                return winTurn;
                                }
                            if (isCellValid(x+winLineSize-1,y) && isCellEmpty(x+winLineSize-1,y)){
                                winTurn[0] = y;
                                winTurn[1] = x+winLineSize-1;
                                return winTurn;
                                }
                        }
                    }

                    if ((y + i < fieldSizeY) && (field[y][x] == c && field[y + i][x] == field[y][x])) {
                        rowY++;
                        if(rowY == winLineSize-1) {
                            if (isCellValid(x,y-1) && isCellEmpty(x,y-1)){
                                winTurn[0] = y-1;
                                winTurn[1] = x;
                                return winTurn;
                                }
                            if (isCellValid(x,y+winLineSize-1) && isCellEmpty(x,y+winLineSize-1)){
                                winTurn[0] = y+winLineSize-1;
                                winTurn[1] = x;
                                return winTurn;
                                }
                        }
                    }

                    if ((x + i < fieldSizeX && y + i < fieldSizeY) && (field[y][x] == c && field[y + i][x + i] == field[y][x])) {
                        diagonalPositive++;
                        if(diagonalPositive == winLineSize-1) {
                            if (isCellValid(x-1,y-1) && isCellEmpty(x-1,y-1)){
                                winTurn[0] = y-1;
                                winTurn[1] = x-1;
                                return winTurn;
                                }
                            if (isCellValid(x+winLineSize-1,y+winLineSize-1) && isCellEmpty(x+winLineSize-1,y+winLineSize-1)){
                                winTurn[0] = y+winLineSize-1;
                                winTurn[1] = x+winLineSize-1;
                                return winTurn;
                                }
                        }
                    }

                    if ((x-i >= 0 && y - i >= 0 ) && (field[y][x] == c && field[y-i][x-i] == field[y][x])) {
                        diagonalNegative++;
                        if(diagonalNegative == winLineSize-1) {
                            if (isCellValid(x+1,y-1) && isCellEmpty(x+1,y-1)){
                                winTurn[0] = y-1;
                                winTurn[1] = x+1;
                                return winTurn;
                                }
                            if (isCellValid(x-winLineSize+1,y+winLineSize-1) && isCellEmpty(x-winLineSize+1,y+winLineSize-1)){
                                winTurn[0] = y+winLineSize-1;
                                winTurn[1] = x-winLineSize+1;
                                return winTurn;
                                }
                        }
                    }
                }
            }
        } return noWinTurn;
    }



   /*  Метод проверки для 4х символов

        private static boolean checkWin(char c) {

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if ((x+3<fieldSizeX) && (field[y][x] == c && field[y][x+1] == c && field[y][x + 2] == c && field[y][x + 3] == c)) return true;
                if ((y+3<fieldSizeY) && (field[y][x] == c && field[y+1][x] == c && field[y+2][x] == c && field[y+3][x] == c)) return true;
                if ((x+3<fieldSizeX && y+3<fieldSizeY) && (field[y][x] == c && field[y+1][x+1] == c && field[y + 2][x + 2] == c && field[y + 3][x + 3] == c)) return true;
                if ((x+3<fieldSizeX && y+3<fieldSizeY) && (field[y][x+3] == c && field[y+1][x+2] == c && field[y+2][x+1] == c && field[y+3][x] == c)) return true;
            }
        } return false;
    }


         hor
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        // ver
        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        // dia
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        return false;
*/
    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++){
                if (isCellEmpty(x,y)) return false;
            }
        }
        return true;
    }

    private static void aiTurn(){

        int x;
        int y;
        int winTurn [] = new int[2];
         winTurn= winOpportunity(DOT_AI);
        if(!(winTurn[0]==-1 || winTurn[1]==-1)) {
            y=winTurn[0];
            x=winTurn[1];
            field[y][x] = DOT_AI;}

        winTurn = winOpportunity(DOT_HUMAN);
        if(!(winTurn[0]==-1 || winTurn[1]==-1)) {
            y=winTurn[0];
            x=winTurn[1];
            field[y][x] = DOT_AI;}
        else {
            do {
                x =  RANDOM.nextInt(fieldSizeX);
                y = RANDOM.nextInt(fieldSizeY);
                } while (!isCellEmpty(x,y));
            field[y][x] = DOT_AI;}
    }






    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты X и Y через пробел >>>>>");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x,y) || !isCellEmpty(x,y));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isCellValid(int x, int y) {
        return x>=0 && y>=0 && x < fieldSizeX && y < fieldSizeY;
    }

    private static boolean isCellEmpty(int x, int y) {
         return field [y][x] == DOT_EMPTY;
    }


    private static void initField() {
        fieldSizeX = 5;
        fieldSizeY = 5;
        field = new char [fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField (){

        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++)
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        System.out.println();
        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
        for (int i = 0; i <= fieldSizeX * 2 + 1; i++)
            System.out.print("-");
        System.out.println();
    }

    static void printArr(char [][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

}
