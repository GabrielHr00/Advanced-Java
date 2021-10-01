import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers_05_EX {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("/Users/mac/IdeaProjects/SoftUni/out/production/inputLineNumbers.txt");
        List<String> list = Files.readAllLines(path);
        PrintWriter out = new PrintWriter(new FileWriter("outme2.txt"));

        int counter = 1;
        for (String s : list) {
            out.write(counter + ". " + s);
            out.println();
            counter++;
        }
        out.flush();

    }
}
