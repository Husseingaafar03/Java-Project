import java.io.Serializable; //The Serializable interface is required to serialize objects to a file and deserialize them back.

public class Speaker implements Serializable {
    private static final long serialVersionUID = 1L;

    private String speakerID;
    private String name;
    private String bio;
    private String username;
    private String password;

    public Speaker(String speakerID, String name, String bio, String username, String password) {
        this.speakerID = speakerID;
        this.name = name;
        this.bio = bio;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSpeakerID() {
        return speakerID;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }
}
