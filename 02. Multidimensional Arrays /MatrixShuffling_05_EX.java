import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling_05_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");
        int row = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[row][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = sc.nextLine().split("\\s+");
        }

        String com = sc.nextLine();
        while(!com.equals("END")){
            String[] comm = com.split("\\s+");
            if(!validate(comm, row, cols)){
                System.out.println("Invalid input!");
            }
            else{
                int row1 = Integer.parseInt(comm[1]);
                int col1 = Integer.parseInt(comm[2]);
                int row2 = Integer.parseInt(comm[3]);
                int col2 = Integer.parseInt(comm[4]);

                String mat1 = matrix[row1][col1];
                String mat2 = matrix[row2][col2];
                matrix[row1][col1] = mat2;
                matrix[row2][col2] = mat1;

                printMatrix(matrix);
            }
            com = sc.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean validate(String[] comm, int row, int cols) {
        if(!comm[0].equals("swap")) {
            return false;
        }
        if(comm.length != 5){
            return false;
        }

        int row1 = Integer.parseInt(comm[1]);
        int col1 = Integer.parseInt(comm[2]);
        int row2 = Integer.parseInt(comm[3]);
        int col2 = Integer.parseInt(comm[4]);

        if(row1 < 0 || row1 >= row
                || col1 < 0 || col1 >= cols
                || row2 < 0 || row2 >= row
                || col2 < 0 || col2 >= cols){
            return false;
        }
        return true;
    }
}
