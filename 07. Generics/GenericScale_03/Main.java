import javax.crypto.CipherInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scale<Integer> scale1 = new Scale<>(16, 16);
        Scale<Integer> scale2 = new Scale<>(17, 16);
        Scale<Integer> scale3 = new Scale<>(15, 16);

        Integer heavier1 = scale1.getHeavier();
        Integer heavier2 = scale2.getHeavier();
        Integer heavier3 = scale3.getHeavier();

    }
}