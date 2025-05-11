package beispiel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorExceptionTest {
    Calculator calculator = new Calculator();
    @Test
    void testDivisionByZero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(5, 0)
        );
        assertEquals("Division durch Null!", exception.getMessage());
    }
}