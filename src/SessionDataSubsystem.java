import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SessionDataSubsystem {
    private Map<String, Session> sessionMap;
    private static final String FILE_NAME = "sessionData.txt";

    public SessionDataSubsystem() {
        sessionMap = new HashMap<>();
        loadFromFile();
    }

    public void addSession(Session session) {
        sessionMap.put(session.getSessionID(), session);
        saveToFile();
    }

    public Session getSession(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void updateSession(String sessionID, Session updatedSession) {
        if (sessionMap.containsKey(sessionID)) {
            sessionMap.put(sessionID, updatedSession);
            saveToFile();
        }
    }

    public void removeSession(String sessionID) {
        if (sessionMap.remove(sessionID) != null) {
            saveToFile();
        }
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(sessionMap);
        } catch (IOException e) {
            System.err.println("Error saving session data: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            sessionMap = (HashMap<String, Session>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Session data file not found, starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading session data: " + e.getMessage());
        }
    }
}
