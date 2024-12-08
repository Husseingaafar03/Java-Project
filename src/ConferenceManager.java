public class ConferenceManager {
    private ConferenceDataSubsystem conferenceDataSubsystem;
    private AttendanceDataSubsystem attendanceDataSubsystem;
    private ConferenceView view;
    private CertificateGenerationSubsystem certificateGenerationSubsystem;
    private AttendanceTrackingSubsystem attendanceTrackingSubsystem;

    public ConferenceManager() {
        this.conferenceDataSubsystem = new ConferenceDataSubsystem();
        this.attendanceDataSubsystem = new AttendanceDataSubsystem();
        this.view = new ConferenceView();
        this.certificateGenerationSubsystem = new CertificateGenerationSubsystem(attendanceDataSubsystem, view);
        this.attendanceTrackingSubsystem = new AttendanceTrackingSubsystem(attendanceDataSubsystem, view);
    }

    public void createConference(String conferenceID, String name, String startDate, String endDate) {
        Conference conference = new Conference(conferenceID, name, startDate, endDate);
        conferenceDataSubsystem.addConference(conference);
    }

    public void addAttendeeToConference(String conferenceID, Attendee attendee) {
        Conference conference = conferenceDataSubsystem.getConference(conferenceID);
        if (conference != null) {
            conference.addAttendee(attendee);
        }
    }

    public void addSessionToConference(String conferenceID, Session session) {
        Conference conference = conferenceDataSubsystem.getConference(conferenceID);
        if (conference != null) {
            conference.addSession(session);
        }
    }

    public void addSpeakerToConference(String conferenceID, Speaker speaker) {
        Conference conference = conferenceDataSubsystem.getConference(conferenceID);
        if (conference != null) {
            conference.addSpeaker(speaker);
        }
    }

    public void markAttendance(String attendeeID, String sessionID) {
        attendanceTrackingSubsystem.markAttendance(attendeeID, sessionID);
    }

    public void generateCertificate(String attendeeID, String attendeeName, String sessionID, String sessionName) {
        certificateGenerationSubsystem.generateCertificate(attendeeID, attendeeName, sessionID, sessionName);
    }

    public void showConferenceDetails(String conferenceID) {
        Conference conference = conferenceDataSubsystem.getConference(conferenceID);
        if (conference != null) {
            ConferenceController controller = new ConferenceController(conference, view);
            controller.updateView();
        }
    }

    public Conference getConference(String conferenceID) {
        return conferenceDataSubsystem.getConference(conferenceID);
    }
}
