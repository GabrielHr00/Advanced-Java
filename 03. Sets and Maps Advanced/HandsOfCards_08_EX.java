import java.util.*;

public class HandsOfCards_08_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String com = sc.nextLine();

        Map<String, Set<String>> map = new LinkedHashMap<>();
        while(!com.equals("JOKER")){
            String name = com.split(": ")[0];
            String cards = com.split(": ")[1];
            String[] cardsToSep = cards.split(", ");

            Set<String> set = new LinkedHashSet<>();
            Collections.addAll(set, cardsToSep);

            if(map.containsKey(name)){
                Set<String> helpSet = map.get(name);
                helpSet.addAll(set);
                map.put(name, helpSet);
            }else{
                map.put(name, set);
            }
            com = sc.nextLine();
        }

        map.entrySet().forEach(e -> {
            System.out.println(e.getKey() + ": " + calculateSum(e.getValue()));
        });

    }

    private static int calculateSum(Set<String> value) {
        int sum = 0;
        Map<Character, Integer> map = getFullMap();
        for (String s : value) {
            if(s.contains("10")){
                sum += 10 * map.get(s.charAt(2));
            }else{
                sum += map.get(s.charAt(0)) * map.get(s.charAt(1));
            }
        }
        return sum;
    }

    private static Map<Character, Integer> getFullMap() {
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('J', 11);
        map.put('Q', 12);
        map.put('K', 13);
        map.put('A', 14);
        map.put('S', 4);
        map.put('H', 3);
        map.put('D', 2);
        map.put('C', 1);
        return map;
    }
}
