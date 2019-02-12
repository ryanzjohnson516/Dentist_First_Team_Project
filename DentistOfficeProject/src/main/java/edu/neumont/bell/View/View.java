package edu.neumont.bell.View;

import lib.ConsoleIO;

public class View {

	public int askForInput(String string, int i, int j) {
		return ConsoleIO.promptForInt(string, i, j);
	}

	public String getString(String oldPass) {
		String newPass = null;
		Boolean isSame = false;
		do {
			isSame = false;
			newPass =  ConsoleIO.promptForInput("You must change your password, what would you like it to be?", false);
			if(newPass.equals(oldPass)) {
				isSame = true;
			}
		}while(isSame);
		return newPass;
	}
}
