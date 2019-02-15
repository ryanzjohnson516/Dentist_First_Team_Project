package edu.neumont.bell.Controller;

import java.io.IOException;

import edu.neumont.bell.model.Clinic;

public class Controller {
	public static Clinic clinic = new Clinic();

	public static void main(String[] args) throws IOException {
		
		clinic.run();
	}
}
