import java.util.Arrays;

class NumberWithFormat {
    private final Formatter format;

    final int value;

    NumberWithFormat(Formatter format, int value) {
        if (format.isDefinedFor(value)) this.value = value;
        else throw new IllegalArgumentException(
                String.format("the value of %s is not defined for format %s",
                        value,
                        format.name()));
        this.format = format;
    }

    NumberWithFormat(String input) {
        this.format = Arrays.stream(Formatter.values())
                .filter(f -> f.validate(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("bad format for input %s", input)));
        this.value = format.parse(input);
    }

    public String print() {
        return format.print(value);
    }

    public boolean isSameFormat(NumberWithFormat number) {
        return number.format.equals(this.format);
    }

    public String printFormat() {
        return format.name();
    }

    public Formatter getFormat() {
        return format;
    }

}
