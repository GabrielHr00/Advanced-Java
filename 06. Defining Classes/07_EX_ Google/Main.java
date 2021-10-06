import javax.crypto.CipherInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<String, Person> map = new LinkedHashMap<>();

        String com = sc.nextLine();
        while(!com.equals("End")){
            String[] coms = com.split("\\s+");
            if(map.containsKey(coms[0])){
                containsAlready(map, coms);
            }
            else{
                notYetThere(map, coms);
            }
            com = sc.nextLine();
        }

        com = sc.nextLine();
        Person p = map.get(com);
        System.out.println(p.toString());
    }

    private static void notYetThere(Map<String, Person> map, String[] coms) {
        switch(coms[1]){
            case "company":
                map.put(coms[0], new Person(coms[0], new Company(coms[2], coms[3], Double.parseDouble(coms[4]))));
                break;
            case "pokemon":
                Set<Pokemon> collection = new LinkedHashSet<>();
                collection.add(new Pokemon(coms[2], coms[3]));
                map.put(coms[0], new Person(coms[0], collection));
                break;
            case "parents":
                List<Parent> parents = new ArrayList<>();
                parents.add(new Parent(coms[2], coms[3]));
                map.put(coms[0], new Person(coms[0], parents));
                break;
            case "children":
                ArrayList<Child> children = new ArrayList<>();
                children.add(new Child(coms[2], coms[3]));
                map.put(coms[0], new Person(coms[0], children));
                break;
            case "car":
                map.put(coms[0], new Person(coms[0], new Car(coms[2], coms[3])));
                break;
        }
    }

    private static void containsAlready(Map<String, Person> map, String[] coms) {
        switch(coms[1]){
            case "company":
                map.get(coms[0]).setCompany(new Company(coms[2], coms[3], Double.parseDouble(coms[4])));
                break;
            case "pokemon":
                map.get(coms[0]).setPokemonList(new Pokemon(coms[2], coms[3]));
                break;
            case "parents":
                map.get(coms[0]).setParentList(new Parent(coms[2], coms[3]));
                break;
            case "children":
                map.get(coms[0]).setChildList(new Child(coms[2], coms[3]));
                break;
            case "car":
                map.get(coms[0]).setCar(new Car(coms[2], coms[3]));
                break;
        }
    }
}