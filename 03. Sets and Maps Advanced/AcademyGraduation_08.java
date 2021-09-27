import com.sun.source.tree.Tree;

import java.util.*;

public class AcademyGraduation_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, List<Double>> map = new TreeMap<>();
        while(n-- > 0){
            String name = sc.nextLine();
            double[] grades = Arrays
                    .stream(sc.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            map.putIfAbsent(name, new ArrayList<>());
            for (double s : grades) {
                map.get(name).add(s);
            }
        }

        map.entrySet().stream().forEach(e -> {
            System.out.printf("%s is graduated with %s%n", e.getKey(),
                    getAvg(e.getValue()));
        });

    }

    private static double getAvg(List<Double> value) {
        double avg = 0.0;
        for(Double d : value){
            avg += d;
        }
        avg /= value.size();
        return avg;
    }
}
