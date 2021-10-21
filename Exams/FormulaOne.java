import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FormulaOne {
    private static int pRow = 0;
    private static int pCol = 0;
    private static boolean finished = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int com = Integer.parseInt(sc.nextLine());
        Character[][] matrix = readMatrix(sc, n);
        Character[][] tempMatrix = matrix;

        while(com-- > 0 && !finished){
            String dir = sc.nextLine();

            if(matrix[pRow][pCol] == 'P'){
                matrix[pRow][pCol] = '.';
            }

            if(dir.equals("up")){
                movePlayer(pRow - 1, pCol, matrix, "up");
            }else if(dir.equals("down")){
                movePlayer(pRow + 1, pCol, matrix, "down");
            }else if(dir.equals("left")){
                movePlayer(pRow, pCol - 1, matrix, "left");
            }else if(dir.equals("right")){
                movePlayer(pRow, pCol + 1, matrix, "right");
            }

            if(finished == true){
                break;
            }
        }

        if(finished){
            System.out.println("Well done, the player won first place!");
        }else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        if(tempMatrix[pRow][pCol] != 'F'){
            matrix[pRow][pCol] = 'P';
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void movePlayer(int row, int col, Character[][] matrix, String dir) {
        int[] mass = checkBoundaries(row, col, matrix);
        int newRow = mass[0];
        int newCol = mass[1];

        int tempR = pRow;
        int tempC = pCol;
        pRow = newRow;
        pCol = newCol;

        if(matrix[newRow][newCol] == 'B'){
            switch(dir){
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
            }
        }else if(matrix[newRow][newCol] == 'T'){
            pRow = tempR;
            pCol = tempC;
        }
        else if(matrix[newRow][newCol] == 'F'){
            matrix[newRow][newCol] = 'P';
            finished = true;
            pRow = newRow;
            pCol = newCol;
        }
    }

    private static int[] checkBoundaries(int row, int col, Character[][] matrix) {
        int[] mat = new int[2];
        if(row < 0 ){
            mat[0] = matrix.length - 1;
            mat[1] = col;
        }else if(row >= matrix.length){
            mat[0] = 0;
            mat[1] = col;
        }else if(col < 0 ){
            mat[0] = row;
            mat[1] = matrix.length - 1;
        }else if(col >= matrix.length) {
            mat[0] = row;
            mat[1] = 0;
        }else{
            mat[0] = row;
            mat[1] = col;
        }
        return mat;
    }

    private static Character[][] readMatrix(Scanner sc, int n) {
        Character[][] matrix = new Character[n][n];
        for (int i = 0; i < n; i++) {
            String comm = String.join("", sc.nextLine().split("\\s+"));
            for (int j = 0; j < n; j++) {
                matrix[i][j] = comm.charAt(j);
                if(comm.charAt(j) == 'P'){
                    pRow = i;
                    pCol = j;
                }
            }
        }
        return matrix;
    }
}
