package edu.neumont.bell.model;

public class AdministrativeUser extends User{

	public void changePassword(User user, String password) {
		user.setPassword(password);
	}
	
	public void addUser(User user) {
		
	}
	
	public void removeUser(User user) {
		
	}
	
	public void changeRole(User user, UserRole role) {
		user.setRole(role);
	}
}
