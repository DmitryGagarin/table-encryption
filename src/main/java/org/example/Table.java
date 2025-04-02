package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        String key = scanner.nextLine();
        int columns = (int) Math.ceil((double) message.length() / key.length());
        System.out.println(table(message, key, columns));
        System.out.println(tableBack(table(message, key, columns), key, columns));
    }

    public static String table(String message, String key, int columns) {
        int rows = key.length();
        char[][] table = new char[columns][rows];

        int index = 0;
        for (int row = 0; row < columns; row++) {
            for (int col = 0; col < rows; col++) {
                if (index < message.length()) {
                    table[row][col] = message.charAt(index++);
                } else {
                    table[row][col] = ' ';
                }
            }
        }

        char[][] sortedTable = sortTableRowsByKey(table, key);

        StringBuilder res = new StringBuilder();
        for (int column = 0; column < rows; column++) {
            for (int row = 0; row < columns; row++) {
                res.append(sortedTable[row][column]);
            }
        }

        return res.toString();
    }

    private static char[][] sortTableRowsByKey(char[][] table, String key) {
        int rows = key.length();
        int columns = table.length;

        Integer[] order = new Integer[rows];
        for (int i = 0; i < rows; i++) {
            order[i] = i;
        }

        Arrays.sort(order, Comparator.comparingInt(key::charAt));

        char[][] sortedTable = new char[columns][rows];
        for (int i = 0; i < rows; i++) {
            int rowIndex = order[i];
            for (int j = 0; j < columns; j++) {
                sortedTable[j][i] = table[j][rowIndex];
            }
        }

        return sortedTable;
    }

    public static String tableBack(String message, String key, int columns) {
        int rows = key.length();
        char[][] table = new char[columns][rows];
        int index = 0;

        for (int col = 0; col < rows; col++) {
            for (int row = 0; row < columns; row++) {
                if (index < message.length()) {
                    table[row][col] = message.charAt(index++);
                } else {
                    table[row][col] = ' ';
                }
            }
        }

        char[][] sortedTable = restoreOriginalRowOrder(table, key);

        StringBuilder res = new StringBuilder();
        for (int row = 0; row < columns; row++) {
            for (int col = 0; col < rows; col++) {
                res.append(sortedTable[row][col]);
            }
        }

        return res.toString().trim();
    }

    private static char[][] restoreOriginalRowOrder(char[][] table, String key) {
        int rows = key.length();
        int columns = table.length;

        Integer[] order = new Integer[rows];
        for (int i = 0; i < rows; i++) {
            order[i] = i;
        }

        Arrays.sort(order, Comparator.comparingInt(key::charAt));

        char[][] originalTable = new char[columns][rows];
        for (int i = 0; i < rows; i++) {
            int rowIndex = order[i];
            for (int j = 0; j < columns; j++) {
                originalTable[j][i] = table[j][rowIndex];
            }
        }

        return originalTable;
    }
}