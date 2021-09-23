import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation_06_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int degree = Integer.parseInt(sc.nextLine().split("[()]+")[1])%360;
        List<String> temp = new ArrayList<>();

        //find the biggest word in the list;
        String com = sc.nextLine();
        int maxColLength = 0;
        while(!com.equals("END")){
            temp.add(com);
            if(com.length() > maxColLength){
                maxColLength = com.length();
            }
            com = sc.nextLine();
        }

        char[][] matrix = new char[temp.size()][maxColLength];
        for (int i = 0; i < temp.size(); i++) {
            String help = temp.get(i);
            for (int j = 0; j < maxColLength; j++) {
                if(j >= help.length() && help.length() < maxColLength){
                    matrix[i][j] = ' ';
                }
                else{
                    char charOnString = help.charAt(j);
                    matrix[i][j] = charOnString;
                }
            }
        }

        rotateMatrix(degree, matrix, maxColLength);
    }

    private static void rotateMatrix(int degree, char[][] matrix, int col) {
        if(degree == 0){
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }
        else if(degree == 90){
            for (int i = 0; i < col; i++) {
                for (int j = matrix.length - 1; j >= 0; j--) {
                    System.out.print(matrix[j][i]);
                }
                System.out.println();
            }
        }
        else if(degree == 180){
            for (int i = matrix.length - 1; i >= 0; i--) {
                for (int j = col - 1; j >= 0; j--) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }
        else if(degree == 270){
            for (int i = col - 1; i >= 0; i--) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.print(matrix[j][i]);
                }
                System.out.println();
            }
        }
    }
}
