import javax.crypto.CipherInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        List<Person> person = new ArrayList<>();
        String com = sc.nextLine();

        while(!com.equals("END")){
            String[] in = com.split("\\s+");
            person.add(new Person(in[0], Integer.parseInt(in[1]), in[2]));
            com = sc.nextLine();
        }

        int n = Integer.parseInt(sc.nextLine());

        Person p = person.remove(n - 1);

        int equal = (int)person.stream().filter(e -> e.compareTo(p) == 0).count();

        if(equal == 0){
            System.out.println("No matches");
        }
        else{
            System.out.printf("%d %d %d", equal + 1, person.size() - equal, person.size() + 1);
        }
    }
}