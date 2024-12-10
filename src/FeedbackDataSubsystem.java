import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDataSubsystem {
    private List<Feedback> feedbackList;
    private static final String FILE_NAME = "feedbackData.txt";

    public FeedbackDataSubsystem() {
        feedbackList = new ArrayList<>();
        loadFromFile();
    }

    public void addFeedback(Feedback feedback) {
        feedbackList.add(feedback);
        saveToFile();
    }

    public List<Feedback> getFeedbackForSession(String sessionID) {
        List<Feedback> sessionFeedback = new ArrayList<>();
        for (Feedback feedback : feedbackList) {
            if (sessionID != null && sessionID.equals(feedback.getSessionID())) {
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

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(feedbackList);
        } catch (IOException e) {
            System.err.println("Error saving feedback data: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            feedbackList = (ArrayList<Feedback>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Feedback data file not found, starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading feedback data: " + e.getMessage());
        }
    }
}
