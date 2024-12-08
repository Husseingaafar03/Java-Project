import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class LoginForm {
    private JPanel mainPanel;
    private UserManagementSubsystem userManagementSubsystem;

    public LoginForm(UserManagementSubsystem userManagementSubsystem) {
        this.userManagementSubsystem = userManagementSubsystem;
        initComponents();
    }

    private void initComponents() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel userTypeLabel = new JLabel("User Type:");
        JComboBox<String> userTypeComboBox = new JComboBox<>(new String[] { "Attendee", "Speaker", "Admin" });

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");

        // Add components to mainPanel
        mainPanel.add(userTypeLabel);
        mainPanel.add(userTypeComboBox);
        mainPanel.add(usernameLabel);
        mainPanel.add(usernameField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(loginButton);
        System.out.println("Components are being initialized");

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }


}
