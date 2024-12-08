public class CertificateGenerationSubsystem {
    private AttendanceDataSubsystem attendanceData;
    private ConferenceView view;

    public CertificateGenerationSubsystem(AttendanceDataSubsystem attendanceData, ConferenceView view) {
        this.attendanceData = attendanceData;
        this.view = view;
    }

    public void generateCertificate(String attendeeID, String attendeeName, String sessionID, String sessionName) {
        if (attendanceData.isAttendeePresent(attendeeID, sessionID)) {
            view.printCertificate(attendeeName, sessionName);
        } else {
            System.out.println("Certificate cannot be generated. Attendee did not attend the session.");
        }
    }
}
