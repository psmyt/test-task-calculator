enum Format {
    ROMAN(new Roman()),
    ARABIC(new Arabic());

    private final Formatter formatter;
    Format(Formatter formatter) {
        this.formatter = formatter;
    }

    public boolean validate(String input) {
        return formatter.validator().test(input);
    }

    public int parse(String input) {
        return formatter.parser().apply(input);
    }

    public String print(int value) {
        return formatter.printer().apply(value);
    }

    public boolean isDefinedFor(int value) {
        return formatter.definition().test(value);
    }
}
