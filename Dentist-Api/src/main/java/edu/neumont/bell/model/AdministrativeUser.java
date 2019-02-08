package edu.neumont.bell.model;

import java.util.ArrayList;

import lib.ConsoleIO;

public class AdministrativeUser extends ArrayList<User>{

	private static final long serialVersionUID = 1L;

	public void changePassword(User user) {
		String prompt = "Enter new Password: ";
		user.setPassword(ConsoleIO.promptForInput(prompt, false));
	}
	
	public void addUser(User user) {
		this.add(user);
	}
	
	public void removeUser(User user) {
		this.removeUser(user);
	}
	
	public void changeRole(User user, UserRole role) {
		user.setRole(role);
	}
}
