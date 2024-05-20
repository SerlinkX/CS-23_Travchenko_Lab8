import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConferenceClientGUI {
    private JFrame frame;
    private JTextField nameField;
    private JTextField emailField;
    private ConferenceClient client;

    public ConferenceClientGUI() {
        client = new ConferenceClient();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Conference Registration");
        frame.setBounds(100, 100, 300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        frame.getContentPane().add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 20, 165, 25);
        frame.getContentPane().add(nameField);
        nameField.setColumns(10);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 60, 80, 25);
        frame.getContentPane().add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 60, 165, 25);
        frame.getContentPane().add(emailField);
        emailField.setColumns(10);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(10, 100, 120, 25);
        frame.getContentPane().add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                client.register(name, email);
            }
        });

        JButton exportButton = new JButton("Export to XML");
        exportButton.setBounds(140, 100, 120, 25);
        frame.getContentPane().add(exportButton);
        exportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                client.exportToXML("participants.xml");
            }
        });

        JButton importButton = new JButton("Import from XML");
        importButton.setBounds(10, 140, 250, 25);
        frame.getContentPane().add(importButton);
        importButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                client.importFromXML("participants.xml");
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    ConferenceClientGUI window = new ConferenceClientGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}