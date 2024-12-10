import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class SpeakerHomepage {
    private JPanel mainPanel;
    private JLabel welcomeLabel;
    private JButton viewAssignedSessionsButton;
    private JButton managePresentationsButton;
    private JButton logoutButton;

    // Sample data for demonstration
    private List<String> assignedSessions;
    private List<String> presentations;

    public SpeakerHomepage(String speakerName) {
        // Initialize sample data
        initSampleData();

        // Initialize UI components
        initComponents();

        // Set welcome label text dynamically
        welcomeLabel.setText("Welcome, " + speakerName + "!");

        // Add action listeners
        viewAssignedSessionsButton.addActionListener(this::viewAssignedSessionsButtonActionPerformed);
        managePresentationsButton.addActionListener(this::managePresentationsButtonActionPerformed);
        logoutButton.addActionListener(this::logoutButtonActionPerformed);
    }

    private void initSampleData() {
        // Initialize some sample data
        assignedSessions = new ArrayList<>();
        assignedSessions.add("Session 1: Advanced Java Techniques (Dec 5)");
        assignedSessions.add("Session 2: Building Microservices with Spring Boot (Dec 6)");
        assignedSessions.add("Session 3: Secure API Design (Dec 7)");

        presentations = new ArrayList<>();
        presentations.add("Presentation: Optimizing Java Performance");
        presentations.add("Presentation: Microservices Best Practices");
    }

    private void viewAssignedSessionsButtonActionPerformed(ActionEvent e) {
        // Display the list of assigned sessions
        StringBuilder sessionList = new StringBuilder("Assigned Sessions:\n");
        for (String session : assignedSessions) {
            sessionList.append("- ").append(session).append("\n");
        }
        JOptionPane.showMessageDialog(mainPanel, sessionList.toString(), "Assigned Sessions", JOptionPane.INFORMATION_MESSAGE);
    }

    private void managePresentationsButtonActionPerformed(ActionEvent e) {
        // Display the list of presentations
        StringBuilder presentationList = new StringBuilder("Your Presentations:\n");
        for (String presentation : presentations) {
            presentationList.append("- ").append(presentation).append("\n");
        }
        JOptionPane.showMessageDialog(mainPanel, presentationList.toString(), "Manage Presentations", JOptionPane.INFORMATION_MESSAGE);
    }

    private void logoutButtonActionPerformed(ActionEvent e) {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
        if (topFrame != null) {
            UserManagementSubsystem userManagementSubsystem = new UserManagementSubsystem(new UserDataSubsystem());
            LoginForm loginForm = new LoginForm(userManagementSubsystem);

            // Add the login listener
            loginForm.addLoginListener((userType, username, password) -> {
                boolean isAuthenticated = userManagementSubsystem.authenticateUser(userType, username, password);
                if (isAuthenticated) {
                    JOptionPane.showMessageDialog(topFrame, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    switch (userType.toLowerCase()) {
                        case "attendee":
                            Attendee loggedInAttendee = userManagementSubsystem.getUserDataSubsystem().getAttendeeByUsername(username);
                            if (loggedInAttendee != null) {
                                AttendeeHomepage attendeeHomepage = new AttendeeHomepage(loggedInAttendee.getName());
                                topFrame.setContentPane(attendeeHomepage.getMainPanel());
                                topFrame.pack();
                            }
                            break;
                        case "speaker":
                            Speaker loggedInSpeaker = userManagementSubsystem.getUserDataSubsystem().getSpeakerByUsername(username);
                            if (loggedInSpeaker != null) {
                                SpeakerHomepage speakerHomepage = new SpeakerHomepage(loggedInSpeaker.getName());
                                topFrame.setContentPane(speakerHomepage.getMainPanel());
                                topFrame.pack();
                            }
                            break;
                        case "admin":
                            JOptionPane.showMessageDialog(topFrame, "Admin homepage not implemented yet.", "Info", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        default:
                            JOptionPane.showMessageDialog(topFrame, "Unknown user type.", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(topFrame, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            // Replace content pane with login form
            topFrame.setContentPane(loginForm.getMainPanel());
            topFrame.pack();
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void initComponents() {
        mainPanel = new JPanel();
        welcomeLabel = new JLabel();
        viewAssignedSessionsButton = new JButton();
        managePresentationsButton = new JButton();
        logoutButton = new JButton();

        // Main Panel Layout
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        // Welcome Label
        welcomeLabel.setText("Welcome, Speaker!");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(welcomeLabel);

        // Buttons
        viewAssignedSessionsButton.setText("View Assigned Sessions");
        mainPanel.add(viewAssignedSessionsButton);

        managePresentationsButton.setText("Manage Presentations");
        mainPanel.add(managePresentationsButton);

        logoutButton.setText("Logout");
        mainPanel.add(logoutButton);
    }
}
