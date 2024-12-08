public class SessionManagementSubsystem {
    private SessionDataSubsystem sessionDataSubsystem;

    public SessionManagementSubsystem(SessionDataSubsystem sessionDataSubsystem) {
        this.sessionDataSubsystem = sessionDataSubsystem;
    }

    // Add a new session to the session data subsystem
    public void addSession(Session session) {
        sessionDataSubsystem.addSession(session);
        System.out.println("Session added: " + session.getName());
    }

    // Update an existing session in the session data subsystem
    public void updateSession(String sessionID, Session updatedSession) {
        sessionDataSubsystem.updateSession(sessionID, updatedSession);
        System.out.println("Session updated: " + updatedSession.getName());
    }

    // Remove a session from the session data subsystem
    public void removeSession(String sessionID) {
        sessionDataSubsystem.removeSession(sessionID);
        System.out.println("Session removed with ID: " + sessionID);
    }

    // Get details of a session by its ID
    public void getSessionDetails(String sessionID) {
        Session session = sessionDataSubsystem.getSession(sessionID);
        if (session != null) {
            System.out.println("Session Details: ");
            System.out.println("Name: " + session.getName());
            System.out.println("Date: " + session.getDate());
            System.out.println("Time: " + session.getTime());
            System.out.println("Room: " + session.getRoom());
        } else {
            System.out.println("No session found with ID: " + sessionID);
        }
    }
}
