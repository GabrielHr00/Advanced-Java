import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations_04_EX {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String[] data1 = sc.nextLine().split("\\s+");
            int n = Integer.parseInt(data1[0]); // to push
            int s = Integer.parseInt(data1[1]); // to pop
            String r = data1[2]; // present or not
            String[] data = sc.nextLine().split("\\s+");

            ArrayDeque<String> queue = new ArrayDeque<>();
            for(int i = 0; i < n; i++){
                queue.offer(data[i]);
            }
            for(int i = 0; i < s; i++) {
                queue.poll();
            }

            if(queue.contains(r)){
                System.out.println("true");
            }else{
                if(!queue.isEmpty()){
                    System.out.println(Collections.min(queue));
                }else{
                    System.out.println("0");
                }
            }

        }
}
