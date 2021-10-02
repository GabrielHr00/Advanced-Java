import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class KnightsOfHonor_02_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String com = sc.nextLine();

        Consumer<String> printSir = e -> {
            List<String> list = Arrays.stream(e.split("\\s+")).map(each -> "Sir " + each).collect(Collectors.toList());
            list.stream().forEach(System.out::println);
        };
        printSir.accept(com);
    }
}
