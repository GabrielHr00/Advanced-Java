import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty_10_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> list = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());
        String com = sc.nextLine();

        BiFunction<String, String, String> starts = (e, c) -> {
            if(e.startsWith(c)){
                return e;
            }
            return "";
        };
        BiFunction<String, String, String> ends = (e, c) -> {
            if(e.endsWith(c)){
                return e;
            }
            return "";
        };

        BiFunction<String, Integer, String> hasLength = (e, c) -> {
            if(e.length() == c){
                return e;
            }
            return "";
        };

        while(!com.equals("Party!")){
            String[] coms = com.split("\\s+");
            List<String> progress = new ArrayList<>();
            switch(coms[0]){
                case "Remove":
                    switch(coms[1]){
                        case "StartsWith":
                            for (var i : list) {
                                if(starts.apply(i, coms[2]) != ""){
                                    list.remove(i);
                                }
                                break;
                            }
                            break;
                        case "EndsWith":
                            for (var i : list) {
                                if(ends.apply(i, coms[2]) != ""){
                                    list.remove(i);
                                }
                                break;
                            }
                            break;
                        case "Length":
                            for (var i : list) {
                                if(hasLength.apply(i, Integer.parseInt(coms[2])) != ""){
                                    list.remove(i);
                                }
                                break;
                            }
                            break;
                    }
                    break;
                case "Double":
                    switch(coms[1]){
                        case "StartsWith":
                            for (var i : list) {
                                if(starts.apply(i, coms[2]) != ""){
                                    progress.add(i);
                                }
                            }
                            list.addAll(progress);
                            break;
                        case "EndsWith":
                            for (var i : list) {
                                if(ends.apply(i, coms[2]) != ""){
                                    progress.add(i);
                                }
                            }
                            list.addAll(progress);
                            break;
                        case "Length":
                            for (var i : list) {
                                if(hasLength.apply(i, Integer.parseInt(coms[2])) != ""){
                                    progress.add(i);
                                }
                            }
                            list.addAll(progress);
                            break;
                    }
                    break;
            }

            com = sc.nextLine();
        }

        if(list.size() == 0){
            System.out.println("Nobody is going to the party!");
        }else{
            list = list.stream().sorted().collect(Collectors.toList());
            System.out.println(String.join(", ", list) + " are going to the party!");
        }

    }
}
