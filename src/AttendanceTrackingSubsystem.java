public class AttendanceTrackingSubsystem {
    private AttendanceDataSubsystem attendanceData;
    private ConferenceView view;

    public AttendanceTrackingSubsystem(AttendanceDataSubsystem attendanceData, ConferenceView view) {
        this.attendanceData = attendanceData;
        this.view = view;
    }

    public void markAttendance(String attendeeID, String sessionID) {
        if (attendeeID == null || sessionID == null) {
            System.out.println("Invalid attendeeID or sessionID.");
            return;
        }
        attendanceData.markAttendance(attendeeID, sessionID);
        System.out.println("Attendance marked for Attendee ID: " + attendeeID + " in Session ID: " + sessionID);
    }


    public void checkAttendance(String attendeeID, String sessionID) {
        boolean isPresent = attendanceData.isAttendeePresent(attendeeID, sessionID);
        view.printAttendanceStatus(attendeeID, sessionID, isPresent);
    }
}
