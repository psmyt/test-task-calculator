import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanUtilTest {

    @Test
    public void parseTest() {
        assertEquals(789, RomanUtil.fromRoman("DCCLXXXIX"));
        assertEquals(40, RomanUtil.fromRoman("XL"));
        assertEquals(1904, RomanUtil.fromRoman("MCMIV"));
        assertEquals(2421, RomanUtil.fromRoman("MMCDXXI"));
    }

    @Test
    public void printTest() {
        assertEquals("DCCLXXXIX", RomanUtil.toRoman(789));
        assertEquals("XL", RomanUtil.toRoman(40));
        assertEquals("MCMIV", RomanUtil.toRoman(1904));
        assertEquals("MMCDXXI", RomanUtil.toRoman(2421));
    }
}