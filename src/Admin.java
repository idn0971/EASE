import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class Admin {
	
	public Admin() {
		JFrame frame = new JFrame("Admin");
		frame.setLayout(new GridLayout(3,1));
		frame.setSize(400, 240);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1,2));
		JButton approve = new JButton("Approve");
		JButton deny = new JButton("Deny");
		buttons.add(approve);
		buttons.add(deny);
		
		frame.add(buttons, BorderLayout.NORTH);
		
		JPanel applications = new JPanel();
		applications.setBorder(new TitledBorder("Applications Requests"));
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
		frame.add(applications, BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
		Admin ad = new Admin();
	}

}