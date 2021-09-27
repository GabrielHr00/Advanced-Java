import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Double, Integer> map = new LinkedHashMap<>();
        double[] cont = Arrays
                .stream(sc.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        for (double d : cont) {
            if (map.containsKey(d)) {
                map.put(d, map.get(d) + 1);
            } else {
                map.put(d, 1);
            }
        }

        for (var v : map.keySet()) {
            System.out.println(String.format("%.1f -> %d", v, map.get(v)));
        }


    }
}
