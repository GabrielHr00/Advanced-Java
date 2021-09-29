import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile_01 {
    public static void main(String[] args) throws IOException {
        String path = "/Users/mac/IdeaProjects/SoftUni/out/production/SoftUni/input.txt";

        FileInputStream input = new FileInputStream(path);
        int value = input.read();
        while(value != -1){
            System.out.print(Integer.toBinaryString(value) + " ");
            value = input.read();
        }

    }
}
