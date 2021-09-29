import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class WriteToFile_02 {
    public static void main(String[] args) throws IOException {
        String path = "/Users/mac/IdeaProjects/SoftUni/out/production/SoftUni/input.txt";

        FileInputStream input = new FileInputStream(path);
        FileOutputStream write = new FileOutputStream("out1.txt");

        Set<Character> set = Set.of( ',', '.', '!', '?');
        int value = input.read();

        while(value != -1){
            if(!set.contains((char)value)){
                write.write((char) value);
            }
            value = input.read();
        }
    }
}
