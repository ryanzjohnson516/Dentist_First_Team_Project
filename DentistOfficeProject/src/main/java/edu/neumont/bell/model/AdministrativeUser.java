package edu.neumont.bell.model;

import edu.neumont.bell.Controller.Controller;
import edu.neumont.bell.View.View;

public class AdministrativeUser extends User{
	
	public AdministrativeUser() {};
	
	public AdministrativeUser(String un, String pass, UserRole r) {
		super(un, pass, r);
	}
	
	public void runAdmin(int askForInput, User current) {
		// TODO Auto-generated method stub
		
	}

	public void changePassword(User user, String password) {
		user.setPassword(password);
	}
	
	public void addUser(User user) {
		Controller.clinic.addUser(user);
	}
	
	public void removeUser(User user) {
		Controller.clinic.removeUser(user);
	}
	
	public void changeRole(User user, UserRole role) {
		user.setRole(role);
	}
	
	
}
