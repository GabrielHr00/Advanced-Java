import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_04_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] coms = sc.nextLine().split("\\s+");
        int row = Integer.parseInt(coms[0]);

        // read the matrix
        int[][] matrix = new int[row][];
        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] maxMatrix = findMaxMatrix(matrix);
        int sum = findMaxSum(maxMatrix);

        System.out.println("Sum = " + sum);
        for (int i = 0; i < maxMatrix.length; i++) {
            for (int j = 0; j < maxMatrix[i].length; j++) {
                System.out.print(maxMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int findMaxSum(int[][] maxMatrix) {
        int sum = 0;
        for (int i = 0; i < maxMatrix.length; i++) {
            for (int j = 0; j < maxMatrix[i].length; j++) {
                sum += maxMatrix[i][j];
            }
        }
        return sum;
    }

    private static int[][] findMaxMatrix(int[][] matrix) {
        int[][] mat = new int[3][3];
        int sum = 0;

        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                int summy = 0;
                summy += matrix[i][j];
                summy += matrix[i][j+1];
                summy += matrix[i][j+2];

                summy += matrix[i+1][j];
                summy += matrix[i+1][j+1];
                summy += matrix[i+1][j+2];

                summy += matrix[i+2][j];
                summy += matrix[i+2][j+1];
                summy += matrix[i+2][j+2];

                if(summy > sum){
                    mat[0][0] = matrix[i][j];
                    mat[0][1] = matrix[i][j+1];
                    mat[0][2] = matrix[i][j+2];

                    mat[1][0] = matrix[i+1][j];
                    mat[1][1] = matrix[i+1][j+1];
                    mat[1][2] = matrix[i+1][j+2];

                    mat[2][0] = matrix[i+2][j];
                    mat[2][1] = matrix[i+2][j+1];
                    mat[2][2] = matrix[i+2][j+2];
                    sum = summy;
                }
            }
        }
        return mat;
    }
}
