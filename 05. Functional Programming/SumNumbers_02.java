import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        Function<String, Integer> lengthOfList = e -> {
            List<Integer> list = Arrays.stream(e.split(", ")).map(Integer::parseInt).collect(Collectors.toList());
            return list.size();
        };
        System.out.println("Count = " + lengthOfList.apply(in));

        Function<String, Integer> sumOfList = e -> {
            return Arrays.stream(e.split(", ")).mapToInt(Integer::parseInt).sum();
        };
        System.out.println("Sum = " + sumOfList.apply(in));

    }
}
