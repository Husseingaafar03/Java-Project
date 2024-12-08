import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserDataSubsystem {
    private Map<String, Attendee> attendeeMap;
    private Map<String, Speaker> speakerMap;
    private static final String FILE_NAME = "userData.txt";

    public UserDataSubsystem() {
        attendeeMap = new HashMap<>();
        speakerMap = new HashMap<>();
        loadFromFile();
    }

    public void addAttendee(Attendee attendee) {
        attendeeMap.put(attendee.getAttendeeID(), attendee);
        saveToFile();
    }

    public Attendee getAttendee(String attendeeID) {
        return attendeeMap.get(attendeeID);
    }

    public void updateAttendee(String attendeeID, Attendee updatedAttendee) {
        if (attendeeMap.containsKey(attendeeID)) {
            attendeeMap.put(attendeeID, updatedAttendee);
            saveToFile();
        }
    }

    public void removeAttendee(String attendeeID) {
        if (attendeeMap.remove(attendeeID) != null) {
            saveToFile();
        }
    }

    public void addSpeaker(Speaker speaker) {
        speakerMap.put(speaker.getSpeakerID(), speaker);
        saveToFile();
    }

    public Speaker getSpeaker(String speakerID) {
        return speakerMap.get(speakerID);
    }

    public void updateSpeaker(String speakerID, Speaker updatedSpeaker) {
        if (speakerMap.containsKey(speakerID)) {
            speakerMap.put(speakerID, updatedSpeaker);
            saveToFile();
        }
    }

    public void removeSpeaker(String speakerID) {
        if (speakerMap.remove(speakerID) != null) {
            saveToFile();
        }
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(new HashMap[]{new HashMap<>(attendeeMap), new HashMap<>(speakerMap)});
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    private void loadFromFile() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                Object[] maps = (Object[]) ois.readObject();
                attendeeMap = (HashMap<String, Attendee>) maps[0];
                speakerMap = (HashMap<String, Speaker>) maps[1];
            } catch (FileNotFoundException e) {
                System.out.println("File not found, initializing new maps.");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error loading data: " + e.getMessage());
            }
        }
    }


