package bank;

public class Girokonto {
    private String kontonummer;
    private double kontostand;
    private double kredit;

    public Girokonto(String kontonummer, double kontostand, double kredit) {
        if (kredit < 0) {
            throw new IllegalArgumentException("Kredit darf nicht negativ sein.");
        }
        this.kontonummer = kontonummer;
        this.kontostand = kontostand;
        this.kredit = kredit;
    }
    public String getKontonummer() {
        return kontonummer;
    }
    public double getKontostand() {
        return kontostand;
    }
    public double getKredit() {
        return kredit;
    }

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
    public void einzahlen(double betrag) {
        if (betrag < 0) {
            throw new IllegalArgumentException("Einzahlbetrag darf nicht negativ sein.");
        }
        kontostand += betrag;
    }
}
