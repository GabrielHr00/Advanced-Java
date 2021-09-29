import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers_04 {
    public static void main(String[] args) throws IOException {
        String path = "/Users/mac/IdeaProjects/SoftUni/out/production/SoftUni/input.txt";

        FileInputStream reader = new FileInputStream(path);
        Scanner sc = new Scanner(reader);


        while(sc.hasNext()){
            if(sc.hasNextInt()){
                System.out.println(sc.nextInt());
            }
            sc.next();
        }
    }
}
