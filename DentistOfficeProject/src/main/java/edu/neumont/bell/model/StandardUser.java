package edu.neumont.bell.model;

import edu.neumont.bell.View.View;

public class StandardUser extends User{

	private View view = new View();
	
	public StandardUser() {};
	
	public StandardUser(String un, String pass, UserRole r) {
		super(un, pass, r);
	}
	
	public void runStandard(int choice, User current) {
		
		switch(choice) {
		case 1:
			view(current);
			break;
		case 2:
			editStandard(current);
			break;
		}
		
	}
	
	private void editStandard(User current) {
		int choice = view.askForInput("Please choise one;\n1. Change Username\2. Change Password\nEnter here: ", 1, 2);
		switch(choice) {
		case 1:
			current.setUsername(view.getInput("Please enter the new username: ", false));
			break;
		case 2:
			current.setPassword(view.getInput("Please enter the new password: ", false));
			break;
		}
	}
}
