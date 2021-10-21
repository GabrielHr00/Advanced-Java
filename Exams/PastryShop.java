import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> queue = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        System.out.println();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);

        int biscuit = 0;
        int cake = 0;
        int pie = 0;
        int pastry = 0;

        while(!queue.isEmpty() && !stack.isEmpty()){
            int liquid = queue.peek();
            int ingredient = stack.peek();

            int sum = liquid + ingredient;
            switch (sum) {
                case 25:
                    biscuit++;
                    queue.poll();
                    stack.pop();
                    break;
                case 50:
                    cake++;
                    queue.poll();
                    stack.pop();
                    break;
                case 75:
                    pastry++;
                    queue.poll();
                    stack.pop();
                    break;
                case 100:
                    pie++;
                    queue.poll();
                    stack.pop();
                    break;
                default:
                    queue.poll();
                    ingredient = ingredient + 3;
                    stack.pop();
                    stack.push(ingredient);
                    break;
            }
            if (queue.size() == 0 || stack.size() == 0) {
                break;
            }
        }

        if(biscuit >= 1 && cake >= 1 && pie >= 1 && pastry >= 1){
            System.out.println("Great! You succeeded in cooking all the food!");
        }else{
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        System.out.println("Liquids left: " + print(queue));
        System.out.println("Ingredients left: " + print(stack));
        System.out.printf("Biscuit: %d%n", biscuit);
        System.out.printf("Cake: %d%n", cake);
        System.out.printf("Pie: %d%n", pie);
        System.out.printf("Pastry: %d%n", pastry);
    }
    private static String print(ArrayDeque<Integer> deque) {
        if (deque.isEmpty()) {
            return "none";
        }
        return deque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}