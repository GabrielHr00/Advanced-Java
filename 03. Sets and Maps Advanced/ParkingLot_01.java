import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String com = sc.nextLine();
        Set<String> cars = new LinkedHashSet<>();

        while(!com.equals("END")){
            String command = com.split(", ")[0];
            String comm = com.split(", ")[1];

            if(command.equals("IN")){
                cars.add(comm);
            }
            else{
                cars.remove(comm);
            }
            com = sc.nextLine();
        }

        if(cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            for (String s : cars) {
                System.out.println(s);
            }
        }

    }
}
