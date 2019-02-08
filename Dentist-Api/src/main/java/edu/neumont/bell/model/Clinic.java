package edu.neumont.bell.model;

import java.util.List;

public class Clinic {

	private List<Provider> providers;
	private List<Payment> payments;
	private List<Appointment> appointments;
	
	public List<Appointment> getFutureAppointments(){
		return null;
	}
	
	public List<Appointment> getPastAppointments(){
		return null;
	}
	
	public List<Provider> searchProvider(String something){
		return null;
	}
	
	public void receivePayment(Payment payment) {
		
	}
	
	public double getAccountBalance(int patientid) {
		
		return 0.0;
	}
	
	public List<Patient> searchPatient(String something){
		return null;
	}
	
	public List<Appointment> searchAppointment(String something){
		return null;
	}
	
}
