import java.util.*;

public class MagicBox {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int value = 0;

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(e -> queue.offer(e));
        Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(e -> stack.push(e));

        while(!stack.isEmpty() && !queue.isEmpty()){
            int first = queue.peek();
            int second = stack.peek();

            int sum = first + second;
            if(sum % 2 == 0){
                value += sum;
                queue.poll();
                stack.pop();
            }
            else{
                int sec = stack.pop();
                queue.offer(sec);
            }
        }

        String out = queue.isEmpty() ? "First magic box is empty." : "Second magic box is empty.";
        String out2 = value >= 90 ? "Wow, your prey was epic! Value: " + value : "Poor prey... Value: " + value;
        System.out.println(out);
        System.out.println(out2);

    }
}