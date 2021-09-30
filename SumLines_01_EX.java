import java.io.*;
import java.nio.file.Path;

public class SumLines_01_EX {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("/Users/mac/IdeaProjects/SoftUni/out/production/input.txt");
        BufferedReader read = new BufferedReader(new FileReader(String.valueOf(path)));

        String line = read.readLine();
        while(line != null){
            int sum = 0;
            for (char c : line.toCharArray()) {
                sum += c;
            }
            System.out.println(sum);
            line = read.readLine();
        }
    }
}
