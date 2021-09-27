import org.w3c.dom.ls.LSOutput;

import javax.sound.sampled.Line;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String com = sc.nextLine();

        Map<String, String> map = new LinkedHashMap<>();
        while(!com.equals("search")){
            String name = com.split("-")[0];
            String number = com.split("-")[1];
            map.put(name, number);

            com = sc.nextLine();
        }

        com = sc.nextLine();
        while(!com.equals("stop")){
            if (map.containsKey(com)) {
                System.out.println(com + " -> " + map.get(com));
            } else {
                System.out.println("Contact " + com + " does not exist.");
            }

            com = sc.nextLine();
        }

    }
}
