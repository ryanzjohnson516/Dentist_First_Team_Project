package edu.neumont.bell.model;

import edu.neumont.bell.View.View;

public class StandardUser extends User{

	private View view = new View();
	
	public StandardUser() {};
	
	public StandardUser(String un, String pass, UserRole r) {
		super(un, pass, r);
	}
	
	
	
	
}
