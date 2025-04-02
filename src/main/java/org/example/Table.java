package org.example;

import java.util.Scanner;

public class Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        int key = scanner.nextInt();
        int columns = (int) Math.ceil((double) message.length() / key);
        System.out.println(table(message, key, columns));
        System.out.println(tableBack(table(message, key, columns), key, columns));
    }

    public static String table(String message, int key, int columns) {
        char[][] table = new char[columns][key];

        int index = 0;
        for (int row = 0; row < columns; row++) {
            for (int col = 0; col < key; col++) {
                if (index < message.length()) {
                    table[row][col] = message.charAt(index++);
                } else {
                    table[row][col] = ' ';
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (int column = 0; column < key; column++) {
            for (int row = 0; row < columns; row++) {
                res.append(table[row][column]);
            }
        }

        return res.toString();
    }

    public static String tableBack(String message, int key, int columns) {
        char[][] table = new char[columns][key];
        int index = 0;

        for (int col = 0; col < key; col++) {
            for (int row = 0; row < columns; row++) {
                if (index < message.length()) {
                    table[row][col] = message.charAt(index++);
                } else {
                    table[row][col] = ' ';
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (int row = 0; row < columns; row++) {
            for (int col = 0; col < key; col++) {
                res.append(table[row][col]);
            }
        }

        return res.toString().trim();
    }
}