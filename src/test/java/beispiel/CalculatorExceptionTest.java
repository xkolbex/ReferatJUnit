package beispiel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorExceptionTest {
    // Erstellt eine Instanz der Calculator-Klasse, um die Methode zu testen
    Calculator calculator = new Calculator();

    @Test
    void testDivisionByZero() {
        // Testet, ob bei Division durch mull eine ArithmeticException mit der erwarteten Nachricht geworfen wird
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(5, 0)
        );
        // Überprüft, ob die erwartete Nachricht in der Ausnahme enthalten ist
        assertEquals("Division durch Null!", exception.getMessage());
    }
}