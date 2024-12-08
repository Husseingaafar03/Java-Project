public class Session {
    private String sessionID;
    private String name;
    private String date;
    private String time;
    private String room;

    public Session(String sessionID, String name, String date, String time, String room) {
        this.sessionID = sessionID;
        this.name = name;
        this.date = date;
        this.time = time;
        this.room = room;
    }

    public String getSessionID() { return sessionID; }
    public String getName() { return name; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getRoom() { return room; }
}