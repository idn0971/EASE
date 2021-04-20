package main;

/**
 * 
 * @author laurenbockelman
 * 
 *         User Class for EASE Application
 * 
 *         Copyright (C) 2021 bockellt@maimoh.edu
 *
 */
public class User {
	// instance variables
	private String firstName, lastName, userName, password;
	private boolean isAdmin, access, verify;

	// Assigns instance variables to null and isAdmin to false.
	public User() {
		this.firstName = null;
		this.lastName = null;
		this.userName = null;
		this.password = null;
		;

	}

	// initializes instances variables using the received parameters
	public User(String firstName, String lastName, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	// Initializes the instances variables using user object’s instance variables.
	public User(User user) {
		firstName = user.firstName;
		lastName = user.lastName;
		userName = user.userName;
		password = user.password;
	}

	// Accessor and mutator methods for all instance varibales
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public boolean getIsAdmin() {
		return isAdmin;
	}
	
	public void setAccess(boolean access) {
		this.access = access;
	}
	
	public boolean getAccess() {
		return access;
	}
	/**
	 * this may get moved to an admin class
	 * @param verify
	 */
	public void setVerify(boolean verify) {
		this.verify = verify;
	}
	
	public boolean getVerify() {
		return verify;
	}
	
	// checks if its a user or admin. if admin then has access to request page

	private void adminAccess() {
		if (this.isAdmin == true) {
			this.access = true;
			// --- send to request page ---
			Admin ad = new Admin();
		} else {
			// --- send user to waiting page ---
			// Wait wait = new Wait();
		}
	}
}
