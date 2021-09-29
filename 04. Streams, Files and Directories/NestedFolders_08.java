import java.io.File;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NestedFolders_08 {
    public static void main(String[] args) {
        String path = "/Users/mac/IdeaProjects/SoftUni/src/Files-and-Streams";
        File file = new File(path);

        Deque<File> files = new ArrayDeque<>();
        files.offer(file);

        int count = 0;
        while(!files.isEmpty()){
            File current = files.poll();
            File[] files1 = current.listFiles();
            for (File f : files1) {
                if(f.isDirectory()){
                    files.offer(f);
                }
            }
            count++;
            if(current.isDirectory()){
                System.out.println(current.getName());
            }
        }
        System.out.println(count + " folders");
    }
}
