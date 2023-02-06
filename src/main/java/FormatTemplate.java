import java.util.function.Function;
import java.util.function.Predicate;

interface FormatTemplate {

    public Predicate<String> validator();

    public Function<String, Integer> parser();

    public Function<Integer, String> printer();

    public Predicate<Integer> definition();

}
