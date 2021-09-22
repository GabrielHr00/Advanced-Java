import java.util.Scanner;

public class FillTheMatrix_01_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        int row = Integer.parseInt(command.split(", ")[0]);
        String pattern = command.split(", ")[1];

        int[][] matrix = new int[row][row];

        if(pattern.equals("A")){
            int number = 1;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < row; j++) {
                    matrix[j][i] = number++;
                }
            }
        }
        else if(pattern.equals("B")){
            int number = 1;
            for (int i = 0; i < row; i++) {
                if(i % 2 != 0){
                    for (int j = row-1; j >= 0; j--) {
                        matrix[j][i] = number++;
                    }
                }else{
                    for (int j = 0; j < row; j++) {
                        matrix[j][i] = number++;
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
