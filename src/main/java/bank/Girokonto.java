package bank;

public class Girokonto {
    private String kontonummer;
    private double kontostand;
    private double kredit;

    // Konstruktor für das Girokonto, prüft ob der Kredit negativ ist
    public Girokonto(String kontonummer, double kontostand, double kredit) {
        if (kredit < 0) {
            throw new IllegalArgumentException("Kredit darf nicht negativ sein.");
        }
        this.kontonummer = kontonummer;
        this.kontostand = kontostand;
        this.kredit = kredit;
    }
    // Getter-Methoden für die Attribute
    public String getKontonummer() {
        return kontonummer;
    }
    public double getKontostand() {
        return kontostand;
    }
    public double getKredit() {
        return kredit;
    }

    // Abhebung eines Betrags, prüft, ob der Betrag innerhalb des Limits (Kontostand + Kredit) liegt
    public boolean abheben(double betrag) {
        if (betrag < 0) {
            throw new IllegalArgumentException("Betrag darf nicht negativ sein.");
        }
        if (betrag <= kontostand + kredit) {
            kontostand -= betrag;
            return true;
        }
        return false;
    }

    // Einzahlung eines Betrags auf das Konto
    public void einzahlen(double betrag) {
        if (betrag < 0) {
            throw new IllegalArgumentException("Einzahlbetrag darf nicht negativ sein.");
        }
        kontostand += betrag;
    }
}
