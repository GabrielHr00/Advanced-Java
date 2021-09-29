import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class WriteEveryThirdLine_05 {
    public static void main(String[] args) throws IOException {
        String path = "/Users/mac/IdeaProjects/SoftUni/out/production/SoftUni/input.txt";
        FileReader read = new FileReader(path);
        BufferedReader reader = new BufferedReader(read);

        String current = reader.readLine();
        int count = 1;
        while(current != null){
            if(count % 3 == 0){
                System.out.println(current);
            }
            count++;
            current = reader.readLine();
        }
    }
}
