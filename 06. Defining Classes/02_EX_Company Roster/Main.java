import com.sun.jdi.DoubleValue;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Employee> list = new ArrayList<>();
        Map<String, List<Double>> average = new LinkedHashMap<>();

        while(n-- > 0){
            String[] com = sc.nextLine().split("\\s+");

            if(com.length == 4){
                list.add(new Employee(com[0], Double.parseDouble(com[1]), com[2], com[3]));
                average.putIfAbsent(com[3], new ArrayList<>());
                average.get(com[3]).add(Double.parseDouble(com[1]));
            }
            else if(com.length == 5){
                if(com[4].contains("@")){
                    list.add(new Employee(com[0], Double.parseDouble(com[1]), com[2], com[3], com[4]));
                }
                else{
                    list.add(new Employee(com[0], Double.parseDouble(com[1]), com[2], com[3], Integer.parseInt(com[4])));
                }
                average.putIfAbsent(com[3], new ArrayList<>());
                average.get(com[3]).add(Double.parseDouble(com[1]));
            }
            else{
                list.add(new Employee(com[0], Double.parseDouble(com[1]), com[2], com[3], com[4], Integer.parseInt(com[5])));
                average.putIfAbsent(com[3], new ArrayList<>());
                average.get(com[3]).add(Double.parseDouble(com[1]));
            }
        }

        String department = "";
        double max = 0.0;
        for (var e : average.entrySet()){
            double temp = 0.0;
            for (var i : e.getValue()) {
                temp += i;
            }
            temp /= e.getValue().size();
            if(temp > max){
                max = temp;
                department = e.getKey();
            }
        }

        final String department1 = department;
        System.out.println("Highest Average Salary: " + department);
        list.stream()
                .filter(e -> e.getDepartment().equals(department1))
                .sorted((e1,e2) -> Double.compare(e2.getSalary(),e1.getSalary()))
                .forEach(e -> System.out.printf("%s %.2f %s %d%n", e.getName(), e.getSalary(), e.getEmail(), e.getAge()));

    }
}


