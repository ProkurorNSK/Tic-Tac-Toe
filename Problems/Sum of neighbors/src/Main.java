import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if ("end".equals(line)) {
                break;
            } else {
                stringBuilder.append(line).append("\n");
            }
        }

        String[] lines = stringBuilder.toString().split("\n");

        int sizeRow = lines.length;
        int sizeCol = lines[0].split(" ").length;
        int[][] matrix = new int[sizeRow][sizeCol];

        for (int i = 0; i < sizeRow; i++) {
            String[] values = lines[i].split(" ");
            for (int j = 0; j < sizeCol; j++) {
                matrix[i][j] = Integer.parseInt(values[j]);
            }
        }

        int[][] result = new int[sizeRow][sizeCol];
        for (int i = 0; i < sizeRow; i++) {
            for (int j = 0; j < sizeCol; j++) {
                result[i][j] = matrix[(i - 1 + sizeRow) % sizeRow][j] +
                        matrix[(i + 1 + sizeRow) % sizeRow][j] +
                        matrix[i][(j - 1 + sizeCol) % sizeCol] +
                        matrix[i][(j + 1 + sizeCol) % sizeCol];
            }
        }

        for (int[] ints : result) {
            for (int j = 0; j < sizeCol; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
