import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> data = Arrays.stream(sc.nextLine().split(", ")).collect(Collectors.toList());
        String result1 = data.stream().mapToInt(Integer::parseInt).filter(e -> e % 2 == 0).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(result1);
        String result2 = data.stream().mapToInt(Integer::parseInt).filter(e -> e % 2 == 0).sorted().mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(result2);
    }
}
