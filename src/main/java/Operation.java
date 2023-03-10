import java.util.function.BiFunction;

class Operation {
    private final BiFunction<
            NumberWithFormat,
            NumberWithFormat,
            NumberWithFormat> operation;

    Operation(String input) {
        operation = (a, b) -> {
            if (!a.isSameFormat(b))
                throw new IllegalArgumentException(String.format("format mismatch: %s and %s",
                        a.printFormat(),
                        b.printFormat()));
            return new NumberWithFormat(
                    a.getFormat(),
                    parseOperation(input).apply(a.value, b.value));
        };
    }

    public static BiFunction<Integer, Integer, Integer> parseOperation(String input) {
        switch (input) {
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
            default -> throw new RuntimeException(
                    String.format("unsupported operation \"%s\"", input));
        }
    }

    public NumberWithFormat apply(NumberWithFormat a, NumberWithFormat b) {
        return operation.apply(a, b);
    }
}
