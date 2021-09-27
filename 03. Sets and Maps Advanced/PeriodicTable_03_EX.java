import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable_03_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Set<String> set = new TreeSet<>();
        while(n-- > 0){
            String[] com = sc.nextLine().split("\\s+");
            for (String s : com) {
                set.add(s);
            }
        }

        set.stream().forEach(e -> System.out.print(e + " "));
    }
}
