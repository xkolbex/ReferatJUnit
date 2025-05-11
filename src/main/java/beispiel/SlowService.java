package beispiel;

public class SlowService {
    // Simuliert einen langsamen Prozess durch eine Pause von xxxx Millisekunden
    public void process() throws InterruptedException {
        Thread.sleep(1500);
    }
}
