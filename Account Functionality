import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class CreateAccount implements ActionListener {

    JFrame          frame;
    JPanel          panel;
    JTextField      username;
    JPasswordField  password;
    JPasswordField  confirm;
    JLabel          warning;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager
                            .getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                CreateAccount window = new CreateAccount();
                window.go();
            }
        });
    }

    public void go() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.ORANGE);

        frame = new JFrame("Create a new account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        JLabel userLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel confirmLabel = new JLabel("Confirm Password:");
        username = new JTextField(15);
        password = new JPasswordField(15);
        confirm = new JPasswordField(15);

        GridBagConstraints right = new GridBagConstraints();
        right.anchor = GridBagConstraints.WEST;
        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.EAST;

        right.weightx = (int) 2;
        right.fill = GridBagConstraints.REMAINDER;
        right.gridwidth = GridBagConstraints.REMAINDER;
        // actual GUI

        panel.add(userLabel, left);
        panel.add(username, right);
        panel.add(passwordLabel, left);
        panel.add(password, right);
        panel.add(confirmLabel, left);
        panel.add(confirm, right);

        JButton createAccount = new JButton("Create this account");
        frame.getContentPane().add(BorderLayout.SOUTH, createAccount);
        createAccount.addActionListener(this);

        warning = new JLabel();
        frame.getContentPane().add(BorderLayout.NORTH, warning);
        frame.setSize(300, 250);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (!(Arrays.equals(password.getPassword(),
                confirm.getPassword()))) {
            warning.setText("Your passwords incorrect");
        } else {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("nuserInfo.txt"));
                writer.write(username.getText() + "/" + new String(password.getPassword()));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
