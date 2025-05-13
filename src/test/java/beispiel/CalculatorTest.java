package beispiel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("Addition von zwei Zahlen: 2+2=4")
    @Test
    void testadd() {
        int sum = calculator.add(2,2);
        assertEquals(4, sum);
    }

    @DisplayName("Subtraktion von zwei Zahlen: 8-6=2")
    @Test
    void testsubtract() {
        int dif = calculator.subtract(8,6);
        assertEquals(2, dif);
    }
}