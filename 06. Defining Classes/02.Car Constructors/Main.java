import com.sun.jdi.DoubleValue;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Car> list = new ArrayList<>();

        while(n-- > 0){
            String[] coms = sc.nextLine().split("\\s+");
            if(coms.length == 1){
                Car car = new Car(coms[0]);
                list.add(car);
            }
            else{
                Car car = new Car(coms[0], coms[1], Integer.parseInt(coms[2]));
                list.add(car);
            }
        }
        list.stream().forEach(e -> System.out.println(e.carInfo()));

    }
}


