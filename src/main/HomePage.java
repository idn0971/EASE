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
			= { "Select One", "Rating", "Keyword", "Category"};

	static JMenu menu;
	static JFrame f;
	static JMenuBar bar;
	static JMenuItem searchin, pop;
	JTextField text;

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
				f = new JFrame();
				menu.add(searchin);
				menu.add(pop);
				bar.add(menu);
				f.setJMenuBar(bar);

				//Search Bar
				JPanel search =  new JPanel();
				search.setLayout(new GridLayout(1,2));
				JLabel dummyBar = new JLabel("Search:");
				text = new JTextField("What would you like to find?", 50);
				search.add(dummyBar);
				search.add(text);
				frame.add(search, BorderLayout.NORTH);



				filter = new JComboBox(filters);
				filter.addItemListener(this);
				JPanel button = new JPanel();
				JButton submit = new JButton("Search");
				button.add(submit);
				button.add(filter);
				submit.addActionListener(this);


				frame.add(button, BorderLayout.CENTER);

				JPanel applications = new JPanel();
				applications.setBorder(new TitledBorder("Applications Preview"));
				applications.setLayout(new GridLayout(1,5));
				JLabel app = new JLabel ("App Name");
				JLabel apple = new JLabel("Picture");
				JLabel size = new JLabel("size");
				JLabel user = new JLabel("Author");
				JLabel date = new JLabel("Date");
				applications.add(apple);
				applications.add(app);
				applications.add(size);
				applications.add(user);
				applications.add(date);
                JList<String> displayList = new JList<>(verifiedApps.toArray(new String[0]));
                JScrollPane scrollPane = new JScrollPane(displayList);
                //Lexi Please fix the layout for the scroll frame and figure out how to update it
                //frame.add(scrollPane);




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
						rs.getString("category"), rs.getDouble("price"),
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
            ResultSet rs    = pstmt.executeQuery();
            while (rs.next()) {
                boolean verified = false;
                if (rs.getInt("isVerified") == 1) {
                    verified = true;
                }
                Application app = new Application(rs.getString("name"), rs.getString("userAdded"),
                        rs.getString("dateAdded"), rs.getString("description"),
                        rs.getString("organization"), rs.getString("link"),
                        rs.getString("category"), rs.getDouble("price"),
                        rs.getDouble("rating"), verified, null);
                searchResult.add(app);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return searchResult;
	}

	private static ArrayList<Application> searchByCategory(String category) {
        ArrayList<Application> searchResult = new ArrayList<>();
        String sql = "SELECT * FROM Application WHERE isVerified = 1 AND category LIKE ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category);
            ResultSet rs    = pstmt.executeQuery();
            while (rs.next()) {
                boolean verified = false;
                if (rs.getInt("isVerified") == 1) {
                    verified = true;
                }
                Application app = new Application(rs.getString("name"), rs.getString("userAdded"),
                        rs.getString("dateAdded"), rs.getString("description"),
                        rs.getString("organization"), rs.getString("link"),
                        rs.getString("category"), rs.getDouble("price"),
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
			String usrInput = text.getText();
			ArrayList<Application> searchResults = new ArrayList<>(); // figure out how access the user input
		    if (filter.getSelectedItem() == "Category") {
				searchResults = searchByCategory(usrInput); 
			} else if (filter.getSelectedItem() == "Rating"){
				
			} else {
				searchResults = searchVerifiedApps(usrInput); 
			}
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
