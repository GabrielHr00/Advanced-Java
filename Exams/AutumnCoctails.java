import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class AutumnCoctails {
    static int sour = 0;
    static int harvest = 0;
    static int apple = 0;
    static int fashion = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque();
        Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(e -> queue.offer(e));

        ArrayDeque<Integer> stack = new ArrayDeque();
        Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(e -> stack.push(e));


        while (!queue.isEmpty() && !stack.isEmpty()) {
//            if (queue.peek() == 0) {
//                queue.poll();
//            }

            int first = queue.peek();
            int second = stack.peek();
            int sum = first * second;

            switch (sum) {
                case 150:
                    sour += 1;
                    queue.poll();
                    stack.pop();
                    break;
                case 250:
                    harvest += 1;
                    queue.poll();
                    stack.pop();
                    break;
                case 300:
                    apple += 1;
                    queue.poll();
                    stack.pop();
                    break;
                case 400:
                    fashion += 1;
                    queue.poll();
                    stack.pop();
                    break;
                default:
                    if (first == 0) {
                        queue.poll();
                    }
                    else {
                        stack.pop();
                        queue.poll();
                        queue.offer(first + 5);
                    }
            }
        }

        if (sour >= 1 && harvest >= 1 && apple >= 1 && fashion >= 1) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!queue.isEmpty()) {
            int sum = getSum(queue);
            System.out.println("Ingredients left: " + sum);
        }

        if(apple >= 1){
            System.out.println(" # Apple Hinny --> " + apple);
        }
        if(fashion >= 1){
            System.out.println(" # High Fashion --> " + fashion);
        }
        if(sour >= 1){
            System.out.println(" # Pear Sour --> " + sour);
        }
        if(harvest >= 1){
            System.out.println(" # The Harvest --> " + harvest);
        }

    }

    private static int getSum(ArrayDeque<Integer> queue) {
        int sum = 0;
        for (var i : queue) {
            sum += i;
        }
        return sum;
    }
}
