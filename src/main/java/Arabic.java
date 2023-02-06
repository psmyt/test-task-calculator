import java.util.function.Function;
import java.util.function.Predicate;

class Arabic implements Formatter {
    @Override
    public Predicate<String> validator() {
        return str -> str.matches("^-?[0-9]*$");
    }

    @Override
    public Function<String, Integer> parser() {
        return Integer::parseInt;
    }

    @Override
    public Function<Integer, String> printer() {
        return String::valueOf;
    }

    @Override
    public Predicate<Integer> definition() {
        return x -> true;
    }
}
