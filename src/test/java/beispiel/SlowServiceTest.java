package beispiel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

class SlowServiceTest {
    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Test darf max. 2 Sekunden dauern
    void testProcess() throws InterruptedException {
        SlowService service = new SlowService();
        service.process(); // Sollte innerhalb von 2 Sekunden passieren
    }
}