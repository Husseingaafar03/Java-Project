public class Attendee {
    private String attendeeID;
    private String name;
    private String email;

    public Attendee(String attendeeID, String name, String email) {
        this.attendeeID = attendeeID;
        this.name = name;
        this.email = email;
    }

    public String getAttendeeID() { return attendeeID; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}