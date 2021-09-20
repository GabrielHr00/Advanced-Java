import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = Integer.parseInt(sc.nextLine());
        int[][] matrix = readMatrix(row, sc, "\\s+");

        int[] wrongValues = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int value = matrix[wrongValues[0]][wrongValues[1]];
        int[][] replacedMatrix = replaceFalseValues(matrix, value);

        for (int i = 0; i < replacedMatrix.length; i++) {
            for (int j = 0; j < replacedMatrix[i].length; j++) {
                System.out.print(replacedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] replaceFalseValues(int[][] matrix, int value) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == value) {
                    newMatrix[i][j] = getValue(matrix, i, j);
                }else{
                    newMatrix[i][j] = matrix[i][j];
                }
            }
        }
        return newMatrix;
    }
    private static int getValue(int[][] matrix, int row, int col) {
        int sum = 0;
        int wrongsValue = matrix[row][col];

        if (isInBounds(matrix, row - 1, col) && wrongsValue != matrix[row - 1][col]) {
            sum += matrix[row - 1][col];
        }
        if (isInBounds(matrix, row + 1, col) && wrongsValue != matrix[row + 1][col]) {
            sum += matrix[row + 1][col];
        }
        if (isInBounds(matrix, row, col - 1) && wrongsValue != matrix[row][col - 1]) {
            sum += matrix[row][col - 1];
        }
        if (isInBounds(matrix, row, col + 1) && wrongsValue != matrix[row][col + 1]) {
            sum += matrix[row][col + 1];
        }
        return sum;
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }


    private static int[][] readMatrix(int row, Scanner sc, String s) {
        int[][] matrix = new int[row][];

        for(int i = 0; i < matrix.length; ++i) {
            matrix[i] = Arrays.stream(sc.nextLine().split(s)).mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}
