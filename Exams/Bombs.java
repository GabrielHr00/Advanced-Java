import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs {
    static int datura = 0;
    static int cherry = 0;
    static int smoke = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> queue = Arrays.stream(sc.nextLine().split(",\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> stack = new ArrayDeque();
        Arrays.stream(sc.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(e -> stack.push(e));


        while(!queue.isEmpty() && !stack.isEmpty()){
            int first = queue.peek();
            int second = stack.peek();
            int sum = first + second;

            switch(sum){
                case 40:
                    datura++;
                    queue.poll();
                    stack.pop();
                    break;
                case 60:
                    cherry++;
                    queue.poll();
                    stack.pop();
                    break;
                case 120:
                    smoke++;
                    queue.poll();
                    stack.pop();
                    break;
                default:
                    stack.pop();
                    stack.push(second - 5);
                    break;
            }
            if(datura >= 3 && cherry >= 3 && smoke >= 3) {
                break;
            }

        }

        if(datura >= 3 && cherry >= 3 && smoke >= 3){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else{
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if(queue.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else{
            System.out.println("Bomb Effects: " + String.join(", ", queue.toString().replaceAll("\\[", "").replaceAll("\\]", "")));
        }

        if(stack.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }else{
            System.out.println("Bomb Casings: " + String.join(", ", stack.toString().replaceAll("\\[", "").replaceAll("\\]", "")));
        }

        System.out.println("Cherry Bombs: " + cherry);
        System.out.println("Datura Bombs: " + datura);
        System.out.println("Smoke Decoy Bombs: " + smoke);

    }
}
