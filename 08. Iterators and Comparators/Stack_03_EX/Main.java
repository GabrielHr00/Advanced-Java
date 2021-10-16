import javax.crypto.CipherInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        Stack stack = new Stack();

        String com = sc.nextLine();

        while(!com.equals("END")){
            String[] com1 = com.split("\\s+");
            if(com1[0].equals("Push")){
                String s = String.join(" ", Arrays.stream(com1).skip(1).collect(Collectors.toList()));
                stack.push(s);
            }
            else if(com1[0].equals("Pop")){
                stack.pop();
            }
            com = sc.nextLine();
        }
        IntStream.range(0, 2).forEach(i -> stack.forEach(System.out::println));
    }
}