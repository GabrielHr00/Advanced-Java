import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class SimpleCalculator_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] data = sc.nextLine().split("\\s+");

        Deque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, data);

        while(stack.size() > 1){
            int left = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int right = Integer.parseInt(stack.pop());

            if(op.equals("+")){
                stack.push(String.valueOf(left + right));
            }else{
                stack.push(String.valueOf(left - right));
            }
        }
        System.out.println(stack.pop());
    }
}
