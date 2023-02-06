import java.util.function.Function;
import java.util.function.Predicate;

public class RomanFormat implements Format {

    @Override
    public Predicate<String> validator() {
        return str -> str.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
    }

    @Override
    public Function<String, Integer> parser() {
        return RomanConverter::parse;
    }

    @Override
    public Function<Integer, String> printer() {
        return RomanConverter::print;
    }

    @Override
    public Predicate<Integer> definition() {
        return x -> x > 0;
    }
}
