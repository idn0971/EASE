

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class AddApp extends JFrame implements ActionListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddApp add = new AddApp();
	}
	// Components
	private Container c;
	static JButton sub;
	
	/*
	 * Creates Frame and labels to add an application and request to admin
	 */
	public AddApp() {
		// Creates new Frame for the window
		JFrame frame = new JFrame("Adding an Application");
		frame.setLayout(new BorderLayout());
		frame.setSize(400, 240);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//main container to house everything
		c = getContentPane();
		c.setLayout(new GridLayout(7,2));
		
		
		// JLabels and adding them
		JLabel name = new JLabel("Name of Application");
		JLabel date = new JLabel("Date added");
		JLabel user = new JLabel("Who added it?");
		JLabel des = new JLabel("Description");
		JLabel comp = new JLabel("What company is adding this?");
		JLabel link = new JLabel("Link to application");
		JLabel price = new JLabel("Price of application");
		
		
		//textfields and adding
		JTextField name1 = new JTextField("Name", 100);
		
		JTextField date1 = new JTextField("Date", 10);
		
		JTextField user1 = new JTextField("Username", 50);
		
		JTextField des1 = new JTextField("Description", 200);
		
		JTextField comp1 = new JTextField("Company", 50);
		
		JTextField link1 = new JTextField("Link", 100);
		
		JTextField price1 = new JTextField("Price", 50);
		c.add(name);
		c.add(name1);
		c.add(date);
		c.add(date1);
		c.add(user);
		c.add(user1);
		c.add(des);
		c.add(des1);
		c.add(comp);
		c.add(comp1);
		c.add(link);
		c.add(link1);
		c.add(price);
		c.add(price1);
		 JPanel button = new JPanel();
		 sub = new JButton("Submit");
		 sub.addActionListener(this);
		 button.add(sub);
		 frame .add(button, BorderLayout.SOUTH);
		frame.add(c, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

	public void createAccount(String appName, String userName, String date, String description, String organization,
							  String link, String category, double price) {
		String sql = "INSERT INTO Application(name, userAdded, dateAdded, description, organization, link, category," +
				" price) VALUES(?,?,?,?,?,?,?,?)";

		try (Connection conn = connect();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, appName);
			pstmt.setString(2, userName);
			pstmt.setString(3, date);
			pstmt.setString(4, description);
			pstmt.setString(5, organization);
			pstmt.setString(6, link);
			pstmt.setString(7, category);
			pstmt.setDouble(8, price);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
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

}
