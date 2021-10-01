import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount_06_EX {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new TreeMap<>();
        Path path = Path.of("/Users/mac/IdeaProjects/SoftUni/out/production/words.txt");
        List<String> list = Files.readAllLines(path);
        Arrays.stream(list.get(0).split("\\s+")).collect(Collectors.toList()).forEach(e -> map.put(e, 0));

        Path path1 = Path.of("/Users/mac/IdeaProjects/SoftUni/out/production/text.txt");
        List<String> list1 = Files.readAllLines(path1);
        list1 = Arrays.stream(list1.get(0).split("\\s+")).collect(Collectors.toList());
        PrintWriter out = new PrintWriter(new FileWriter("outme3.txt"));

        for (String s : list1) {
            if(map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            }
        }

        map.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(entry -> {
                    out.write(entry.getKey() + " - " + entry.getValue());
                    out.println();
                });

        out.flush();
    }
}
