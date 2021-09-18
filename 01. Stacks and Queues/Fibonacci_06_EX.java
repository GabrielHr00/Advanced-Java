import java.util.Scanner;

public class Fibonacci_06_EX {
    public static long[] memory;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = Integer.parseInt(sc.nextLine());
        memory = new long[input+1];
        System.out.println(fib(input));
    }

    private static long fib(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        if(memory[n] != 0){
            return memory[n];
        }
        return memory[n] = fib((n - 1)) + fib((n - 2));
    }
}
