import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire_07_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] com = sc.nextLine().split("\\s+");
        int row = Integer.parseInt(com[0]);
        int col = Integer.parseInt(com[1]);

        List<List<Integer>> matrix = fillMatrix(row, col);

        String comm = sc.nextLine();
        while(!comm.equals("Nuke it from orbit")){
            String[] tokens = comm.split("\\s+");
            int row1 = Integer.parseInt(tokens[0]);
            int col1 = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            // top to bottom
            for (int i = col1 + radius; i >= col1 - radius; i--) {
                if(isInRange(matrix, i, row1)){
                    matrix.get(row1).remove(i);
                }
            }
            // left to right
            for (int i = row1 - radius; i <= row1 + radius; i++) {
                if(isInRange(matrix, col1, i) && i != row1){
                    matrix.get(i).remove(col1);
                }
            }
            matrix.removeIf(List::isEmpty);
            comm = sc.nextLine();
        }
        printMatrix(matrix);
    }

    private static boolean isInRange(List<List<Integer>> matrix, int col, int row) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static List<List<Integer>> fillMatrix(int row, int col) {
        List<List<Integer>> list = new ArrayList<>();
        int help = 1;
        for (int i = 0; i < row; i++) {
            list.add(new ArrayList<>());
            for (int j = 0; j < col; j++) {
                list.get(i).add(help++);
            }
        }
        return list;
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (var list : matrix) {
            for (var n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
