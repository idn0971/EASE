import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class AddApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddApp add = new AddApp();
	}
	
	public AddApp() {
		JFrame frame = new JFrame("Adding an Application");
		frame.setLayout(new BorderLayout());
		frame.setSize(400, 240);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("Application to add an app"));
		panel.setLayout(new GridLayout(7,2));
		
		JLabel user = new JLabel("Who is adding this?");
		panel.add(user);
		JTextField username = new JTextField("Enter text here", 50);
		panel.add(username);
		
//		JLabel pass = new JLabel("Date it is being added");
//		panel.add(pass);
//		JTextField password = new JTextField("Today's Date", 10);
//		panel.add(password);
//		
//		JLabel appname = new JLabel("Name of the app");
//		panel.add(appname);
//		JTextField name = new JTextField("name", 50);
//		panel.add(name);
//		
//		JLabel des = new JLabel("Brief Description");
//		panel.add(des);
//		JTextField des2 = new JTextField("Description", 100);
//		panel.add(des2);
//		
//		JLabel company = new JLabel("Name of Company");
//		panel.add(company);
//		JTextField comp = new JTextField("Company", 50);
//		panel.add(comp);
//		
//		JLabel link = new JLabel("Enter the link to the Application");
//		panel.add(link);
//		JTextField link1 = new JTextField("Link", 100);
//		panel.add(link1);
//		
//		JLabel price = new JLabel("Price of the app");
//		panel.add(price);
//		JTextField pric = new JTextField("Price", 100);
//		panel.add(pric);
//		
		frame.add(panel, BorderLayout.CENTER);
		
//		JPanel buttons = new JPanel();
//		buttons.setLayout(new GridLayout(1,2));
//		JButton sub = new JButton("Submit");
//		JButton canc = new JButton("Cancel");
//		
//		buttons.add(sub);
//		buttons.add(canc);
//		frame.add(buttons, BorderLayout.SOUTH);
		
		
	}

}
