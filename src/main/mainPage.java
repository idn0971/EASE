import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class mainPage extends JPanel{
	
	private JPanel panel = new JPanel();
	// creates arraylist of applications (from app class)
	private ArrayList<Application> verifiedApps = new ArrayList<Application>();

	public static void main(String[] args) {
		mainPage main = new mainPage();

	}
	
	public mainPage() {
		JPanel search =  new JPanel();
		search.setLayout(new GridLayout(1,2));
		JLabel dummyBar = new JLabel("Search");
		JTextField bar = new JTextField("What would you like to find?", 50);
		search.add(dummyBar);
		search.add(bar);
		
		panel.add(search, BorderLayout.NORTH);
		
		JPanel button = new JPanel();
		JButton submit = new JButton("Search");
		button.add(submit);
		
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
		
		verifiedApps = loadVerifiedApps(); // Issac is implementing this method.
	}
	// place holder for this method
	private ArrayList<Application> loadVerifiedApps() {
		return verifiedApps;
	}
	
	// create private method that recalls verified apps
	// call loadVerified method
	private void recallVerified() {
		verifiedApps = loadVerifiedApps();
	}
	

}
