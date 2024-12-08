import java.util.List;

public class FeedbackProcessingSubsystem {
    private FeedbackDataSubsystem feedbackDataSubsystem;

    public FeedbackProcessingSubsystem(FeedbackDataSubsystem feedbackDataSubsystem) {
        this.feedbackDataSubsystem = feedbackDataSubsystem;
    }

    // Calculate the average rating for a specific session
    public double calculateAverageRatingForSession(String sessionID) {
        List<Feedback> feedbackList = feedbackDataSubsystem.getFeedbackForSession(sessionID);
        if (feedbackList.isEmpty()) {
            return 0.0;
        }
        int totalRating = 0;
        for (Feedback feedback : feedbackList) {
            totalRating += feedback.getRating();
        }
        return (double) totalRating / feedbackList.size();
    }

    // Calculate the average rating provided by an attendee
    public double calculateAverageRatingByAttendee(String attendeeID) {
        List<Feedback> feedbackList = feedbackDataSubsystem.getFeedbackForAttendee(attendeeID);
        if (feedbackList.isEmpty()) {
            return 0.0;
        }
        int totalRating = 0;
        for (Feedback feedback : feedbackList) {
            totalRating += feedback.getRating();
        }
        return (double) totalRating / feedbackList.size();
    }

    // Generate a summary of feedback for a specific session
    public void generateFeedbackSummaryForSession(String sessionID) {
        List<Feedback> feedbackList = feedbackDataSubsystem.getFeedbackForSession(sessionID);
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback available for session ID: " + sessionID);
            return;
        }
        System.out.println("Feedback Summary for Session ID: " + sessionID);
        for (Feedback feedback : feedbackList) {
            System.out.println("Attendee ID: " + feedback.getAttendeeID() + " - Rating: " + feedback.getRating() + " - Comments: " + feedback.getComments());
        }
    }
}