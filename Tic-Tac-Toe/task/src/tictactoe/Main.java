package tictactoe;

import java.util.Scanner;

public class Main {
    private static final int SIZE = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] field = new char[SIZE][SIZE];
        int countX = 0;
        int countO = 0;
        char player = 'X';
        int x;
        int y;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = ' ';
            }
        }
        print(field);

        while (true) {
            System.out.print("Enter the coordinates: ");

            try {
                String xs = scanner.next();
                String ys = scanner.next();
                x = Integer.parseInt(xs);
                y = Integer.parseInt(ys);
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (x < 1 || x > SIZE || y < 1 || y > SIZE) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            char value = field[SIZE - y][x - 1];
            if (value == 'X' || value == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            field[SIZE - y][x - 1] = player;
            if (player == 'X') {
                countX++;
            } else {
                countO++;
            }

            print(field);
            if (Math.abs(countX - countO) > 1 || (checkWin(field, 'X') && checkWin(field, 'O'))) {
                System.out.println("Impossible");
            } else if (checkWin(field, 'X')) {
                System.out.println("X wins");
                break;
            } else if (checkWin(field, 'O')) {
                System.out.println("O wins");
                break;
            } else if (countX + countO == SIZE * SIZE) {
                System.out.println("Draw");
                break;
            }

            player = (player == 'X') ? 'O' : 'X';
        }
    }

    private static void print(char[][] field) {
        System.out.println("---------");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }

    private static boolean checkWin(char[][] field, char player) {

        for (int i = 0; i < SIZE; i++) {
            boolean equals = true;
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] != player) {
                    equals = false;
                    break;
                }
            }
            if (equals) {
                return true;
            }

            equals = true;
            for (int j = 0; j < SIZE; j++) {
                if (field[j][i] != player) {
                    equals = false;
                    break;
                }
            }
            if (equals) {
                return true;
            }
        }

        boolean equals = true;
        for (int i = 0; i < SIZE; i++) {
            if (field[i][i] != player) {
                equals = false;
                break;
            }
        }
        if (equals) {
            return true;
        }

        equals = true;
        for (int i = 0; i < SIZE; i++) {
            if (field[i][SIZE - 1 - i] != player) {
                equals = false;
                break;
            }
        }
        return equals;
    }
}
