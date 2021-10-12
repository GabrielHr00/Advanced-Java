import javax.crypto.CipherInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Box<String> box = new Box();

        for (int i = 0; i < n; i++) {
            String value = sc.nextLine();
            box.add(value);
        }
        System.out.println(box);

    }
}