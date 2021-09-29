import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes_03 {
    public static void main(String[] args) throws IOException {
        String path = "/Users/mac/IdeaProjects/SoftUni/out/production/SoftUni/input.txt";

        FileInputStream reader = new FileInputStream(path);
        FileOutputStream writer = new FileOutputStream("out2.txt");

        int value = reader.read();
        while(value != -1){
            if(value == 10 || value == 32){
                writer.write(value);
            }
            else{
                String current = String.valueOf(value);
                for (var s : current.toCharArray()) {
                    writer.write(s);
                }
            }
            value = reader.read();
        }
        writer.write(value);

    }
}
