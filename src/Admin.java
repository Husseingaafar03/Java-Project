public class Admin {
    private String adminID;
    private String name;
    private String username;
    private String password;

    public Admin(String adminID, String name, String username, String password) {
        this.adminID = adminID;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getAdminID() {
        return adminID;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
