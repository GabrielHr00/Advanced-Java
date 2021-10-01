import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeTwoFiles_07_EX {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("/Users/mac/IdeaProjects/SoftUni/out/production/inputOne.txt");
        List<String> listOne = Files.readAllLines(path);

        Path path1 = Path.of("/Users/mac/IdeaProjects/SoftUni/out/production/inputTwo.txt");
        List<String> listTwo = Files.readAllLines(path1);
        PrintWriter out = new PrintWriter(new FileWriter("outme3.txt"));

        for (String s: listOne) {
            out.write(s + "\n");
        }
        for (String s: listTwo) {
            out.write(s + "\n");
        }
        out.flush();
    }
}
