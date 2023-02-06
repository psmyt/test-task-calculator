import java.util.Arrays;

class NumberWithFormat {
    private final Format format;

    final int value;

    NumberWithFormat(Format format, int value) {
        if (format.isDefinedFor(value)) this.value = value;
        else throw new IllegalArgumentException(
                String.format("format %s is not defined for the value of %s",
                        format.name(),
                        value));
        this.format = format;
    }

    NumberWithFormat(String input) {
        this.format = Arrays.stream(Format.values())
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

    public Format getFormat() {
        return format;
    }

}
