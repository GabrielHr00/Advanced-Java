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

        Set<Person> nameSet = new TreeSet<>(new NameComparator());
        Set<Person> ageSet = new TreeSet<>(new AgeComparator());

        int n = Integer.parseInt(sc.nextLine());

        while(n-- > 0){
            String line = sc.nextLine();

            String[] people = line.split("\\s+");
            ageSet.add(new Person(people[0], Integer.parseInt(people[1])));
            nameSet.add(new Person(people[0], Integer.parseInt(people[1])));
        }

        nameSet.stream().forEach(e -> System.out.println(e.toString()));
        ageSet.stream().forEach(e -> System.out.println(e.toString()));

    }
}