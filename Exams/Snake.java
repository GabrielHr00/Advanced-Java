import javax.xml.parsers.SAXParser;
import java.util.Scanner;

public class Snake {
    static int pRow = 0;
    static int pCol = 0;
    static int food = 0;
    static boolean out = false;
    static int borrows = 0;
    static int[] firstBorrow = new int[2];
    static int[] secondBorrow = new int[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Character[][] matrix = readMatrix(sc, n);

        while(true){
            String com = sc.nextLine();

            switch(com){
                case "up":
                    movePlayer(matrix, pRow - 1, pCol);
                    break;
                case "down":
                    movePlayer(matrix, pRow + 1, pCol);
                    break;
                case "left":
                    movePlayer(matrix, pRow, pCol - 1);
                    break;
                case "right":
                    movePlayer(matrix, pRow, pCol + 1);
                    break;
            }
            if(food >= 10 || out){
                break;
            }
        }

        if(out){
            System.out.println("Game over!");
        } else if(food >= 10){
            System.out.println("You won! You fed the snake.");
        }

        System.out.println("Food eaten: " + food);

        printMatrix(n, matrix);
    }

    private static void printMatrix(int n, Character[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "");
            }
            System.out.println();
        }
    }

    private static void movePlayer(Character[][] matrix, int newRow, int newCol) {
        if(checkOutOfBound(newRow, newCol, matrix)){
            matrix[pRow][pCol] = '.';
            out = true;
            return;
        }

        if(matrix[newRow][newCol] == '*'){
            food++;
            matrix[pRow][pCol] = '.';
            matrix[newRow][newCol] = 'S';
            pRow = newRow;
            pCol = newCol;
        }
        else if(matrix[newRow][newCol] == 'B'){
            matrix[pRow][pCol] = '.';
            matrix[newRow][newCol] = '.';
            if(newRow == firstBorrow[0] && newCol == firstBorrow[1]){
                pRow = secondBorrow[0];
                pCol = secondBorrow[1];
                matrix[pRow][pCol] = 'S';
            }else{
                pRow = firstBorrow[0];
                pCol = firstBorrow[1];
                matrix[pRow][pCol] = 'S';
            }
        }else{
            matrix[pRow][pCol] = '.';
            matrix[newRow][newCol] = 'S';
            pRow = newRow;
            pCol = newCol;
        }
    }

    private static boolean checkOutOfBound(int row, int col, Character[][] matrix) {
        return row >= matrix.length || row < 0 || col >= matrix.length || col < 0;
    }

    private static Character[][] readMatrix(Scanner sc, int n) {
        Character[][] matrix = new Character[n][n];
        for (int i = 0; i < n; i++) {
            String com = String.join("", sc.nextLine().split("\\s+"));
            for (int j = 0; j < com.length(); j++) {
                matrix[i][j] = com.charAt(j);
                if(com.charAt(j) == 'S'){
                    pRow = i;
                    pCol = j;
                }
                else if(com.charAt(j) == 'B' && borrows == 0){
                    firstBorrow[0] = i;
                    firstBorrow[1] = j;
                    borrows = 2;
                }
                else if(com.charAt(j) == 'B' && borrows == 2){
                    secondBorrow[0] = i;
                    secondBorrow[1] = j;
                }
            }
        }
        return matrix;
    }
}
