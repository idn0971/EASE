
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class mainPage extends JPanel {

	private JPanel panel = new JPanel();

	// creates arraylist of applications (from app class)
	private static ArrayList<Application> verifiedApps = new ArrayList<Application>();

	public static void main(String[] args) {
		mainPage main = new mainPage();

	}

	private JComboBox filter;
	private JButton submit;
	private String filters[]
			= { "Select One", "Rating", "KeyWord", "Category"};

	public mainPage() {
		JPanel search =  new JPanel();
		search.setLayout(new GridLayout(1,2));
		JLabel dummyBar = new JLabel("Search");
		JTextField bar = new JTextField("What would you like to find?", 50);
		search.add(dummyBar);
		search.add(bar);

		panel.add(search, BorderLayout.NORTH);

		JPanel button = new JPanel();
		submit = new JButton("Search");
		button.add(submit);
		filter = new JComboBox(filters);
		button.add(filter);

		panel.add(button, BorderLayout.CENTER);

		JPanel applications = new JPanel();
		applications.setBorder(new TitledBorder("Applications Preview"));
		applications.setLayout(new GridLayout(1,5));
		JLabel app = new JLabel ("helloWorld.java");
		JLabel apple = new JLabel("Picture");
		JLabel size = new JLabel("size");
		JLabel user = new JLabel("Author");
		JLabel date = new JLabel("Date");
		applications.add(apple);
		applications.add(app);
		applications.add(size);
		applications.add(user);
		applications.add(date);

		panel.add(applications, BorderLayout.SOUTH);
	}



	

	

}
