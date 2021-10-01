import java.io.*;
import java.nio.file.Path;

public class ALLCAPITALS_03_EX {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("/Users/mac/IdeaProjects/SoftUni/out/production/input.txt");
        BufferedReader read = new BufferedReader(new FileReader(String.valueOf(path)));
        PrintWriter out = new PrintWriter(new FileWriter("outme.txt"));

        String line = read.readLine();
        while(line != null){
            line = line.toUpperCase();
            out.write(line);
            out.println();

            line = read.readLine();
        }
        out.flush();
    }
}
