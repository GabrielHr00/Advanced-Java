import com.sun.jdi.DoubleValue;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Engine> engines = new ArrayList<>();

        while(n-- > 0){
            String[] com = sc.nextLine().split("\\s+");
            if(com.length == 2){
                Engine en = new Engine(com[0], Integer.parseInt(com[1]));
                engines.add(en);
            }
            else if(com.length == 3){
                try{
                    int num = Integer.parseInt(com[2]);
                    Engine en = new Engine(com[0], Integer.parseInt(com[1]), num);
                    engines.add(en);
                }catch(NumberFormatException e){
                    Engine en = new Engine(com[0], Integer.parseInt(com[1]), com[2]);
                    engines.add(en);
                }
            }
            else{
                Engine en = new Engine(com[0], Integer.parseInt(com[1]), Integer.parseInt(com[2]), com[3]);
                engines.add(en);
            }
        }

        int secondN = Integer.parseInt(sc.nextLine());
        List<Car> cars = new ArrayList<>();

        while(secondN-- > 0){
            String[] com = sc.nextLine().split("\\s+");
            Engine en = null;

            if(com.length == 2){
                for (var i : engines) {
                    if(i.getModel().equals(com[1])){
                        en = i;
                    }
                }
                Car c = new Car(com[0],en);
                cars.add(c);
            }
            else if(com.length == 3){
                try{
                    int weight = Integer.parseInt(com[2]);
                    for (var i : engines) {
                        if(i.getModel().equals(com[1])){
                            en = i;
                        }
                    }
                    Car c = new Car(com[0], en, weight);
                    cars.add(c);
                }catch(NumberFormatException e){
                    String color = com[2];
                    for (var i : engines) {
                        if(i.getModel().equals(com[1])){
                            en = i;
                        }
                    }
                    Car c = new Car(com[0], en, color);
                    cars.add(c);
                }
            }
            else{
                for (var i : engines) {
                    if(i.getModel().equals(com[1])){
                        en = i;
                    }
                }
                Car c = new Car(com[0], en, Integer.parseInt(com[2]), com[3]);
                cars.add(c);
            }
        }

        cars.stream().forEach(System.out::println);

    }
}


