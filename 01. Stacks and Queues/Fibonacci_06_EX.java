import java.util.Scanner;

public class Fibonacci_06_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = Integer.parseInt(sc.nextLine());
        int result = fibonacci(input);
        System.out.println(result);
    }

    private static int fibonacci(int input) {
        if(input == 0 || input == 1){
            return 1;
        }
        else{
            return fibonacci(input - 1) + fibonacci(input - 2);
        }
    }
}
