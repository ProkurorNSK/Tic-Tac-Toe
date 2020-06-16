import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] sequence = new int[size];
        for (int i = 0; i < size; i++) {
            sequence[i] = scanner.nextInt();
        }
        int result = 1;
        int temp = 1;
        for (int i = 1; i < size; i++) {
            if (sequence[i] > sequence[i - 1] && i != size - 1) {
                temp++;
            } else if (sequence[i] > sequence[i - 1] && i == size - 1) {
                temp++;
                if (temp > result) {
                    result = temp;
                }
            } else {
                if (temp > result) {
                    result = temp;
                }
                temp = 1;
            }
        }
        System.out.println(result);
    }
}