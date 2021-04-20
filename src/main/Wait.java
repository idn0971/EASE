import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Wait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Wait w = new Wait();
	}
	
	/*
	 * Waiting page for the user to see while admin is processing the request
	 */
	public Wait() {
		JFrame frame = new JFrame("Welcome");
		frame.setLayout(new BorderLayout());
		frame.setSize(400, 240);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JLabel message = new JLabel("Please wait while the admin processes your request.");
		frame.add(message, BorderLayout.CENTER);
		
		
	}

}
