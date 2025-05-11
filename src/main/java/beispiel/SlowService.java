package beispiel;

public class SlowService {
    public void process() throws InterruptedException {
        Thread.sleep(1500); // Simuliert langsame Verarbeitung (1,5 Sekunden)
    }
}
