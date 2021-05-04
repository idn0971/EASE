import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import javax.jws.soap.SOAPBinding;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class Login implements ActionListener{
	/*
	 * Generates Login popup for the user or admin to log in
	 */
	CreateAccount acc;
	public Login() {
		// TODO Auto-generated method stub
				JFrame frame = new JFrame("Welcome");
				frame.setLayout(new GridLayout(3,1));
				frame.setSize(400, 240);
				
				//Username and Password
				JPanel panel = new JPanel();
				panel.setBorder(new TitledBorder("Please Sign in"));
				panel.setLayout(new GridLayout(2,2));
				JLabel user = new JLabel("Username");
				panel.add(user);
				JTextField username = new JTextField("Enter Username", 50);
				panel.add(username);
				JLabel pass = new JLabel("Password");
				panel.add(pass);
				JTextField password = new JTextField("Enter Password", 10);
				panel.add(password);
				
				//Company Name
				JPanel name = new JPanel();
				name.setLayout(new BorderLayout());
				JLabel company = new JLabel("EASE Development");
				name.add(company);
				
				//Button Panel
				JPanel buttons = new JPanel();
				JButton sign = new JButton("Sign in");
				sign.addActionListener(this);
				JButton create = new JButton("Create user");
				create.addActionListener(this);
				buttons.add(sign);
				buttons.add(create);
				
				//Adding pannels to the frame
				frame.add(name, BorderLayout.NORTH);
				frame.add(panel, BorderLayout.CENTER);
				frame.add(buttons, BorderLayout.SOUTH);
				
				//Some Frame setup
				frame.setVisible(true);
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Create user")) {
			acc = new CreateAccount();
		}
	}

    public void createUser(String userName, String password) {
        String sql = "INSERT INTO Login(userName, password) VALUES(?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public  User findUser(String userName, String password) {
        User user = new User();
        String sql = "SELECT userName, password "
                + "FROM Login WHERE userName = ? AND password = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
             ResultSet rs    = pstmt.executeQuery();
             user.setUserName(rs.getString("userName"));
             user.setPassword(rs.getString("password"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    private static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:sqlite/EASE.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
	
	public static void main(String[] args) {
		Login log = new Login();
	}

}
