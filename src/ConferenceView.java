public class ConferenceView {
    public void printAttendeeDetails(String attendeeName, String attendeeEmail) {
        System.out.println("Attendee: " + attendeeName);
        System.out.println("Email: " + attendeeEmail);
    }

    public void printSessionDetails(String sessionName, String date, String time, String room) {
        System.out.println("Session: " + sessionName);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Room: " + room);
    }

    public void printSpeakerDetails(String speakerName, String bio) {
        System.out.println("Speaker: " + speakerName);
        System.out.println("Bio: " + bio);
    }

    public void printFeedbackDetails(String attendeeID, String sessionID, int rating, String comments) {
        System.out.println("Feedback from Attendee ID: " + attendeeID);
        System.out.println("Session ID: " + sessionID);
        System.out.println("Rating: " + rating);
        System.out.println("Comments: " + comments);
    }
    public void printAttendanceStatus(String attendeeID, String sessionID, boolean isPresent) {
        System.out.println("Attendance Status for Attendee ID: " + attendeeID + " in Session ID: " + sessionID + " - " + (isPresent ? "Present" : "Absent"));
    }
    public void printCertificate(String attendeeName, String sessionName) {
        System.out.println("Certificate of Attendance");
        System.out.println("Attendee: " + attendeeName);
        System.out.println("Session: " + sessionName);
        System.out.println("Congratulations on your participation!");
    }
}
