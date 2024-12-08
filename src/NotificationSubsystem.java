import java.util.List;

public class NotificationSubsystem {
    // Method to send notifications to attendees
    public void sendNotificationToAttendees(List<Attendee> attendees, String message) {
        for (Attendee attendee : attendees) {
            System.out.println("Notification to " + attendee.getName() + " (Email: " + attendee.getEmail() + "): " + message);
        }
    }

    // Method to send notifications to speakers
    public void sendNotificationToSpeakers(List<Speaker> speakers, String message) {
        for (Speaker speaker : speakers) {
            System.out.println("Notification to " + speaker.getName() + ": " + message);
        }
    }

    // Method to send a notification to a specific attendee
    public void sendNotificationToAttendee(Attendee attendee, String message) {
        System.out.println("Notification to " + attendee.getName() + " (Email: " + attendee.getEmail() + "): " + message);
    }

    // Method to send a notification to a specific speaker
    public void sendNotificationToSpeaker(Speaker speaker, String message) {
        System.out.println("Notification to " + speaker.getName() + ": " + message);
    }
}
