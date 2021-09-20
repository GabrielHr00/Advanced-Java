import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = Integer.parseInt(sc.nextLine());
        int[][] matrix = readMatrix(row, sc, "\\s+");

        int[][] newMatrix = getDiagonals(matrix);
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getDiagonals(int[][] matrix) {
        int[][] mat = new int[2][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            mat[0][i] = matrix[i][i];
        }

        int size = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            mat[1][i] = matrix[size--][i];
        }
        return mat;
    }

    private static int[][] readMatrix(int row, Scanner sc, String s) {
        int[][] matrix = new int[row][];

        for(int i = 0; i < matrix.length; ++i) {
            matrix[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}
