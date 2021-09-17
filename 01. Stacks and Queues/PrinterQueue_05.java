import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();
        String com = sc.nextLine();

        while(!com.equals("print")){
            if(com.equals("cancel")){
                if(!queue.isEmpty()){
                    System.out.println("Canceled " + queue.poll());
                }
                else{
                    System.out.println("Printer is on standby");
                }
            }
            else{
                queue.offer(com);
            }
            com = sc.nextLine();
        }

        queue.stream().forEach(System.out::println);

    }
}
