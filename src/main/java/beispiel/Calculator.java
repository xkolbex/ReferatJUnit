package beispiel;

public class Calculator {
    // Teilt zwei Zahlen. Wirft eine ArithmeticException, wenn durch 0 geteilt wird
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division durch Null!");
        }
        return a / b;
    }

    // Addiert zwei Ganzzahlen und gibt das Ergebnis zurück
    public int add(int a, int b) {
        return a + b;
    }

    // Subtrahiert b von a und gibt das Ergebnis zurück
    public int subtract(int a, int b) {
        return a - b;
    }
}
