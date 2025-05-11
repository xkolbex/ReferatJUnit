package beispiel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;


class SlowServiceTest {
    @Test
    // Timeout für den Test auf 2 Sekunden setzen
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
        // Testet, ob die Methode process() innerhalb von Timeout abgeschlossen wird
    void testProcess() throws InterruptedException {
        SlowService service = new SlowService();
        service.process();
    }
}