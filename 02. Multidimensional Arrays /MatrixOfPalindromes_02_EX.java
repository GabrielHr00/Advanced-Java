import java.util.Scanner;

public class MatrixOfPalindromes_02_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String comm = sc.nextLine();
        int row = Integer.parseInt(comm.split("\\s+")[0]);
        int cols = Integer.parseInt(comm.split("\\s+")[1]);

        String[][] matrix = new String[row][cols];

        refactorMatrix(matrix);
        printMatrix(row, cols, matrix);
    }

    private static void refactorMatrix(String[][] matrix) {
        int char1;
        int charMid;
        int charBack;
        for (int i = 0; i < matrix.length; i++) {
            char1 = 97 + i;
            charMid = 97 + i;
            charBack = 97 + i;
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ("" + (char)char1) + ((char)charMid++) + ((char)charBack) + "";
            }
        }
    }

    private static void printMatrix(int row, int cols, String[][] matrix) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}
