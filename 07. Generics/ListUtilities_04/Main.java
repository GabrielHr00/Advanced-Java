import javax.crypto.CipherInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        List<Integer> integs = List.of(13, 42, 73, 69);
        List<String> strings = List.of("13", "42", "73", "69");

        System.out.println(ListUtils.getMin(integs));
        System.out.println(ListUtils.getMax(strings));
        
    }
}