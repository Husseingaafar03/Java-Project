import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Step 1: Initialize backend subsystems
        UserDataSubsystem userDataSubsystem = new UserDataSubsystem();
        userDataSubsystem.loadFromFile();
        UserManagementSubsystem userManagementSubsystem = new UserManagementSubsystem(userDataSubsystem);

        // Step 2: Add some example data (if not already loaded)
        if (userDataSubsystem.getAttendeeByUsername("janesmith") == null) {
            // Add example attendee
            Attendee attendee = new Attendee(
                    "A02",                // attendeeID
                    "Jane Smith",         // name
                    "janesmith@example.com", // email
                    "janesmith",          // username
                    "password456"         // password
            );
            userDataSubsystem.addAttendee(attendee);
        }

        if (userDataSubsystem.getSpeakerByUsername("alice") == null) {
            // Add example speaker
            Speaker speaker = new Speaker(
                    "SP01",                // speakerID
                    "Alice Johnson",       // name
                    "Expert in Java and Software Development", // bio
                    "alice",               // username
                    "password456"          // password
            );
            userDataSubsystem.addSpeaker(speaker);
        }

        // Step 3: Create the main application frame
        JFrame frame = new JFrame("Login Form");
        LoginForm loginForm = new LoginForm(userManagementSubsystem);

        // Add a login listener to the LoginForm
        loginForm.addLoginListener((userType, username, password) -> {
            boolean isAuthenticated = userManagementSubsystem.authenticateUser(userType, username, password);
            if (isAuthenticated) {
                JOptionPane.showMessageDialog(frame, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                switch (userType.toLowerCase()) {
                    case "attendee":
                        // Navigate to AttendeeHomepage
                        Attendee loggedInAttendee = userDataSubsystem.getAttendeeByUsername(username);
                        if (loggedInAttendee != null) {
                            AttendeeHomepage attendeeHomepage = new AttendeeHomepage(loggedInAttendee.getName());
                            frame.setContentPane(attendeeHomepage.getMainPanel());
                            frame.pack();
                        }
                        break;

                    case "speaker":
                        // Navigate to SpeakerHomepage
                        Speaker loggedInSpeaker = userDataSubsystem.getSpeakerByUsername(username);
                        if (loggedInSpeaker != null) {
                            SpeakerHomepage speakerHomepage = new SpeakerHomepage(loggedInSpeaker.getName());
                            frame.setContentPane(speakerHomepage.getMainPanel());
                            frame.pack();
                        }
                        break;

                    case "admin":
                        // Placeholder for AdminHomepage
                        JOptionPane.showMessageDialog(frame, "Admin homepage not implemented yet.", "Info", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    default:
                        JOptionPane.showMessageDialog(frame, "Unknown user type.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Step 4: Set up the frame
        frame.setContentPane(loginForm.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
