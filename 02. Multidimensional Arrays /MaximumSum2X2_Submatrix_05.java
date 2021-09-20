import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum2X2_Submatrix_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray()[0];
        int[][] matrix = readMatrix(row, sc, ", ");

        int[][] newMatrix = findMaxMatrix(matrix);
        int sum = sumMatrix(newMatrix);
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(sum);
    }

    static int[][] findMaxMatrix(int[][] matrix) {
        int[][] newM = new int[2][2];
        int maxSum = 0;

        for (int i = 0; i < matrix.length-1; i++) {
            for (int j = 0; j < matrix[i].length-1; j++) {
                int top = matrix[i][j];
                int rightTop = matrix[i][j+1];
                int bottom = matrix[i+1][j];
                int rightBottom = matrix[i+1][j+1];
                int sum = top + rightBottom + rightTop + bottom;
                if(sum > maxSum){
                    maxSum = sum;
                    newM[0][0] = top;
                    newM[0][1] = rightTop;
                    newM[1][0] = bottom;
                    newM[1][1] = rightBottom;
                }
            }
        }
        return newM;
    }

    private static int sumMatrix(int[][] matrix) {
        int sum = 0;
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }

    private static int[][] readMatrix(int row, Scanner sc, String s) {
        int[][] matrix = new int[row][];

        for(int i = 0; i < matrix.length; ++i) {
            matrix[i] = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}
