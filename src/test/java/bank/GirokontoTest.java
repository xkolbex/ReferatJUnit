package bank;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests für die Girokonto-Klasse")
class GirokontoTest {

    private Girokonto konto;

    @BeforeEach
    void setUp() {
        konto = new Girokonto("DE0123456789", 1000.0, 500.0);
    }
    @Test
    @DisplayName("Einzahlen erhöht den Kontostand korrekt")
    void testEinzahlen() {
        konto.einzahlen(300.0);
        assertEquals(1300.0, konto.getKontostand(), 0.001);
    }
    @Test
    @DisplayName("Abheben innerhalb des Limits funktioniert")
    void testAbhebenInnerhalbGrenze() {
        boolean erfolgreich = konto.abheben(1400.0);
        assertAll(
                () -> assertTrue(erfolgreich),
                () -> assertEquals(-400.0, konto.getKontostand(), 0.001)
        );
    }
    @Test
    @DisplayName("Abheben über Limit schlägt fehl")
    void testAbhebenÜberGrenze() {
        boolean erfolgreich = konto.abheben(1600.0);
        assertAll(
                () -> assertFalse(erfolgreich),
                () -> assertEquals(1000.0, konto.getKontostand(), 0.001)
        );
    }
    @ParameterizedTest(name = "Einzahlen mit Betrag: {0}")
    @ValueSource(doubles = {50.0, 150.5, 999.99})
    @DisplayName("Einzahlen mit verschiedenen Beträgen")
    void testEinzahlenMitParametern(double betrag) {
        double vorher = konto.getKontostand();
        konto.einzahlen(betrag);
        assertEquals(vorher + betrag, konto.getKontostand(), 0.001);
    }

    @Test
    @DisplayName("Konstruktor wirft Exception bei negativem Kredit")
    void testKreditNegativeException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Girokonto("DE000", 100, -100);
        });
        assertEquals("Kredit darf nicht negativ sein.", exception.getMessage());
    }

    @Test
    @DisplayName("Einzahlen mit negativem Betrag wirft Exception")
    void testEinzahlenNegativ() {
        assertThrows(IllegalArgumentException.class, () -> konto.einzahlen(-50.0));
    }

    @Test
    @DisplayName("Abheben mit negativem Betrag wirft Exception")
    void testAbhebenNegativ() {
        assertThrows(IllegalArgumentException.class, () -> konto.abheben(-10.0));
    }

    @Test
    @DisplayName("Getter geben korrekte Werte zurück")
    void testGetter() {
        assertAll("Getter prüfen",
                () -> assertEquals("DE0123456789", konto.getKontonummer()),
                () -> assertEquals(1000.0, konto.getKontostand(), 0.001),
                () -> assertEquals(500.0, konto.getKredit(), 0.001)
        );
    }
}
