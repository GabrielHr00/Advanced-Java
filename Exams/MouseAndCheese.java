import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class MouseAndCheese {
    static int cheese = 0;
    static int pRow = 0;
    static int pCol = 0;
    static boolean out = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Character[][] matrix = readMatrix(sc, n);

        String com = sc.nextLine();
        while(!out && !com.equals("end")){
            switch(com){
                case "up":
                    movePlayer(pRow - 1, pCol, matrix, "up");
                    break;
                case "down":
                    movePlayer(pRow + 1, pCol, matrix, "down");
                    break;
                case "left":
                    movePlayer(pRow, pCol - 1, matrix, "left");
                    break;
                case "right":
                    movePlayer(pRow, pCol + 1, matrix, "right");
                    break;
                case "end":
                    break;
            }

            if(out){
                break;
            }
            com = sc.nextLine();
        }

        if(out){
            System.out.println("Where is the mouse?");
        }

        if(cheese >= 5){
            System.out.println("Great job, the mouse is fed " + cheese + " cheeses!");
        }
        else{
            System.out.println("The mouse couldn't eat the cheeses, she needed " + (5 - cheese) + " cheeses more.");
        }

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

    private static void movePlayer(int newRow, int newCol, Character[][] matrix, String dir) {
        if(checkBoundaries(newRow, newCol, matrix.length)){
            matrix[pRow][pCol] = '-';
            out = true;
            return;
        }

        if(matrix[newRow][newCol] == 'c'){
            cheese += 1;
            matrix[pRow][pCol] = '-';
            matrix[newRow][newCol] = 'M';
            pRow = newRow;
            pCol = newCol;
        }
        else if(matrix[newRow][newCol] == 'B'){
            matrix[pRow][pCol] = '-';
            matrix[newRow][newCol] = '-';
            pRow = newRow;
            pCol = newCol;
            if(dir.equals("up")){
                movePlayer(newRow - 1, newCol, matrix, "up");
            }else if(dir.equals("down")) {
                movePlayer(newRow + 1, newCol, matrix, "down");
            } else if(dir.equals("left")){
                movePlayer(newRow, newCol - 1, matrix, "left");
            } else if(dir.equals("right")){
                movePlayer(newRow, newCol + 1, matrix, "right");
            }
        }
        else{
            matrix[pRow][pCol] = '-';
            matrix[newRow][newCol] = 'M';
            pRow = newRow;
            pCol = newCol;
        }
    }

    private static boolean checkBoundaries(int row, int col, int n) {
        return row < 0 || row >= n || col < 0 || col >= n;
    }

    private static Character[][] readMatrix(Scanner sc, int n) {
        Character[][] matrix = new Character[n][n];

        for (int i = 0; i < n; i++) {
            String s = String.join("", sc.nextLine().split("\\s+"));
            for (int j = 0; j < s.length(); j++) {
                matrix[i][j] = s.charAt(j);
                if(s.charAt(j) == 'M'){
                    pRow = i;
                    pCol = j;
                }
            }
        }
        return matrix;
    }
}
