import java.util.ArrayDeque;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class MathPotato_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] kids = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(sc.nextLine());

        for(String i : kids){
            queue.offer(i);
        }

        int cycle = 1;
        while(queue.size() > 1){
            for(int i = 1; i < n; i++){
                queue.offer(queue.poll());
            }
            if(isPrime(cycle)){
                System.out.println("Prime " + queue.peek());
            }
            else{
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is "+ queue.poll());
    }

    private static boolean isPrime(int n) {
        if (n <= 1)
            return false;

        // Check from 2 to square root of n
        for (int i = 2; i <= sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
    }
}
