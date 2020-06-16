import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] field = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                field[i][j] = ".";
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == n / 2) {
                Arrays.fill(field[i], "*");
            } else {
                field[i][i] = "*";
                field[i][n / 2] = "*";
                field[i][n - 1 - i] = "*";
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
}
