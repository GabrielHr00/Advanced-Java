import java.util.*;
import java.util.stream.Collectors;

public class Python {
    static int pLength = 1;
    static int pRow;
    static int pCol;
    static int food;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<String> comms = Arrays.stream(sc.nextLine().split(",\\s+")).collect(Collectors.toList());
        Character[][] matrix = new Character[n][n];

        readMatrix(sc, n, matrix);

        for (int i = 0; i < comms.size(); i++) {
            String com = comms.get(i);
            if(com.equals("up")){
                movePlayer(matrix, pRow - 1, pCol);
            } else if(com.equals("right")){
                movePlayer(matrix, pRow, pCol + 1);
            } else if(com.equals("down")){
                movePlayer(matrix, pRow + 1, pCol);
            } else if(com.equals("left")){
                movePlayer(matrix, pRow, pCol - 1);
            }

            if(pLength == -1 || food == 0){
                break;
            }
        }


        if(food == 0){
            System.out.println("You win! Final python length is " + pLength);
        }
        else if(pLength == -1){
            System.out.println("You lose! Killed by an enemy!");
        }
        else{
            System.out.println("You lose! There is still " + food + " food to be eaten.");
        }
    }

    private static void movePlayer(Character[][] matrix, int row, int col) {
        int newRow = row;
        int newCol = col;

        if(isOutOfBound(matrix, newRow, newCol)){
            int[] temp = takeNewParameters(matrix, newRow, newCol);
            newRow = temp[0];
            newCol = temp[1];
        }

        if(matrix[newRow][newCol] == 'e'){
            pLength = -1;
            return;
        }else if(matrix[newRow][newCol] == 'f'){
            food -= 1;
            pLength += 1;
        }
        matrix[pRow][pCol] = '*';
        matrix[newRow][newCol] = 's';
        pRow = newRow;
        pCol = newCol;
    }

    private static int[] takeNewParameters(Character[][] matrix, int newRow, int newCol) {
        int[] newParams = new int[2];
        if(newRow >= matrix.length){
            newParams[0] = 0;
            newParams[1] = newCol;
        }else if(newRow < 0){
            newParams[0] = matrix.length - 1;
            newParams[1] = newCol;
        }else if(newCol >= matrix.length){
            newParams[0] = newRow;
            newParams[1] = 0;
        }else if(newCol < 0){
            newParams[0] = newRow;
            newParams[1] = matrix.length - 1;
        }
        return newParams;
    }

    private static boolean isOutOfBound(Character[][] matrix, int newRow, int newCol) {
        return newRow >= matrix.length || newRow < 0 || newCol < 0 || newCol >= matrix.length;
    }

    private static void readMatrix(Scanner sc, int n, Character[][] matrix) {
        for (int i = 0; i < n; i++) {
            String s = String.join("", sc.nextLine().split("\\s+"));
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = s.charAt(j);
                if(s.charAt(j) == 's'){
                    pRow = i;
                    pCol = j;
                }
                else if(s.charAt(j) == 'f'){
                    food += 1;
                }
            }
        }
    }
}
