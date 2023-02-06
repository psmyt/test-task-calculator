enum Format {
    ROMAN(new Roman()),
    ARABIC(new Arabic());

    private final FormatTemplate format;
    Format(FormatTemplate format) {
        this.format = format;
    }

    public boolean validate(String input) {
        return format.validator().test(input);
    }

    public int parse(String input) {
        return format.parser().apply(input);
    }

    public String print(int value) {
        return format.printer().apply(value);
    }

    public boolean isDefinedFor(int value) {
        return format.definition().test(value);
    }
}
