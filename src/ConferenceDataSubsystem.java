import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ConferenceDataSubsystem {
    private Map<String, Conference> conferenceMap;
    private static final String FILE_NAME = "conferenceData.txt";

    public ConferenceDataSubsystem() {
        conferenceMap = new HashMap<>();
        loadFromFile();
    }

    public void addConference(Conference conference) {
        conferenceMap.put(conference.getConferenceID(), conference);
        saveToFile();
    }

    public Conference getConference(String conferenceID) {
        return conferenceMap.get(conferenceID);
    }

    public void updateConference(String conferenceID, Conference updatedConference) {
        if (conferenceMap.containsKey(conferenceID)) {
            conferenceMap.put(conferenceID, updatedConference);
            saveToFile();
        }
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(conferenceMap);
        } catch (IOException e) {
            System.err.println("Error saving conference data: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            conferenceMap = (HashMap<String, Conference>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Conference data file not found, starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading conference data: " + e.getMessage());
        }
    }
}
