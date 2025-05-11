package beispiel;

public class UserService {
    private final DatabaseService databaseService;

    public UserService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public String getUserName(int userId) {
        return databaseService.findUser(userId).getName();
    }
}
