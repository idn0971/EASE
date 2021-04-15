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
		panel.setLayout(new GridLayout(10,2));
		
		JLabel name = new JLabel("Name of Application");
		JLabel date = new JLabel("Date added");
		JLabel user = new JLabel("Who added it?");
		JLabel des = new JLabel("Description");
		JLabel comp = new JLabel("What company is adding this?");
		JLabel link = new JLabel("Link to application");
		JLabel price = new JLabel("Price of application");
		panel.add(name);
		panel.add(date);
		panel.add(user);
		panel.add(des);
		panel.add(comp);
		panel.add(link);
		panel.add(price);
		//JTextField name1 = new JTextField("Name", 10);
		//panel.add(name1);
		
		
		
		frame.add(panel, BorderLayout.CENTER);
	}

}
