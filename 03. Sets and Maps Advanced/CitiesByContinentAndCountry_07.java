import javax.sound.sampled.Line;
import java.util.*;

public class CitiesByContinentAndCountry_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();
        while(n-- > 0){
            String[] com = sc.nextLine().split("\\s+");
            if(!map.containsKey(com[0])){
                LinkedHashMap<String, List<String>> helpMap = new LinkedHashMap<>();
                helpMap.putIfAbsent(com[1], new ArrayList<>());
                map.put(com[0], helpMap);
            }else{
                map.get(com[0]).putIfAbsent(com[1], new ArrayList<>());
            }
            map.get(com[0]).get(com[1]).add(com[2]);
        }

        map.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + ":");
            entry.getValue().entrySet().stream().forEach(e -> {
                System.out.print("  " + e.getKey() + " -> ");
                System.out.println(String.join(", ", e.getValue()));
            });
        });

    }
}
