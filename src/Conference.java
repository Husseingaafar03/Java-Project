import java.util.ArrayList;
import java.util.List;

public class Conference {
    private String conferenceID;
    private String name;
    private String startDate;
    private String endDate;
    private List<Session> sessions;
    private List<Attendee> attendees;
    private List<Speaker> speakers;

    public Conference(String conferenceID, String name, String startDate, String endDate) {
        this.conferenceID = conferenceID;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sessions = new ArrayList<>();
        this.attendees = new ArrayList<>();
        this.speakers = new ArrayList<>();
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void addAttendee(Attendee attendee) {
        attendees.add(attendee);
    }

    public void addSpeaker(Speaker speaker) {
        speakers.add(speaker);
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public String getConferenceID() { return conferenceID; }
    public String getName() { return name; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
}
