

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class mainPage extends JPanel implements ActionListener {

	private JPanel panel = new JPanel();
	// creates arraylist of applications (from app class)
	private static ArrayList<Application> verifiedApps = new ArrayList<Application>();

	public static void main(String[] args) {
		mainPage main = new mainPage();

	}

	public mainPage() {
	    connect();
		JPanel search = new JPanel();
		search.setLayout(new GridLayout(1, 2));
		JLabel dummyBar = new JLabel("Search");
		JTextField bar = new JTextField("What would you like to find?", 50);
		search.add(dummyBar);
		search.add(bar);

		panel.add(search, BorderLayout.NORTH);

		JPanel button = new JPanel();
		JButton submit = new JButton("Search");
		button.add(submit);
		submit.addActionListener(this);

		panel.add(button, BorderLayout.CENTER);

		JPanel applications = new JPanel();
		applications.setBorder(new TitledBorder("Applications Preview"));
		applications.setLayout(new GridLayout(1, 5));
		JLabel app = new JLabel("helloWorld.java");
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
	private static ArrayList<Application> loadVerifiedApps() {
		ArrayList <Application> apps = new ArrayList<>();
		String sql = "SELECT * "
				+ "FROM Application WHERE verified = 1";

		try (Connection conn = connect();
			 Statement stmt  = conn.createStatement();
			 ResultSet rs    = stmt.executeQuery(sql)){

			// loop through the result set
			while (rs.next()) {
				boolean verified = false;
				if (rs.getInt("isVerified") == 1){
					verified = true;
				}
				Application app = new Application(rs.getString("name"), rs.getString("userAdded"),
						rs.getString("dateAdded"), rs.getString("description"),
						rs.getString("organization"), rs.getString("link"),
						 rs.getDouble("price"),
						rs.getDouble("rating"), verified , null);
				apps.add(app);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return apps;
	}

	// create method that recalls verified apps
	// call loadVerified method
	public static void recallVerified() {
		verifiedApps = loadVerifiedApps();
	}

	// place holder for this method
	private static ArrayList<Application> searchVerifiedApps() {
		return verifiedApps;
	}

	// create private method to take keyword
	// when user clicks search button using actionlistener
	// take what is in search bar == keyword
	// verifiedApps = searchVerifiedApps();
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Search")) {
			verifiedApps = searchVerifiedApps(); // figure out how access the user input
			JTextArea searchBox = new JTextArea(10, 30);
			searchBox.append(searchVerifiedApps().toString() + "\n");
		}
	}

	// private method that displays the verifiedApps with GUI in mainpage
	private static void displayVerified() {
		Application app = new Application();
		for (Application a : verifiedApps) {
			if (a.isVerified()) {
				JTextArea displayVerifiedApps = new JTextArea(10, 30);
				displayVerifiedApps.append(loadVerifiedApps().toString() + "\n");
			}
		}

	}

    private static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:sqlite/EASE.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
