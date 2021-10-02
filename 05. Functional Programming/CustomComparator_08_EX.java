import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomComparator_08_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        BiFunction<Integer, Integer, Integer> sort = (e1, e2) -> {
                if(e1 % 2 == 0 && e2 % 2 != 0){
                    return -1;
                }
                else if(e1 % 2 != 0 && e2 % 2 == 0){
                    return 1;
                }
                else{
                    return e1.compareTo(e2);
                }
        };

        list.stream().sorted((e1, e2) -> sort.apply(e1, e2)).forEach(e -> System.out.print(e + " "));
    }
}
