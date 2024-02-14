package org.example;

import java.util.Scanner;
import java.util.Stack;

/**
 * Name: Jianfeng Han
 * Class Group: SD2A
 */
public class CA3_Question2 {
    /*
        Starter function to create the 2D array and populate it with 0

     */
    static class Pair {
        int row;
        int column;

        public Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }

    public static int[][] floodFillStart() {
        Scanner kb = new Scanner(System.in);
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                arr[x][y] = 0;
            }
        }
        return arr;
    }

    /*
        Helper function to display the image
     */
    public static void display(int[][] arr) {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }

    public static void buildWalls(int[][] arr) {

        arr[8][0] = -1;
        arr[8][1] = -1;
        arr[8][2] = -1;
        arr[8][3] = -1;
        arr[8][4] = -1;
        arr[8][5] = -1;
        arr[8][6] = -1;
        arr[8][7] = -1;
        arr[9][3] = -1;


    }

    private static void fill(int r, int c, int[][] arr) {
        Stack<Pair> Stack = new Stack<>();
        Stack.push(new Pair(r, c));

        int fillNumber = 1;
        while (!Stack.isEmpty()) {
            Pair pixel = Stack.pop();
            int row = pixel.getRow();
            int col = pixel.getColumn();
            if (row >= 0 && row < 10 && col >= 0 && col < 10 && arr[row][col] == 0) {

                arr[row][col] = fillNumber;
                fillNumber++;

                Stack.push(new Pair(row - 1, col)); //north
                Stack.push(new Pair(row, col + 1)); //east
                Stack.push(new Pair(row + 1, col)); //south
                Stack.push(new Pair(row, col - 1)); //west
            }
//            arr[row][col] = fillNumber;
//            fillNumber++;
//            if (row > 0) {
//                if (arr[row - 1][col] == 0) {
//                    Stack.push(new Pair(row - 1, col)); //north
//                }
//            }
//            if (row < 9) {
//                if (arr[row + 1][col] == 0) {
//                    Stack.push(new Pair(row + 1, col)); //south
//                }
//            }
//            if (col > 0) {
//                if (arr[row][col - 1] == 0) {
//                    Stack.push(new Pair(row, col - 1)); //west
//                }
//            }
//            if (col < 9) {
//                if (arr[row][col + 1] == 0) {
//                    Stack.push(new Pair(row, col + 1)); //east
//                }
//            }
        }
        display(arr);

    }

    public static void start() {
        int[][] arr = floodFillStart();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting row and column (0-9) separated by a space:");
        System.out.print("Enter the starting row: ");
        int r = sc.nextInt();
        System.out.print("Enter the starting column: ");
        int c = sc.nextInt();
        buildWalls(arr);
        fill(r, c, arr);
    }

    public static void main(String[] args) {
        start();
    }

}

