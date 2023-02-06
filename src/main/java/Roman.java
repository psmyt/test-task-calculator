import java.util.function.Function;
import java.util.function.Predicate;

class Roman implements FormatTemplate {

    @Override
    public Predicate<String> validator() {
        return str -> str.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
    }

    @Override
    public Function<String, Integer> parser() {
        return RomanUtil::fromRoman;
    }

    @Override
    public Function<Integer, String> printer() {
        return RomanUtil::toRoman;
    }

    @Override
    public Predicate<Integer> definition() {
        return x -> x > 0;
    }
}
