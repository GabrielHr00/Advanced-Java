import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements_02_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] comm = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int first = comm[0];
        int second = comm[1];

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        while(first-- > 0){
            firstSet.add(Integer.parseInt(sc.nextLine()));
        }
        while(second-- > 0){
            secondSet.add(Integer.parseInt(sc.nextLine()));
        }

        firstSet.retainAll(secondSet);
        firstSet.stream().forEach(e -> System.out.print(e + " "));
    }
}
