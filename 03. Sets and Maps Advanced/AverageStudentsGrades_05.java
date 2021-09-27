import java.util.*;

public class AverageStudentsGrades_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, List<Double>> map = new TreeMap<>();
        while(n-- > 0){
         String[] com = sc.nextLine().split("\\s+");
         String name = com[0];
         double grade = Double.parseDouble(com[1]);

         map.putIfAbsent(name, new ArrayList<>());
         map.get(name).add(grade);
        }

        map.entrySet().stream().forEach(e -> {
            System.out.print(e.getKey() + " -> " );
            e.getValue().stream().forEach(entry -> System.out.printf("%.2f ", entry));
            double av = 0.0;
            for (var i : e.getValue()) {
                av += i;
            }
            av = av / e.getValue().size();
            System.out.printf("(avg: %.2f)",av);
            System.out.println();
        });

    }
}
