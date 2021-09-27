import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String com = sc.nextLine();

        Map<String, LinkedHashMap<String, Double>> map = new TreeMap<>();
        while(!com.equals("Revision")){
            String[] data = com.split(", ");
            String market = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);

            map.putIfAbsent(market, new LinkedHashMap<>());
            map.get(market).put(product, price);

            com = sc.nextLine();
        }

        map.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + "->");
            e.getValue().entrySet().stream().forEach(entry -> {
                System.out.printf("Product: %s, Price: %.1f%n", entry.getKey(), entry.getValue());
            });
        });
    }
}
