import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> line = Arrays.stream(sc.nextLine().split(", ")).map(Double::parseDouble).collect(Collectors.toList());
        UnaryOperator<Double> vat = e -> e * 1.20;
        System.out.println("Prices with VAT:");
        line.stream().map(e -> vat.apply(e)).forEach(e -> System.out.printf("%.2f%n", e));

    }
}