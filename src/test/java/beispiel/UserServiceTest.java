package beispiel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

// Aktiviert die Unterstützung für Mockito in JUnit 5
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    // Erzeugt ein Mock-Objekt des DatabaseService
    @Mock
    private DatabaseService mockDatabase;

    // Erstellt eine Instanz von UserService und injiziert automatisch das Mock-Objekt
    @InjectMocks
    private UserService userService;

    @Test
    void testGetUserName() {
        // Arrange: Mock konfigurieren
        when(mockDatabase.findUser(1)).thenReturn(new User("Alice"));
        // Act & Assert: Methode aufrufen und prüfen, ob "Alice" zurückgegeben wird
        assertEquals("Alice", userService.getUserName(1));
    }
}
