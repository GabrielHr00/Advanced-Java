import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        Predicate<String> isUpper = e -> Character.isUpperCase(e.charAt(0));
        List<String> list = Arrays.stream(line.split("\\s+")).filter(e -> isUpper.test(e)).collect(Collectors.toList());
        System.out.println(list.size());
        list.stream().forEach(e -> System.out.println(e));
    }
}
