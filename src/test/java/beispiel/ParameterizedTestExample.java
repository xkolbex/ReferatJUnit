package beispiel;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ParameterizedTestExample {
    // Parameterized Test mit JUnit 5
    @ParameterizedTest
    @ValueSource(ints = {4, 2, 3})
    void testIsPositive(int number) {
        // Teste, ob die Zahl positiv ist
        assertTrue(number > 0);
    }
}
