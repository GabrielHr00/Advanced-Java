import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String in = sc.nextLine();

        for(int i = 0; i < in.length(); i++){
            if(in.charAt(i) == '('){
                stack.push(i);
            }
            else if(in.charAt(i) == ')'){
                String toPrint = in.substring(stack.pop(), i + 1);
                System.out.println(toPrint);
            }
        }

    }
}
