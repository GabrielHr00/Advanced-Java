import javax.crypto.CipherInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Box<Double> box = new Box();

        for (int i = 0; i < n; i++) {
            Double value = Double.parseDouble(sc.nextLine());
            box.add(value);
        }

        Double element = Double.parseDouble(sc.nextLine());
        System.out.println(box.countOfGreater(element));
    }
}