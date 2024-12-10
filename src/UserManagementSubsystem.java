public class UserManagementSubsystem {
    public UserDataSubsystem getUserDataSubsystem() {
        return userDataSubsystem;
    }

    private UserDataSubsystem userDataSubsystem;

    public UserManagementSubsystem(UserDataSubsystem userDataSubsystem) {
        this.userDataSubsystem = userDataSubsystem;
    }

    // Add a new attendee
    public void addAttendee(Attendee attendee) {
        userDataSubsystem.addAttendee(attendee);
        System.out.println("Attendee added: " + attendee.getName());
    }

    // Update an existing attendee
    public void updateAttendee(String attendeeID, Attendee updatedAttendee) {
        userDataSubsystem.updateAttendee(attendeeID, updatedAttendee);
        System.out.println("Attendee updated: " + updatedAttendee.getName());
    }

    // Remove an attendee by their ID
    public void removeAttendee(String attendeeID) {
        userDataSubsystem.removeAttendee(attendeeID);
        System.out.println("Attendee removed with ID: " + attendeeID);
    }

    // Add a new speaker
    public void addSpeaker(Speaker speaker) {
        userDataSubsystem.addSpeaker(speaker);
        System.out.println("Speaker added: " + speaker.getName());
    }

    // Update an existing speaker
    public void updateSpeaker(String speakerID, Speaker updatedSpeaker) {
        userDataSubsystem.updateSpeaker(speakerID, updatedSpeaker);
        System.out.println("Speaker updated: " + updatedSpeaker.getName());
    }

    // Remove a speaker by their ID
    public void removeSpeaker(String speakerID) {
        userDataSubsystem.removeSpeaker(speakerID);
        System.out.println("Speaker removed with ID: " + speakerID);
    }
    public boolean authenticateUser(String userType, String username, String password) {
        switch (userType.toLowerCase()) {
            case "attendee":
                Attendee attendee = userDataSubsystem.getAttendeeByUsername(username);
                return attendee != null && attendee.getPassword().equals(password);

            case "speaker":
                Speaker speaker = userDataSubsystem.getSpeakerByUsername(username);
                return speaker != null && speaker.getPassword().equals(password);

            case "admin":
                // Admin login logic
                return "admin".equals(username) && "password".equals(password);

            default:
                return false;
        }
    }
}
