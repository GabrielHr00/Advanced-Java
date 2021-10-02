import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerPrint_01_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> list = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());
        Consumer<List<String>> printNames = e -> {
            for (var i : e){
                System.out.println(i);
            }
        };
        printNames.accept(list);
    }
}
