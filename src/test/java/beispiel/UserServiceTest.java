package beispiel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private DatabaseService mockDatabase;
    @InjectMocks
    private UserService userService;
    @Test
    void testGetUserName() {
        // Arrange: Mock konfigurieren
        when(mockDatabase.findUser(1)).thenReturn(new User("Alice"));
        // Act & Assert
        assertEquals("Alice", userService.getUserName(1));
    }
}
