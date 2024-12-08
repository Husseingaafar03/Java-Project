import java.util.HashMap;
import java.util.Map;

public class UserDataSubsystem {
    private Map<String, Attendee> attendeeMap;
    private Map<String, Speaker> speakerMap;

    public UserDataSubsystem() {
        attendeeMap = new HashMap<>();
        speakerMap = new HashMap<>();
    }

    // Add a new attendee
    public void addAttendee(Attendee attendee) {
        attendeeMap.put(attendee.getAttendeeID(), attendee);
    }

    // Get an attendee by their ID
    public Attendee getAttendee(String attendeeID) {
        return attendeeMap.get(attendeeID);
    }

    // Update an existing attendee
    public void updateAttendee(String attendeeID, Attendee updatedAttendee) {
        if (attendeeMap.containsKey(attendeeID)) {
            attendeeMap.put(attendeeID, updatedAttendee);
        }
    }

    // Remove an attendee by their ID
    public void removeAttendee(String attendeeID) {
        attendeeMap.remove(attendeeID);
    }

    // Add a new speaker
    public void addSpeaker(Speaker speaker) {
        speakerMap.put(speaker.getSpeakerID(), speaker);
    }

    // Get a speaker by their ID
    public Speaker getSpeaker(String speakerID) {
        return speakerMap.get(speakerID);
    }

    // Update an existing speaker
    public void updateSpeaker(String speakerID, Speaker updatedSpeaker) {
        if (speakerMap.containsKey(speakerID)) {
            speakerMap.put(speakerID, updatedSpeaker);
        }
    }

    // Remove a speaker by their ID
    public void removeSpeaker(String speakerID) {
        speakerMap.remove(speakerID);
    }

}