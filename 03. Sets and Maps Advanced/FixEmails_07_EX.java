import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_07_EX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> map = new LinkedHashMap<>();

        String name = sc.nextLine();
        while(!name.equals("stop")){
            String email = sc.nextLine();

            if(!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")){
                map.put(name, email);
            }
            name = sc.nextLine();
        }

        map.entrySet().stream().forEach(s -> System.out.println(s.getKey() + " -> " + s.getValue()));
    }
}
