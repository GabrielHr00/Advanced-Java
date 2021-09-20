import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray()[0];
        int[][] matrix = readMatrix(row, sc, ", ");

        int sum = sumMatrix(matrix);
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);

    }

    private static int sumMatrix(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }

    private static int[][] readMatrix(int row, Scanner sc, String s) {
        int[][] matrix = new int[row][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
