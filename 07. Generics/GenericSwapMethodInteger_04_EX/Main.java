import javax.crypto.CipherInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Box<Integer> box = new Box();

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(sc.nextLine());
            box.add(value);
        }
        String[] indeces = sc.nextLine().split("\\s+");
        int first = Integer.parseInt(indeces[0]);
        int second = Integer.parseInt(indeces[1]);
        box.swap(first, second);

        System.out.println(box);

    }
}