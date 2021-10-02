import java.awt.font.FontRenderContext;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement_07_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> minim = e -> {
            int min = Integer.MAX_VALUE;
            for (var i : e) {
                if(i < min) min = i;
            }
            return min;
        };

        System.out.println(list.lastIndexOf(minim.apply(list)));
    }
}
