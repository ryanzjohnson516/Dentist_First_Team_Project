package edu.neumont.bell.model;

public class AdministrativeUser extends User{

	public void changePassword(User user) {
		if(user.getRole() == UserRole.Administrative) {
			
		}
	}
	
	public void addUser(User user) {
		
	}
	
	public void removeUser(User user) {
		
	}
	
	public void changeRole(User user, UserRole role) {
		
	}
}
