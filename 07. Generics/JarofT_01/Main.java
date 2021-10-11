import javax.crypto.CipherInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        Jar<Integer> jarOfPickles = new Jar<>();

        jarOfPickles.add(12);
        jarOfPickles.add(14);

        int i = jarOfPickles.remove();

    }
}