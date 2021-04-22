package main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.*;
import java.awt.event.*;

import java.swing.*;
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
		c.add(name);
		c.add(date);
		c.add(user);
		c.add(des);
		c.add(comp);
		c.add(link);
		c.add(price);
		
		//textfields and adding
		JTextField name1 = new JTextField("Name", 100);
		c.add(name1);
		JTextField date1 = new JTextField("Date", 10)
		c.add(date1);
		JTextField user1 = new JTextField("Username", 50);
		c.add(user1);
		JTextField des1 = new JTextField("Description", 200);
		c.add(des1);
		JTextField comp1 = new JTextField("Company", 50);
		c.add(comp1);
		JTextField link1 = new JTextField("Link", 100);
		c.add(link1);
		JTextField price1 = new JTextField("Price", 50);
		c.add(price1);
		
		frame.add(c, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
