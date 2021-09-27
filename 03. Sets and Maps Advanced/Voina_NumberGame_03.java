import java.util.*;
import java.util.stream.Collectors;

public class Voina_NumberGame_03 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        Set<Integer> deck1 = Arrays
                .stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> deck2 = Arrays
                .stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int round = 50;

        while(round-- >= 0 || deck1.isEmpty() || deck2.isEmpty()){
            Integer it1 = deck1.iterator().next();
            deck1.remove(it1);
            Integer it2 = deck2.iterator().next();
            deck2.remove(it2);

            if(it1 > it2){
                deck1.add(it1);
                deck1.add(it2);
            }else if(it1 < it2){
                deck2.add(it2);
                deck2.add(it1);
            }
        }

        if(deck1.size() > deck2.size()){
            System.out.println("First player win!");
        }else if(deck1.size() < deck2.size()){
            System.out.println("Second player win!");
        }
        else{
            System.out.println("Draw!");
        }
    }
}

