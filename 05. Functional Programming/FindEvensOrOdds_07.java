import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> range = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String com = sc.nextLine();

        Predicate<String> oddEven = e -> e.equals("even");
        Predicate<Integer> oddOrEven = e -> e % 2 == 0;

        for (int i = range.get(0); i <= range.get(1); i++) {
            if(oddEven.test(com)){
                if(oddOrEven.test(i)){
                    System.out.print(i + " ");
                }
            }
            else{
                if(!oddOrEven.test(i)){
                    System.out.print(i + " ");
                }
            }
        }
    }
}
