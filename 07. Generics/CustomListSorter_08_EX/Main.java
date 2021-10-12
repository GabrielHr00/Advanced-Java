import javax.crypto.CipherInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();

        CustomList<String> list = new CustomList<>();

        while(!n.equals("END")){
            String[] com= n.split("\\s+");
            switch(com[0]){
                case "Add":
                    list.add(com[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(com[1]));
                    break;
                case "Contains":
                    if (list.contains(com[1])) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                    break;
                case "Swap":
                    int in1 = Integer.parseInt(com[1]);
                    int in2 = Integer.parseInt(com[2]);
                    list.swap(in1, in2);
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(com[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
                case "Print":
                    list.printsAll();
                    break;
            }

            n = sc.nextLine();
        }

    }
}