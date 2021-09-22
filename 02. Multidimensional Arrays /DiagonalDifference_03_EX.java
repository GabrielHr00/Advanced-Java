import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int sumDiagonalOne = extractDiagonalOne(matrix);
        int sumDiagonalTwo = extractDiagonalTwo(matrix);

        System.out.println(Math.abs(sumDiagonalOne - sumDiagonalTwo));

    }

    private static int extractDiagonalTwo(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int extractDiagonalOne(int[][] matrix) {
        int sum = 0;
        int counter = matrix.length - 1;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[counter--][i];
        }
        return sum;
    }
}
