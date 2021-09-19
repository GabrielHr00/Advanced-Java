import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        String[][] first = readMatrix(rows, sc, "\\s+");
        String[][] second = readMatrix(rows, sc, "\\s+");

        String[][] newMatrix = checkForEqualities(first, second);
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] checkForEqualities(String[][] first, String[][] second) {
        String[][] matrix = first;

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[i].length; j++) {
                String fir = first[i][j];
                String sec = second[i][j];
                if(fir.equals(sec)){
                    matrix[i][j] = fir;
                }
                else{
                    matrix[i][j] = "*";
                }
            }
        }
        return matrix;
    }

    private static String[][] readMatrix(int rows, Scanner sc, String s) {
        String[][] matrix = new String[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = sc.nextLine().split(s);
        }
        return matrix;
    }
}
