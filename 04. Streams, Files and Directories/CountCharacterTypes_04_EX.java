import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes_04_EX {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("/Users/mac/IdeaProjects/SoftUni/out/production/input.txt");
        List<String> list = Files.readAllLines(path);
        PrintWriter out = new PrintWriter(new FileWriter("outme1.txt"));

        int vowels = 0;
        int punc = 0;
        int conso = 0;

        for (String s : list) {
            for (char c : s.toCharArray()) {
                if(c == ' '){
                    continue;
                }
                else if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    vowels++;
                }
                else if(c == '.' || c == ',' || c == '!' || c == '?'){
                    punc++;
                }else{
                    conso++;
                }
            }
        }

        out.write("Vowels: " + vowels + "\n");
        out.write("Consonants: " + conso + "\n");
        out.write("Punctuation: " + punc + "\n");
        out.flush();
    }
}
