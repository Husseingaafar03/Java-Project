public class Speaker {
    private String speakerID;
    private String name;
    private String bio;

    public Speaker(String speakerID, String name, String bio) {
        this.speakerID = speakerID;
        this.name = name;
        this.bio = bio;
    }

    public String getSpeakerID() { return speakerID; }
    public String getName() { return name; }
    public String getBio() { return bio; }
}