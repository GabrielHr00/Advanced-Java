import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotPotato_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] kids = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(sc.nextLine());

        for(String i : kids){
            queue.offer(i);
        }
        while(queue.size() > 1){
            for(int i = 1; i < n; i++){
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is "+ queue.poll());
    }
}
