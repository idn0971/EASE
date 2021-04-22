import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class HomePage extends JPanel implements ItemListener{
 
	private String filters[] 
			= { "Select One", "Rating", "KeyWord", "Category"};
	static JComboBox filter;
	static JMenu menu;
	static JFrame f;
	static JMenuBar bar;
	static JMenuItem searchin, pop;
	
	public HomePage() {
		// TODO Auto-generated method stub
				JFrame frame = new JFrame("EASE Development");
				frame.setLayout(new BorderLayout());
				frame.setSize(500, 240);
				
				// menu Bar creation
				bar = new JMenuBar();
				menu = new JMenu("Menu");
				searchin = new JMenuItem("Search Page");
				pop = new JMenuItem("Login Page");
				menu.add(searchin);
				menu.add(pop);
				bar.add(menu);
				f.setJMenuBar(bar);
				
				//Search Bar
				JPanel search1 =  new JPanel();
				search1.setLayout(new GridLayout(1,2));
				JLabel dummyBar = new JLabel("Search:");
				JTextField text = new JTextField("What would you like to find?", 50);
				search1.add(dummyBar);
				search1.add(text);	
				frame.add(search1, BorderLayout.NORTH);
				
				//Button and filter
				filter = new JComboBox(filters);
				HomePage tH = new HomePage();
				filter.addItemListener(tH);
				JPanel button = new JPanel();
				JButton submit = new JButton("Search");
				button.add(submit);
				button.add(filter);
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
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == filter) {
			System.out.println(filter.getSelectedItem() + " selected");
		}
	}
	
	public static void main(String[] args) {
		HomePage home = new HomePage();
	}
	
	
	
}
