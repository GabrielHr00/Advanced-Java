import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterByAge_05 {
    static class Person{
        String name;
        int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Person> people = IntStream.range(0, n).mapToObj(e -> {
            String[] tokens = sc.nextLine().split(", ");
            return new Person(tokens[0], Integer.parseInt(tokens[1]));
        }).collect(Collectors.toList());

        List<String> endData = IntStream.range(0,3).mapToObj(e -> {
            return sc.nextLine();
        }).collect(Collectors.toList());

        List<Person> filteredData = endData.get(0).equals("older") ?
                people.stream().filter(e -> e.age >= Integer.parseInt(endData.get(1))).collect(Collectors.toList())
                : people.stream().filter(e -> e.age <= Integer.parseInt(endData.get(1))).collect(Collectors.toList());

        if (endData.get(2).split("\\s+").length == 2) {
            filteredData.stream().forEach(e -> System.out.println(e.name + " - " + e.age));
        } else {
            if (endData.get(2).equals("name")) {
                filteredData.stream().forEach(e -> System.out.println(e.name));
            } else {
                filteredData.stream().forEach(e -> System.out.println(e.age));
            }
        }
    }
}
