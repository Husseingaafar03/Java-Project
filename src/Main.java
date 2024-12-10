import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Step 1: Initialize backend subsystems
        UserDataSubsystem userDataSubsystem = new UserDataSubsystem();
        UserManagementSubsystem userManagementSubsystem = new UserManagementSubsystem(userDataSubsystem);

        // Step 2: Add some example data
        userDataSubsystem.addAttendee(new Attendee("A01", "Jane Smith", "janesmith@example.com", "janesmith", "password456"));
        userDataSubsystem.addSpeaker(new Speaker("SP01", "Alice Johnson", "Expert in Java and AI", "alicejohnson", "password123"));

        // Add admin credentials
        userDataSubsystem.addAdmin(new Admin("AD01", "Admin User", "admin", "adminpass"));

        // Step 3: Create and display the login form
        JFrame frame = new JFrame("Login Form");
        LoginForm loginForm = new LoginForm(userManagementSubsystem);

        // Add the login listener
        loginForm.addLoginListener((String userType, String username, String password) -> {
            boolean isAuthenticated = userManagementSubsystem.authenticateUser(userType, username, password);
            if (isAuthenticated) {
                JOptionPane.showMessageDialog(frame, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                switch (userType.toLowerCase()) {
                    case "attendee":
                        Attendee loggedInAttendee = userManagementSubsystem.getUserDataSubsystem().getAttendeeByUsername(username);
                        if (loggedInAttendee != null) {
                            AttendeeHomepage attendeeHomepage = new AttendeeHomepage(loggedInAttendee.getName());
                            frame.setContentPane(attendeeHomepage.getMainPanel());
                            frame.pack();
                        }
                        break;

                    case "speaker":
                        Speaker loggedInSpeaker = userManagementSubsystem.getUserDataSubsystem().getSpeakerByUsername(username);
                        if (loggedInSpeaker != null) {
                            SpeakerHomepage speakerHomepage = new SpeakerHomepage(loggedInSpeaker.getName());
                            frame.setContentPane(speakerHomepage.getMainPanel());
                            frame.pack();
                        }
                        break;

                    case "admin":
                        Admin loggedInAdmin = userManagementSubsystem.getUserDataSubsystem().getAdminByUsername(username);
                        if (loggedInAdmin != null) {
                            AdminHomepage adminHomepage = new AdminHomepage(loggedInAdmin.getName());
                            frame.setContentPane(adminHomepage.getMainPanel());
                            frame.pack();
                        }
                        break;

                    default:
                        JOptionPane.showMessageDialog(frame, "Unknown user type.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Replace content pane with login form
        frame.setContentPane(loginForm.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
