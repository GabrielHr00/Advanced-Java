import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        String current = null;
        while(!input.equals("Home")){
            if(input.equals("back")){
                if(stack.size() >= 2){
                    forward.addFirst(stack.peek());
                    stack.pop();
                    System.out.println(stack.peek());
                }else{
                    System.out.println("no previous URLs");
                }
            }
            else if(input.equals("forward")){
                if(forward.size() >= 1){
                    System.out.println(forward.peek());
                    stack.push(forward.pop());
                }else{
                    System.out.println("no next URLs");
                }
            }
            else{
                System.out.println(input);
                stack.push(input);
                forward.clear();
            }
            input = sc.nextLine();
        }
    }
}
