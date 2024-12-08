import java.util.ArrayList;
import java.util.List;

public class FeedbackDataSubsystem {
    private List<Feedback> feedbackList;

    public FeedbackDataSubsystem() {
        feedbackList = new ArrayList<>();
    }

    public void addFeedback(Feedback feedback) {
        feedbackList.add(feedback);
    }

    public List<Feedback> getFeedbackForSession(String sessionID) {
        List<Feedback> sessionFeedback = new ArrayList<>();
        for (Feedback feedback : feedbackList) {
            if (feedback.getSessionID().equals(sessionID)) {
                sessionFeedback.add(feedback);
            }
        }
        return sessionFeedback;
    }

    public List<Feedback> getFeedbackForAttendee(String attendeeID) {
        List<Feedback> attendeeFeedback = new ArrayList<>();
        for (Feedback feedback : feedbackList) {
            if (feedback.getAttendeeID().equals(attendeeID)) {
                attendeeFeedback.add(feedback);
            }
        }
        return attendeeFeedback;
    }

    public List<Feedback> getAllFeedback() {
        return feedbackList;
    }
}
