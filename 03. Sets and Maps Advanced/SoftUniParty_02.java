import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> guests = new TreeSet<>();
        String com = sc.nextLine();

        while(!com.equals("PARTY")){
            guests.add(com);
            com = sc.nextLine();
        }

        com = sc.nextLine();

        while(!com.equals("END")){
            guests.remove(com);
            com = sc.nextLine();
        }

        System.out.println(guests.size());
        for (String s : guests) {
            System.out.println(s);
        }

    }
}
