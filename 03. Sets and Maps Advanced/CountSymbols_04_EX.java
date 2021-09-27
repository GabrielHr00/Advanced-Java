import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String com = sc.nextLine();

        Map<Character, Integer> map = new TreeMap<>();

        for (char c : com.toCharArray()) {
            map.putIfAbsent(c, 0);
            int tempValue = map.get(c);
            map.put(c, tempValue + 1);
        }

        map.entrySet().stream().forEach(e -> {
            System.out.printf("%s: %d time/s%n", e.getKey(), e.getValue());
        });

    }
}
