import java.util.HashMap;
import java.util.Map;

public class ConferenceDataSubsystem {
    private Map<String, Conference> conferenceMap;

    public ConferenceDataSubsystem() {
        conferenceMap = new HashMap<>();
    }

    public void addConference(Conference conference) {
        conferenceMap.put(conference.getConferenceID(), conference);
    }

    public Conference getConference(String conferenceID) {
        return conferenceMap.get(conferenceID);
    }

    public void updateConference(String conferenceID, Conference updatedConference) {
        if (conferenceMap.containsKey(conferenceID)) {
            conferenceMap.put(conferenceID, updatedConference);
        }
    }
}