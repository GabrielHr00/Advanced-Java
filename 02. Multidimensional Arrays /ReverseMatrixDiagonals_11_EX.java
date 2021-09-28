import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseMatrixDiagonals_11_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(sc.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int row = rows - 1;
        int col = cols - 1;

        while(row != -1){
            int rowHelp = row;
            int colHelp = col;

            while(rowHelp >= 0 && colHelp < cols){
                System.out.print(matrix[rowHelp--][colHelp++] + " ");
            }
            System.out.println();
            col--;
            if(col == -1){
                col = 0;
                row--;
            }
        }
    }
}
