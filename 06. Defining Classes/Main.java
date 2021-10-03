import com.sun.jdi.DoubleValue;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Car lada = new Car();

        while(n-- > 0){
            String[] coms = sc.nextLine().split("\\s+");
            lada.setBrand(coms[0]);
            lada.setModel(coms[1]);
            lada.setHorsePower(Integer.parseInt(coms[2]));
            System.out.println(lada.carInfo());
        }

    }
}


