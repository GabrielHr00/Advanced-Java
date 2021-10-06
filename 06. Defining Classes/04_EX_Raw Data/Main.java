import com.sun.jdi.DoubleValue;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, List<Car>> map = new LinkedHashMap<>();
        map.put("flamable", new ArrayList<>());
        map.put("fragile", new ArrayList<>());

        while(n-- > 0){
            String[] com = sc.nextLine().split("\\s+");
            Car c = new Car(com[0], new Engine(com[1], Double.parseDouble(com[2])), new Cargo(Integer.parseInt(com[3]), com[4]), new ArrayList<>());
            c.getTires().add(new Tire(Double.parseDouble(com[5]), Integer.parseInt(com[6])));
            c.getTires().add(new Tire(Double.parseDouble(com[7]), Integer.parseInt(com[8])));
            c.getTires().add(new Tire(Double.parseDouble(com[9]), Integer.parseInt(com[10])));
            c.getTires().add(new Tire(Double.parseDouble(com[11]), Integer.parseInt(com[12])));
            if(checkLastCommand(c) == 1){
                map.get("fragile").add(c);
            }
            else if(checkLastCommand(c) == 2){
                map.get("flamable").add(c);
            }
        }

        String last = sc.nextLine();
        map.entrySet().stream().filter(e -> e.getKey().equals(last)).forEach(e -> {
            for (var i : e.getValue()) {
                System.out.println(i.getModel());
            }
        });

    }

    public static int checkLastCommand(Car car){
        // fragile - 1
        // flamile - 2
        // nothing - 0
        if(car.getCargo().getType().equals("fragile")){
            for (var i : car.getTires()) {
                if(i.getPressure() < 1){
                    return 1;
                }
            }
        }
        else if(car.getCargo().getType().equals("flamable")){
            if(car.getEngine().getPower() > 250){
                return 2;
            }
        }
        return 0;
    }
}


