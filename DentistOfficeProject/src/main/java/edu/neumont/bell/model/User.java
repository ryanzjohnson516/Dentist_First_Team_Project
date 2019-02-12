package edu.neumont.bell.model;

import edu.neumont.bell.View.View;

public class User {

	private View view = new View();
	
	private String username;
	private String password;
	private UserRole role;
	
	public User() {}
	
	public User(String un, String pass, UserRole r) {
		this.setUsername(un);
		this.setPassword(pass);
		this.setRole(r);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	
	public Boolean equalTo(User u) {
		boolean equal = false;
		if(username.equals(u.getUsername()) && password.equals(u.getPassword())) {
			equal = true;
		}
		return equal;
	}
	
	public void view(User current) {
		view.out("Username: " + current.getUsername() + "\nPassword: " + current.getPassword() + "\nRole: " + current.getRole());
	}
}
