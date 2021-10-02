import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates_09_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Integer> list = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        BiFunction<List<Integer>, Integer, Boolean> checkIfDivisible = (liss, d) -> {
            for (int i : liss) {
                if(d % i != 0){
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= n; i++) {
            if(checkIfDivisible.apply(list, i)){
                System.out.print(i + " ");
            }
        }
    }
}
