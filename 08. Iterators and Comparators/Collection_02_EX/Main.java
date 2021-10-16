import javax.crypto.CipherInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        ListyIterator list = null;

        String[] com = sc.nextLine().split("\\s+");

        while(!com[0].equals("END")){
            switch(com[0]){
                case "Create":
                    if(com.length == 1){
                        list = new ListyIterator();
                    }
                    else{
                        list = new ListyIterator(Arrays.copyOfRange(com, 1, com.length));
                    }
                    break;
                case "Move":
                    System.out.println(list.move());
                    break;
                case "Print":
                    list.print();
                    break;
                case "HasNext":
                    System.out.println(list.hasNext());
                    break;
                case "PrintAll":
                    System.out.println(String.join(" ", list.getList()));
                    break;
            }

            com = sc.nextLine().split("\\s+");
        }


    }
}