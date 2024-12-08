import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AttendanceDataSubsystem {
    private Map<String, Boolean> attendanceMap;
    private static final String FILE_NAME = "attendanceData.txt";

    public AttendanceDataSubsystem() {
        attendanceMap = new HashMap<>();
        loadFromFile();
    }

    public void markAttendance(String attendeeID, String sessionID) {
        String key = attendeeID + "-" + sessionID;
        attendanceMap.put(key, true);
        saveToFile();
    }

    public boolean isAttendeePresent(String attendeeID, String sessionID) {
        String key = attendeeID + "-" + sessionID;
        return attendanceMap.getOrDefault(key, false);
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<String, Boolean> entry : attendanceMap.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving attendance data: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    attendanceMap.put(parts[0], Boolean.parseBoolean(parts[1]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Attendance data file not found, starting fresh.");
        } catch (IOException e) {
            System.err.println("Error loading attendance data: " + e.getMessage());
        }
    }
}
