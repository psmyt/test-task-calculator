import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line;
            while (!(line = scanner.nextLine()).equals("exit")) {
                System.out.println(calc(line));
            }
        }
    }

    public static String calc(String input) {
        String[] split = input.split(" ");
        if (split.length != 3)
            throw new IllegalArgumentException("unexpected number of members in expression");
        NumberWithFormat a = new NumberWithFormat(split[0]);
        NumberWithFormat b = new NumberWithFormat(split[2]);
        validate(a, b);
        Operation operation = new Operation(split[1]);
        return operation.apply(a, b).print();
    }

    private static void validate(NumberWithFormat a, NumberWithFormat b) {
        List<String> outOfRange = Stream.of(a, b)
                .filter(num -> num.value > 10 || num.value <= 0)
                .map(NumberWithFormat::print)
                .toList();
        if (outOfRange.size() > 0) throw new IllegalArgumentException(
                String.format("input %s is outside the allowed range",
                        String.join(",", outOfRange)));
    }
}
