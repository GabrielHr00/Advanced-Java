import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GetFolderSize_08_EX {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/mac/IdeaProjects/SoftUni/out/production/Exercises Resources");
        File[] files = file.listFiles();
        int sum = 0;

        for (File f : files) {
            sum += f.length();
        }
        System.out.println("Folder size: " + sum);
    }
}
