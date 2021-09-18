import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParenthessis_05_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        boolean balanced = false;

        for(int i = 0; i < input.length(); i++){
            String current = String.valueOf(input.charAt(i));

            if(current.equals("(")  || current.equals("{")  || current.equals("[")){
                stack.push(current);
            }
            else if(current.equals(")") || current.equals("}") || current.equals("]")) {
                if(stack.isEmpty()){
                    balanced = false;
                    break;
                }
                String last = stack.pop();
                if(last.equals("(") && current.equals(")")){
                    balanced = true;
                }else if(last.equals("{") && current.equals("}")){
                    balanced = true;
                }else if(last.equals("[") && current.equals("]")){
                    balanced = true;
                }else{
                    balanced = false;
                    break;
                }
            }
        }

        if(balanced){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
