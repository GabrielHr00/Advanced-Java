import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames_06_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<String> names = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String> checkIt = e -> {
            if(e.length() <= n){
                System.out.println(e);
                return true;
            }
            return false;
        };

        for (var i : names) {
            checkIt.test(i);
        }

    }
}
