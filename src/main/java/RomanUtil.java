import java.util.*;

class RomanUtil {
    private static final SortedMap<Integer, String> LETTER_COMBOS;

    static {
        LETTER_COMBOS = new TreeMap<>(Comparator.reverseOrder());
        LETTER_COMBOS.put(1000, "M");
        LETTER_COMBOS.put(900, "CM");
        LETTER_COMBOS.put(500, "D");
        LETTER_COMBOS.put(400, "CD");
        LETTER_COMBOS.put(100, "C");
        LETTER_COMBOS.put(90, "XC");
        LETTER_COMBOS.put(50, "L");
        LETTER_COMBOS.put(40, "XL");
        LETTER_COMBOS.put(10, "X");
        LETTER_COMBOS.put(9, "IX");
        LETTER_COMBOS.put(5, "V");
        LETTER_COMBOS.put(4, "IV");
        LETTER_COMBOS.put(1, "I");
    }

    public static int fromRoman(String input) {
        StringBuilder builder = new StringBuilder(input);
        int result = 0;
        for (Map.Entry<Integer, String> entry : LETTER_COMBOS.entrySet()) {
            while (builder.indexOf(entry.getValue()) == 0) {
                result += entry.getKey();
                builder.delete(0, entry.getValue().length());
            }
        }
        return result;
    }

    public static String toRoman(int num) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, String> entry : LETTER_COMBOS.entrySet()) {
            while (num / entry.getKey() > 0) {
                builder.append(entry.getValue());
                num -= entry.getKey();
            }
        }
        return builder.toString().toUpperCase();
    }

}
