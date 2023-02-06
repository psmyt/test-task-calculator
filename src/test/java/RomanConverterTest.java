import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanConverterTest {

    @Test
    public void parseTest() {
        assertEquals(789, RomanConverter.parse("DCCLXXXIX"));
        assertEquals(40, RomanConverter.parse("XL"));
        assertEquals(1904, RomanConverter.parse("MCMIV"));
        assertEquals(2421, RomanConverter.parse("MMCDXXI"));
    }

    @Test
    public void printTest() {
        assertEquals("DCCLXXXIX", RomanConverter.print(789));
        assertEquals("XL", RomanConverter.print(40));
        assertEquals("MCMIV", RomanConverter.print(1904));
        assertEquals("MMCDXXI", RomanConverter.print(2421));
    }
}