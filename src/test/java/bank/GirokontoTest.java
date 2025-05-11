package bank;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests für die Girokonto-Klasse")
class GirokontoTest {

    private Girokonto konto;

    // Vor jedem Test wird ein neues Girokonto erstellt
    @BeforeEach
    void setUp() {
        konto = new Girokonto("DE0123456789", 1000.0, 500.0);
    }

    @Test
    @DisplayName("Einzahlen erhöht den Kontostand korrekt")
    void testEinzahlen() {
        konto.einzahlen(300.0);
        // Testet, ob die Einzahlung den Kontostand korrekt erhöht
        assertEquals(1300.0, konto.getKontostand(), 0.001);
    }

    @Test
    @DisplayName("Abheben innerhalb des Limits funktioniert")
    void testAbhebenInnerhalbGrenze() {
        boolean erfolgreich = konto.abheben(1400.0);
        // Testet, ob eine Abhebung innerhalb des Kredit- und Kontostandlimits erfolgreich ist
        assertAll(
                () -> assertTrue(erfolgreich),
                () -> assertEquals(-400.0, konto.getKontostand(), 0.001)
        );
    }

    @Test
    @DisplayName("Abheben über Limit schlägt fehl")
    void testAbhebenÜberGrenze() {
        boolean erfolgreich = konto.abheben(1600.0);
        // Testet, ob eine Abhebung, die das Limit überschreitet, fehlschlägt
        assertAll(
                () -> assertFalse(erfolgreich),
                () -> assertEquals(1000.0, konto.getKontostand(), 0.001)
        );
    }

    // Testet die Einzahlung mit verschiedenen Beträgen
    @ParameterizedTest(name = "Einzahlen mit Betrag: {0}")
    @ValueSource(doubles = {50.0, 150.5, 999.99})
    @DisplayName("Einzahlen mit verschiedenen Beträgen")
    void testEinzahlenMitParametern(double betrag) {
        double vorher = konto.getKontostand();
        konto.einzahlen(betrag);
        // Testet, ob die Einzahlung den Kontostand korrekt erhöht
        assertEquals(vorher + betrag, konto.getKontostand(), 0.001);
    }

    @Test
    @DisplayName("Konstruktor wirft Exception bei negativem Kredit")
    void testKreditNegativeException() {
        // Testet, ob der Konstruktor eine Exception wirft, wenn der Kredit negativ ist
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Girokonto("DE000", 100, -100);
        });
        assertEquals("Kredit darf nicht negativ sein.", exception.getMessage());
    }

    @Test
    @DisplayName("Einzahlen mit negativem Betrag wirft Exception")
    void testEinzahlenNegativ() {
        // Testet, ob beim Versuch, einen negativen Betrag einzuzahlen, eine Exception geworfen wird
        assertThrows(IllegalArgumentException.class, () -> konto.einzahlen(-50.0));
    }

    @Test
    @DisplayName("Abheben mit negativem Betrag wirft Exception")
    void testAbhebenNegativ() {
        // Testet, ob beim Versuch, einen negativen Betrag abzuheben, eine Exception geworfen wird
        assertThrows(IllegalArgumentException.class, () -> konto.abheben(-10.0));
    }

    @Test
    @DisplayName("Getter geben korrekte Werte zurück")
    void testGetter() {
        // Testet, ob die Getter-Methoden die richtigen Werte zurückgeben
        assertAll("Getter prüfen",
                () -> assertEquals("DE0123456789", konto.getKontonummer()),
                () -> assertEquals(1000.0, konto.getKontostand(), 0.001),
                () -> assertEquals(500.0, konto.getKredit(), 0.001)
        );
    }
}
