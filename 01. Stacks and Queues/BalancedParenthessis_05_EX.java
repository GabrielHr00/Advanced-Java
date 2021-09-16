import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParenthessis_05_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();

        for(int i = 0; i < input.length()/2; i++){
            stack.push(input.charAt(i));
        }

        int k = input.length()/2;
        for(int i = 0; i < input.length()/2; i++){
            queue.offer(input.charAt(k));
            k++;
        }
        boolean not = false;

        while(!stack.isEmpty() && !queue.isEmpty()){
            String st = stack.pop().toString();
            String qu = queue.poll().toString();
            if((st.equals("(") && qu.equals(")"))|| (st.equals("{") && qu.equals("}")) || (st.equals("[") && qu.equals("]"))){
                not = true;
            }else{
                System.out.println("NO");
                return;
            }
        }

        if(not == true && stack.isEmpty() && queue.isEmpty()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
