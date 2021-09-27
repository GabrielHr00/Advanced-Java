import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames_01_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Set<String> words = new LinkedHashSet<>();

        while(n-- > 0){
            String com = sc.nextLine();
            words.add(com);
        }

        words.stream().forEach(System.out::println);
    }
}
