import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Predicate;

class Utils {
    private final FormatDELETE format;

    private final int a;

    private final int b;
    private final BiFunction<Integer, Integer, Integer> operation;

    public static Set<String> SUPPORTED_OPERATIONS = Set.of("-", "+", "/", "*");

    public final static Predicate<String> ROMAN_VALIDATOR = str -> str.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
    public final static Predicate<String> ARABIC_VALIDATOR = str -> str.matches("^-?[0-9]*$");

    Utils(String input)  {
        String[] split = input.split(" ");
        if (split.length != 3)
            throw new RuntimeException("could not parse expression");
        this.operation = parseOperation(split[1]);
        FormatDELETE formatA = analyzeFormat(split[0]);
        FormatDELETE formatB = analyzeFormat(split[2]);
        if (!formatA.equals(formatB))
            throw new RuntimeException("format mismatch");
        this.format = formatA;
        this.a = parseNumber(split[0]);
        this.b = parseNumber(split[2]);
    }
    public BiFunction<Integer, Integer, Integer> parseOperation(String operation) {
        switch (operation) {
            case "+" -> {
                return Integer::sum;
            }
            case "-" -> {
                return (x, y) -> x - y;
            }
            case "*" -> {
                return (x, y) -> x * y;
            }
            case "/" -> {
                return (x, y) -> x / y;
            }
            default -> throw new RuntimeException("unsupported operation");
        }
    }

    FormatDELETE analyzeFormat(String input) {
        FormatDELETE format = ROMAN_VALIDATOR.test(input) ? FormatDELETE.ROMAN :
                ARABIC_VALIDATOR.test(input) ? FormatDELETE.ARABIC
                        : null;
        if (format == null) throw new RuntimeException("bad format");
        return format;
    }

    static boolean testNumberInput(String input) {
        return ROMAN_VALIDATOR.test(input) || ARABIC_VALIDATOR.test(input);
    }

    private int parseNumber(String a) {
        return format.equals(FormatDELETE.ARABIC) ? parseArabic(a) : parseRoman(a);
    }

    static int parseArabic(String input) {
        int parsed = Integer.parseInt(input);
        if (parsed < 0 || parsed > 10) throw new RuntimeException("out of range");
        return parsed;
    }

    static int parseRoman(String input) {
        return RomanConverter.parse(input);
    }

}