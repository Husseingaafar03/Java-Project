import javax.swing.*;
public class Main {
    public static void main(String[] args) {

            // Step 1: Initialize backend subsystems
            UserDataSubsystem userDataSubsystem = new UserDataSubsystem();
            UserManagementSubsystem userManagementSubsystem = new UserManagementSubsystem(userDataSubsystem);

        // Step 2: Add some example data
            userDataSubsystem.addAttendee(new Attendee("attendee1", "John Doe", "johndoe@example.com"));
            userDataSubsystem.addSpeaker(new Speaker("speaker1", "Alice Johnson", "Expert Speaker"));

            // Step 3: Create and display the login form
            JFrame frame = new JFrame("Login Form");
            frame.setContentPane(new LoginForm(userManagementSubsystem).getMainPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);


        // Create a conference manager
        ConferenceManager conferenceManager = new ConferenceManager();

        // Create a session data subsystem
        SessionDataSubsystem sessionDataSubsystem = new SessionDataSubsystem();

        // Create a session management subsystem
        SessionManagementSubsystem sessionManagementSubsystem = new SessionManagementSubsystem(sessionDataSubsystem);

        // Create a conference
        conferenceManager.createConference("C01", "Tech Conference 2024", "2024-12-05", "2024-12-07");

        // Create an attendee
        Attendee attendee = new Attendee("A01", "John Doe", "johndoe@example.com");
        userManagementSubsystem.addAttendee(attendee);

        // Create session models
        Session session1 = new Session("S01", "Java for Beginners", "2024-12-05", "10:00 AM", "Room 101");
        Session session2 = new Session("S02", "Advanced Java Concepts", "2024-12-06", "2:00 PM", "Room 102");

        // Create a speaker
        Speaker speaker = new Speaker("SP01", "Alice Johnson", "Expert in Java and Software Development");
        userManagementSubsystem.addSpeaker(speaker);

        // Add attendee, sessions, and speaker to the conference
        conferenceManager.addAttendeeToConference("C01", attendee);
        conferenceManager.addSessionToConference("C01", session1);
        conferenceManager.addSessionToConference("C01", session2);
        conferenceManager.addSpeakerToConference("C01", speaker);

        // Add sessions to the session data subsystem using session management subsystem
        sessionManagementSubsystem.addSession(session1);
        sessionManagementSubsystem.addSession(session2);

        // Mark attendance for sessions
        conferenceManager.markAttendance(attendee.getAttendeeID(), session1.getSessionID());
        conferenceManager.markAttendance(attendee.getAttendeeID(), session2.getSessionID());

        // Show conference details
        conferenceManager.showConferenceDetails("C01");

        // Generate certificates for sessions
        conferenceManager.generateCertificate(attendee.getAttendeeID(), attendee.getName(), session1.getSessionID(), session1.getName());
        conferenceManager.generateCertificate(attendee.getAttendeeID(), attendee.getName(), session2.getSessionID(), session2.getName());

        // Create a feedback subsystem
        FeedbackDataSubsystem feedbackDataSubsystem = new FeedbackDataSubsystem();

        // Add feedback for sessions
        Feedback feedback1 = new Feedback("F01", attendee.getAttendeeID(), session1.getSessionID(), 5, "Great session, very informative!");
        Feedback feedback2 = new Feedback("F02", attendee.getAttendeeID(), session2.getSessionID(), 4, "Good session, but could use more examples.");
        feedbackDataSubsystem.addFeedback(feedback1);
        feedbackDataSubsystem.addFeedback(feedback2);

        // Retrieve and display feedback for sessions
        System.out.println("\nFeedback for Session 1:");
        for (Feedback feedback : feedbackDataSubsystem.getFeedbackForSession(session1.getSessionID())) {
            System.out.println("Rating: " + feedback.getRating() + " - Comments: " + feedback.getComments());
        }

        System.out.println("\nFeedback for Session 2:");
        for (Feedback feedback : feedbackDataSubsystem.getFeedbackForSession(session2.getSessionID())) {
            System.out.println("Rating: " + feedback.getRating() + " - Comments: " + feedback.getComments());
        }

        // Retrieve and display feedback for the attendee
        System.out.println("\nFeedback provided by Attendee:");
        for (Feedback feedback : feedbackDataSubsystem.getFeedbackForAttendee(attendee.getAttendeeID())) {
            System.out.println("Session ID: " + feedback.getSessionID() + " - Rating: " + feedback.getRating() + " - Comments: " + feedback.getComments());
        }

        // Create a feedback processing subsystem
        FeedbackProcessingSubsystem feedbackProcessingSubsystem = new FeedbackProcessingSubsystem(feedbackDataSubsystem);

        // Calculate and display average ratings for sessions
        System.out.println("\nAverage Rating for Session 1: " + feedbackProcessingSubsystem.calculateAverageRatingForSession(session1.getSessionID()));
        System.out.println("Average Rating for Session 2: " + feedbackProcessingSubsystem.calculateAverageRatingForSession(session2.getSessionID()));

        // Calculate and display average rating given by the attendee
        System.out.println("\nAverage Rating provided by Attendee: " + feedbackProcessingSubsystem.calculateAverageRatingByAttendee(attendee.getAttendeeID()));

        // Generate and display feedback summary for a session
        System.out.println("\nFeedback Summary for Session 1:");
        feedbackProcessingSubsystem.generateFeedbackSummaryForSession(session1.getSessionID());

        // Create a notification subsystem
        NotificationSubsystem notificationSubsystem = new NotificationSubsystem();

        // Send notifications to attendees and speakers
        notificationSubsystem.sendNotificationToAttendee(attendee, "Reminder: The Java for Beginners session starts tomorrow at 10:00 AM.");
        notificationSubsystem.sendNotificationToSpeakers(conferenceManager.getConference("C01").getSpeakers(), "Reminder: Your upcoming sessions at Tech Conference 2024.");
    }
}
