import java.util.HashMap;
import java.util.Map;

public class SessionDataSubsystem {
    private Map<String, Session> sessionMap;

    public SessionDataSubsystem() {
        sessionMap = new HashMap<>();
    }

    // Add a new session to the subsystem
    public void addSession(Session session) {
        sessionMap.put(session.getSessionID(), session);
    }

    // Retrieve a session by its ID
    public Session getSession(String sessionID) {
        return sessionMap.get(sessionID);
    }

    // Update an existing session
    public void updateSession(String sessionID, Session updatedSession) {
        if (sessionMap.containsKey(sessionID)) {
            sessionMap.put(sessionID, updatedSession);
        }
    }

    // Remove a session by its ID
    public void removeSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}