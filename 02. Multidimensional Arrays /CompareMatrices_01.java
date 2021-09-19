import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row1 = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray()[0];
        int[][] firstMatrix = readMatrix(row1, sc, "\\s+");

        int row2 = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray()[0];
        int[][] secondMatrix = readMatrix(row2, sc, "\\s+");

        boolean isEqual = checkForEquality(firstMatrix, secondMatrix);
        System.out.println(isEqual ? "equal" : "not equal");
    }

    private static boolean checkForEquality(int[][] firstMatrix, int[][] secondMatrix) {
        if(firstMatrix.length != secondMatrix.length){
            return false;
        }
        for (int i = 0; i < firstMatrix.length; i++) {
            if(firstMatrix[i].length != secondMatrix[i].length){
                return false;
            }
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if(firstMatrix[i][j] != secondMatrix[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] readMatrix(int row, Scanner sc, String separator) {
        int[][] matrix = new int[row][];

        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(sc.nextLine()
                    .split(separator))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
