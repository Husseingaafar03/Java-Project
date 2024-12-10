import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoginForm {
    private JPanel mainPanel;
    private UserManagementSubsystem userManagementSubsystem;
    private LoginListener loginListener;

    public LoginForm(UserManagementSubsystem userManagementSubsystem) {
        this.userManagementSubsystem = userManagementSubsystem;
        initComponents();
    }

    /**
     * Add a login listener to handle the login action.
     * @param listener the listener to handle login actions.
     */
    public void addLoginListener(LoginListener listener) {
        this.loginListener = listener;
    }

    private void initComponents() {
        // Initialize components
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel userTypeLabel = new JLabel("User Type:");
        JComboBox<String> userTypeComboBox = new JComboBox<>(new String[]{"Attendee", "Speaker", "Admin"});

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");

        // Add components to the main panel
        mainPanel.add(userTypeLabel);
        mainPanel.add(userTypeComboBox);
        mainPanel.add(usernameLabel);
        mainPanel.add(usernameField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(loginButton);

        // Add action listener for the login button
        loginButton.addActionListener((ActionEvent e) -> {
            // Get user input
            String userType = (String) userTypeComboBox.getSelectedItem();
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Notify listener if it exists
            if (loginListener != null) {
                loginListener.onLogin(userType, username, password);
            }
        });
    }

    /**
     * Get the main panel for this form.
     * @return the main panel.
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * Interface for login listener.
     * This is used to handle login actions in the Main class.
     */
    public interface LoginListener {
        void onLogin(String userType, String username, String password);
    }
}
