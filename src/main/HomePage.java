import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class HomePage extends JPanel implements ItemListener, ActionListener {

	private static ArrayList<Application> verifiedApps = new ArrayList<Application>();

	static JComboBox filter;
	private JButton submit;
	private String filters[]
			= { "Select One", "Rating", "KeyWord", "Category"};

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
		if (e.getSource() == filter) {
			System.out.println(filter.getSelectedItem() + " selected");
		}
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
	private static ArrayList<Application> searchVerifiedApps(String keyword) {
        ArrayList<Application> searchResult = new ArrayList<>();
        String sql = "SELECT * "
                + "FROM Application WHERE isVerified = 1 AND name LIKE ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, keyword);
            ResultSet rs    = pstmt.executeQuery(sql);
            while (rs.next()) {
                boolean verified = false;
                if (rs.getInt("isVerified") == 1) {
                    verified = true;
                }
                Application app = new Application(rs.getString("name"), rs.getString("userAdded"),
                        rs.getString("dateAdded"), rs.getString("description"),
                        rs.getString("organization"), rs.getString("link"),
                        rs.getDouble("price"),
                        rs.getDouble("rating"), verified, null);
                searchResult.add(app);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return searchResult;
	}


	// private method that displays the verifiedApps with GUI in mainpage
	private static void displayVerified() {
		verifiedApps = loadVerifiedApps();
		for (Application a : verifiedApps) {
			if (a.isVerified()) {
				JTextArea displayVerifiedApps = new JTextArea(10, 30);
				displayVerifiedApps.append(a.toString() + "\n");
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

	// create private method to take keyword
	// when user clicks search button using actionlistener
	// take what is in search bar == keyword
	// verifiedApps = searchVerifiedApps();
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Search")) {
			JTextField bar = new JTextField("What would you like to find?", 50);
			bar.addActionListener(this);
			String usrInput = bar.getText();
			ArrayList<Application> searchResults = new ArrayList<>();
			searchResults = searchVerifiedApps(usrInput); // figure out how access the user input
			for (Application s : searchResults) {
				JTextArea searchBox = new JTextArea(10, 30);
				searchBox.append(s.toString() + "\n");
			}
		}
	}


	
	public static void main(String[] args) {
		HomePage home = new HomePage();
	}
	
	
	
}
