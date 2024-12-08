public class Feedback {
    private String feedbackID;
    private String attendeeID;
    private String sessionID;
    private int rating;
    private String comments;

    public Feedback(String feedbackID, String attendeeID, String sessionID, int rating, String comments) {
        this.feedbackID = feedbackID;
        this.attendeeID = attendeeID;
        this.sessionID = sessionID;
        this.rating = rating;
        this.comments = comments;
    }

    public String getFeedbackID() { return feedbackID; }
    public String getAttendeeID() { return attendeeID; }
    public String getSessionID() { return sessionID; }
    public int getRating() { return rating; }
    public String getComments() { return comments; }
}