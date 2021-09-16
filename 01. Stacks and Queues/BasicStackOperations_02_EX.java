import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations_02_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data1 = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(data1[0]); // to push
        int s = Integer.parseInt(data1[1]); // to pop
        String r = data1[2]; // present or not
        String[] data = sc.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            stack.push(data[i]);
        }
        for(int i = 0; i < s; i++) {
            stack.pop();
        }

        if(stack.contains(r)){
            System.out.println("true");
        }else{
            if(!stack.isEmpty()){
                System.out.println(Collections.min(stack));
            }else{
                System.out.println("0");
            }
        }

    }
}
