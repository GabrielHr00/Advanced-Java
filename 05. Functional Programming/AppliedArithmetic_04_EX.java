import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic_04_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String com = sc.nextLine();
        while(!com.equals("end")){
            switch(com){
                case "add":
                    Function<List<Integer>, List<Integer>> add = e -> e.stream().map(er -> er += 1).collect(Collectors.toList());
                    list = add.apply(list);
                    break;
                case "multiply":
                    Function<List<Integer>, List<Integer>> multi = e -> e.stream().map(er -> er *= 2).collect(Collectors.toList());
                    list = multi.apply(list);
                    break;
                case "subtract":
                    Function<List<Integer>, List<Integer>> sub = e -> e.stream().map(er -> er -= 1).collect(Collectors.toList());
                    list = sub.apply(list);
                    break;
                case "print":
                    Consumer<List<Integer>> print = e -> e.forEach(er -> System.out.print(er + " "));
                    print.accept(list);
                    System.out.println();
                    break;
            }
            com = sc.nextLine();
        }
    }
}
