package beispiel;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ParameterizedTestExample {

    @ParameterizedTest
    @ValueSource(ints = {4, 2, 3})
    void testIsPositive(int number) {
        assertTrue(number > 0);
    }
}
