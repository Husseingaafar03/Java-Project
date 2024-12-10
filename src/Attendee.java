import java.io.Serializable;

public class Attendee implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for Serializable classes

    private String attendeeID;
    private String name;
    private String email;
    private String username;
    private String password;

    public Attendee(String attendeeID, String name, String email, String username, String password) {
        this.attendeeID = attendeeID;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAttendeeID() {
        return attendeeID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
