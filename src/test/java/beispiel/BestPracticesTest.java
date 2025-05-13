package beispiel;

import bank.Girokonto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BestPracticesTest {
    //Testnamen
    @Test
    @DisplayName("Addiert zwei positive Zahlen: 4+5=9")
    void testAdd_PositiveNumbers() {
        // AAA-Pattern: Arrange, Act, Assert
        // Arrange
        Calculator calc = new Calculator();
        int a = 4;
        int b = 5;
        // Act
        int result = calc.add(a, b);
        // Assert
        assertEquals(9, result);
    }

    // schlecht: Statischer Zustand
    static Girokonto girokonto1 = new Girokonto("DE12648567890", 1000, 500);

    @Test
    void testeinzahlenfalsch() {
        // Beeinflusst andere Tests
        girokonto.einzahlen(50);
    }

    // gut: neues Objekt für jeden Test
    private Girokonto konto1;
    @BeforeEach
    void init() {
        konto = new Girokonto("DE12648567890", 1000, 500);
    }

    @Test
    void testeinzahlenrichtig() {
        // Beeinflusst keine andere Tests
        konto.einzahlen(50);
    }

    static Girokonto girokonto = new Girokonto("DE12648567890", 1000, 500);

    @Test
    void testeinzahlenohnesetup() {
        girokonto.einzahlen(50);
    }

    private Girokonto konto;
    @BeforeEach
    void setup() {
        konto = new Girokonto("DE12648567890", 1000, 500);
    }

    @Test
    void testeinzahlenmitsetup() {
        konto.einzahlen(50);
    }
}


