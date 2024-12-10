import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class AttendeeHomepage {
    private JPanel mainPanel;
    private JLabel welcomeLabel;
    private JButton viewConferencesButton;
    private JButton viewSessionsButton;
    private JButton provideFeedbackButton;
    private JButton logoutButton;

    // Sample data for demonstration
    private List<String> conferences;
    private List<String> sessions;
    private List<String> feedbacks;

    public AttendeeHomepage(String attendeeName) {
        // Initialize sample data
        initSampleData();

        // Initialize UI components
        initComponents();

        // Set welcome label text dynamically
        welcomeLabel.setText("Welcome, " + attendeeName + "!");

        // Add action listeners
        viewConferencesButton.addActionListener(this::viewConferences);
        viewSessionsButton.addActionListener(this::viewSessions);
        provideFeedbackButton.addActionListener(this::provideFeedback);
        logoutButton.addActionListener(this::logout);
    }

    private void initSampleData() {
        // Initialize some sample data
        conferences = new ArrayList<>();
        conferences.add("Tech Conference 2024: Dec 5-7");
        conferences.add("AI Innovations 2024: Jan 15-17");
        conferences.add("Cybersecurity Summit: Feb 10-12");

        sessions = new ArrayList<>();
        sessions.add("Session 1: Java for Beginners (Dec 5)");
        sessions.add("Session 2: Advanced Java Concepts (Dec 6)");
        sessions.add("Session 3: Building Secure APIs (Dec 7)");

        feedbacks = new ArrayList<>();
    }

    private void viewConferences(ActionEvent e) {
        // Display the list of conferences
        StringBuilder conferenceList = new StringBuilder("Available Conferences:\n");
        for (String conference : conferences) {
            conferenceList.append("- ").append(conference).append("\n");
        }
        JOptionPane.showMessageDialog(mainPanel, conferenceList.toString(), "Conferences", JOptionPane.INFORMATION_MESSAGE);
    }

    private void viewSessions(ActionEvent e) {
        // Display the list of registered sessions
        StringBuilder sessionList = new StringBuilder("Your Registered Sessions:\n");
        for (String session : sessions) {
            sessionList.append("- ").append(session).append("\n");
        }
        JOptionPane.showMessageDialog(mainPanel, sessionList.toString(), "Registered Sessions", JOptionPane.INFORMATION_MESSAGE);
    }

    private void provideFeedback(ActionEvent e) {
        // Select a session for feedback
        String selectedSession = (String) JOptionPane.showInputDialog(
                mainPanel,
                "Select a session to provide feedback:",
                "Provide Feedback",
                JOptionPane.PLAIN_MESSAGE,
                null,
                sessions.toArray(),
                sessions.get(0)
        );

        // Check if a session was selected
        if (selectedSession != null) {
            // Prompt the attendee to write feedback
            String feedback = JOptionPane.showInputDialog(
                    mainPanel,
                    "Write your feedback for " + selectedSession + ":",
                    "Provide Feedback",
                    JOptionPane.PLAIN_MESSAGE
            );

            // Check if feedback was provided
            if (feedback != null && !feedback.isBlank()) {
                // Save the feedback
                feedbacks.add(selectedSession + ": " + feedback);
                JOptionPane.showMessageDialog(mainPanel, "Thank you for your feedback!", "Feedback Submitted", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(mainPanel, "No feedback provided.", "Feedback Not Submitted", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void logout(ActionEvent e) {
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
                                AttendeeHomepage homepage = new AttendeeHomepage(loggedInAttendee.getName());
                                topFrame.setContentPane(homepage.getMainPanel());
                                topFrame.pack();
                            }
                            break;
                        case "speaker":
                            JOptionPane.showMessageDialog(topFrame, "Speaker homepage not implemented yet.", "Info", JOptionPane.INFORMATION_MESSAGE);
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
        viewConferencesButton = new JButton();
        viewSessionsButton = new JButton();
        provideFeedbackButton = new JButton();
        logoutButton = new JButton();

        // Main Panel Layout
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        // Welcome Label
        welcomeLabel.setText("Welcome, Attendee!");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(welcomeLabel);

        // Buttons
        viewConferencesButton.setText("View Conferences");
        mainPanel.add(viewConferencesButton);

        viewSessionsButton.setText("View Registered Sessions");
        mainPanel.add(viewSessionsButton);

        provideFeedbackButton.setText("Provide Feedback");
        mainPanel.add(provideFeedbackButton);

        logoutButton.setText("Logout");
        mainPanel.add(logoutButton);
    }
}
