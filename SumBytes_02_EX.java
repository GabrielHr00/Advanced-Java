import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class SumBytes_02_EX {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("/Users/mac/IdeaProjects/SoftUni/out/production/input.txt");
        BufferedReader read = new BufferedReader(new FileReader(String.valueOf(path)));

        String line = read.readLine();
        long sum = 0;
        while(line != null){
            for (char i : line.toCharArray()) {
                sum += i;
            }
            line = read.readLine();
        }
        System.out.println(sum);
    }
}
