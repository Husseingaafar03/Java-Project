public class ConferenceController {
    private Conference conference;
    private ConferenceView view;

    public ConferenceController(Conference conference, ConferenceView view) {
        this.conference = conference;
        this.view = view;
    }

    public void updateView() {
        for (Attendee attendee : conference.getAttendees()) {
            view.printAttendeeDetails(attendee.getName(), attendee.getEmail());
        }
        for (Session session : conference.getSessions()) {
            view.printSessionDetails(session.getName(), session.getDate(), session.getTime(), session.getRoom());
        }
        for (Speaker speaker : conference.getSpeakers()) {
            view.printSpeakerDetails(speaker.getName(), speaker.getBio());
        }
    }

    public void addSession(Session session) {
        conference.addSession(session);
    }

    public void addAttendee(Attendee attendee) {
        conference.addAttendee(attendee);
    }

    public void addSpeaker(Speaker speaker) {
        conference.addSpeaker(speaker);
    }
}
