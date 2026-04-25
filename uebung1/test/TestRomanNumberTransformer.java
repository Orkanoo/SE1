package uebung1.test;

import org.junit.jupiter.api.Test;
import uebung1.businesslogic.RomanNumberTransformer;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestRomanNumberTransformer {

    private RomanNumberTransformer transformer = new RomanNumberTransformer();

    private static final String ERROR_MESSAGE = "Fehler: Es sind nur Zahlen zwischen 1 und 3000 erlaubt.";

    @Test

    void testRomanNumbersValidValues() {
        assertEquals("I", transformer.transformNumber(1));
        assertEquals("IV", transformer.transformNumber(4));
        assertEquals("MMM", transformer.transformNumber(3000));
    }

    @Test

    void testRomanNumbers() {
        assertEquals(ERROR_MESSAGE, transformer.transformNumber(0));
        assertEquals(ERROR_MESSAGE, transformer.transformNumber(-1));
        assertEquals(ERROR_MESSAGE, transformer.transformNumber(3001));
        assertEquals(ERROR_MESSAGE, transformer.transformNumber(5000));
    }

}