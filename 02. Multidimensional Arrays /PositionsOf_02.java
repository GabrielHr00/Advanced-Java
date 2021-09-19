import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = Arrays.stream(sc.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray()[0];

        int[][] matrix = readMatrix(row, sc, "\\s+");
        int number = Integer.parseInt(sc.nextLine());

        if(!checkForNumber(matrix, number)){
            System.out.println("not found");
        }
    }

    private static boolean checkForNumber(int[][] matrix, int number) {
        boolean found = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == number){
                    System.out.println(i + " " + j);
                    found = true;
                }
            }
        }
        return found;
    }

    private static int[][] readMatrix(int row, Scanner sc, String s) {
        int[][] matrix = new int[row][];
        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(sc.nextLine().split(s))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
