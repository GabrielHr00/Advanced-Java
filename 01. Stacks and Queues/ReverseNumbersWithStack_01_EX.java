import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack_01_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for(var j : data){
            stack.push(j);
        }

        stack.stream().forEach(e -> System.out.print(e + " "));
    }
}
