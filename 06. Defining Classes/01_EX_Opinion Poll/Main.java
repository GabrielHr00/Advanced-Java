import com.sun.jdi.DoubleValue;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Person> list = new ArrayList<>();

        while(n-- > 0){
            String[] com = sc.nextLine().split("\\s+");
            list.add(new Person(com[0], Integer.parseInt(com[1])));
        }

        list.stream()
                .filter(e -> e.getAge() > 30)
                .sorted((e1,e2) -> e1.getName().compareTo(e2.getName()))
                .forEach(e -> System.out.println(e.getName() + " - " + e.getAge()));

    }
}


