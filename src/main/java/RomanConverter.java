import java.util.*;

class RomanConverter {
    private static final SortedMap<Integer, String> ALL_COMBOS;

    static {
        ALL_COMBOS = new TreeMap<>(Comparator.reverseOrder());
        ALL_COMBOS.put(1000, "M");
        ALL_COMBOS.put(900, "CM");
        ALL_COMBOS.put(500, "D");
        ALL_COMBOS.put(400, "CD");
        ALL_COMBOS.put(100, "C");
        ALL_COMBOS.put(90, "XC");
        ALL_COMBOS.put(50, "L");
        ALL_COMBOS.put(40, "XL");
        ALL_COMBOS.put(10, "X");
        ALL_COMBOS.put(9, "IX");
        ALL_COMBOS.put(5, "V");
        ALL_COMBOS.put(4, "IV");
        ALL_COMBOS.put(1, "I");
    }

    public static int parse(String input) {
        StringBuilder builder = new StringBuilder(input);
        int result = 0;
        for (Map.Entry<Integer, String> entry : ALL_COMBOS.entrySet()) {
            while (builder.indexOf(entry.getValue()) == 0) {
                result += entry.getKey();
                builder.delete(0, entry.getValue().length());
            }
        }
        return result;
    }

    public static String print(int num) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, String> entry : ALL_COMBOS.entrySet()) {
            while (num / entry.getKey() > 0) {
                builder.append(entry.getValue());
                num -= entry.getKey();
            }
        }
        return builder.toString();
    }

}
