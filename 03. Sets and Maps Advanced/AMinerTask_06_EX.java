import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask_06_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String material = sc.nextLine();

        Map<String, Integer> map = new LinkedHashMap<>();
        while(!material.equals("stop")){
            int quantity = Integer.parseInt(sc.nextLine());
            map.putIfAbsent(material, 0);
            map.put(material, map.get(material) + quantity);

            material = sc.nextLine();
        }

        map.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + " -> " + e.getValue());
        });
    }
}
