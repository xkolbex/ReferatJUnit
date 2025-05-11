package beispiel;

public class UserService {
    private final DatabaseService databaseService;

    // Konstruktor injiziert den DatabaseService
    public UserService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    // Ruft den Benutzernamen eines Users über dessen ID aus dem DatabaseService ab
    public String getUserName(int userId) {
        return databaseService.findUser(userId).getName();
    }
}
