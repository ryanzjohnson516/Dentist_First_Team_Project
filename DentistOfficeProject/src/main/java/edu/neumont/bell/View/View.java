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

	public void out(String string) {
		System.out.println(string);
	}

	public String getInput(String string, Boolean bol) {
		return ConsoleIO.promptForInput(string, bol);
	}

	public boolean getBool(String string) {
		return ConsoleIO.promptForBool(string, "y", "n");
	}

	public Double getDouble(String string, boolean b) {
		return ConsoleIO.promptForDouble(string, 0, Double.MAX_VALUE);
	}

	public Long getLong(String string) {
		return ConsoleIO.promptForLong(string, 0, Long.MAX_VALUE);
	}
	
	public int getInt(int Int) {
		return ConsoleIO.promptForInt(String, 0, Integer.MAX_VALUE);
	}
}
