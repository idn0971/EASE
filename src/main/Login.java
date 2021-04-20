import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class Login {
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
				JButton create = new JButton("Create user");
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


	
	public static void main(String[] args) {
		Login log = new Login();
	}

}
