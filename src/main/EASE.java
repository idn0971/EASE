import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class EASE extends JFrame implements ActionListener, MouseListener{
	
	private JMenuBar menuBar;
	private JMenu about, signin, mainPage;
	private mainPage main = new mainPage();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EASE application = new EASE();
	}
	
	private JMenuBar menu() {
		menuBar = new JMenuBar();
		
		about = new JMenu("About");
		about.addActionListener(this);
		
		signin = new JMenu("Sign in");
		signin.addActionListener(this);
		
		mainPage = new JMenu("Main Page");
		mainPage.addActionListener(this);
		
		menuBar.add(mainPage);
		menuBar.add(signin);
		menuBar.add(about);
		
		return menuBar;
	}
	
	private JPanel mainPage() {
		JPanel panel = new JPanel();
		
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
		
		return panel;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public EASE() {
		setTitle("EASE Development");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 240);
		setVisible(true);
		
		setJMenuBar(menu());
		
		add(main, BorderLayout.CENTER);
		
		
	}

}
