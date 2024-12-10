import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserDataSubsystem {
    private Map<String, Attendee> attendeeMap;
    private Map<String, Speaker> speakerMap;
    private Map<String, Admin> adminMap; // Add this

    private static final String FILE_NAME = "userData.txt";

    public UserDataSubsystem() {
        attendeeMap = new HashMap<>();
        speakerMap = new HashMap<>();
        adminMap = new HashMap<>(); // Initialize admin map

        loadFromFile();
    }
    public Attendee getAttendeeByUsername(String username) {
        for (Attendee attendee : attendeeMap.values()) {
            if (username != null && username.equals(attendee.getUsername())) {
                return attendee;
            }
        }
        return null;
    }
    public void addAdmin(Admin admin) {
        adminMap.put(admin.getUsername(), admin); // Use username as key
    }

    public Admin getAdminByUsername(String username) {
        return adminMap.get(username);
    }

    public Speaker getSpeakerByUsername(String username) {
        for (Speaker speaker : speakerMap.values()) {
            if (username != null && username.equals(speaker.getUsername())) {
                return speaker;
            }
        }
        return null;
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

    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Object[] maps = (Object[]) ois.readObject();
            attendeeMap = (HashMap<String, Attendee>) maps[0];
            speakerMap = (HashMap<String, Speaker>) maps[1];
        } catch (FileNotFoundException e) {
            System.out.println("File not found, initializing new maps.");
            attendeeMap = new HashMap<>();
            speakerMap = new HashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data: " + e.getMessage());
            attendeeMap = new HashMap<>();
            speakerMap = new HashMap<>();
        }
    }

}


