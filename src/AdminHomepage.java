import javax.swing.*;
import java.awt.event.ActionEvent;

public class AdminHomepage {
    private JPanel mainPanel;
    private JLabel welcomeLabel;
    private JButton manageUsersButton;
    private JButton viewReportsButton;
    private JButton manageConferencesButton;
    private JButton logoutButton;

    public AdminHomepage(String adminName) {
        initComponents();

        // Set welcome label text dynamically
        welcomeLabel.setText("Welcome, " + adminName + "!");

        // Add action listeners for buttons
        manageUsersButton.addActionListener(this::manageUsers);
        viewReportsButton.addActionListener(this::viewReports);
        manageConferencesButton.addActionListener(this::manageConferences);
        logoutButton.addActionListener(this::logout);
    }

    private void manageUsers(ActionEvent e) {
        // Example: Show a dialog or navigate to another page for user management
        String message = "Manage Users Feature:\n" +
                "1. Add Users\n" +
                "2. Remove Users\n" +
                "3. Update User Details";
        JOptionPane.showMessageDialog(mainPanel, message, "Manage Users", JOptionPane.INFORMATION_MESSAGE);
    }

    private void viewReports(ActionEvent e) {
        // Example: Show a dialog or display some reports
        String message = "View Reports Feature:\n" +
                "1. Attendance Reports\n" +
                "2. Feedback Summary\n" +
                "3. Session Popularity";
        JOptionPane.showMessageDialog(mainPanel, message, "View Reports", JOptionPane.INFORMATION_MESSAGE);
    }

    private void manageConferences(ActionEvent e) {
        // Example: Show a dialog or navigate to another page for conference management
        String message = "Manage Conferences Feature:\n" +
                "1. Add Conferences\n" +
                "2. Update Conference Details\n" +
                "3. Remove Conferences";
        JOptionPane.showMessageDialog(mainPanel, message, "Manage Conferences", JOptionPane.INFORMATION_MESSAGE);
    }

    private void logout(ActionEvent e) {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
        if (topFrame != null) {
            UserManagementSubsystem userManagementSubsystem = new UserManagementSubsystem(new UserDataSubsystem());
            LoginForm loginForm = new LoginForm(userManagementSubsystem);

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
        manageUsersButton = new JButton();
        viewReportsButton = new JButton();
        manageConferencesButton = new JButton();
        logoutButton = new JButton();

        // Layout and padding
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        // Welcome label
        welcomeLabel.setText("Welcome, Admin!");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(welcomeLabel);

        // Buttons
        manageUsersButton.setText("Manage Users");
        mainPanel.add(manageUsersButton);

        viewReportsButton.setText("View Reports");
        mainPanel.add(viewReportsButton);

        manageConferencesButton.setText("Manage Conferences");
        mainPanel.add(manageConferencesButton);

        logoutButton.setText("Logout");
        mainPanel.add(logoutButton);
    }
}
