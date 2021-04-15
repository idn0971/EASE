import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class HomePage extends JPanel{
 
	
	public HomePage() {
		// TODO Auto-generated method stub
				JFrame frame = new JFrame("EASE Development");
				frame.setLayout(new GridLayout(3,1));
				frame.setSize(500, 240);
				
				JPanel search =  new JPanel();
				search.setLayout(new GridLayout(1,2));
				JLabel dummyBar = new JLabel("Search");
				JTextField bar = new JTextField("What would you like to find?", 50);
				search.add(dummyBar);
				search.add(bar);
				
				frame.add(search, BorderLayout.NORTH);
				
				JPanel button = new JPanel();
				JButton submit = new JButton("Search");
				button.add(submit);
				
				frame.add(button, BorderLayout.CENTER);
				
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
				

				
				frame.add(applications, BorderLayout.SOUTH);
				
				frame.setVisible(true);
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				
				
		
	}
	
	public static void main(String[] args) {
		HomePage home = new HomePage();
	}
	
	
	
}
