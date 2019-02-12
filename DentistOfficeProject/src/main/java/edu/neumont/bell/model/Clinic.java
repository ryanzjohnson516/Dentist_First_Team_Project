package edu.neumont.bell.model;

import java.time.LocalDate;
import java.util.List;

import View.View;

public class Clinic {
	
	private List<Patient> patients;
	private List<Provider> providers;
	private List<Payment> payments;
	private List<Appointment> appointments;
	private List<Appointment> futureAppointments;
	private List<Appointment> pastAppointments;
	private LocalDate now = LocalDate.now();
	
	public List<Appointment> getFutureAppointments(){
		for(Appointment i: appointments) {
			if(i.getDatetime().isAfter(now)) {
				futureAppointments.add(i);
			}
		}
		return futureAppointments;
	}
	
	public List<Appointment> getPastAppointments(){
		for(Appointment i: appointments) {
			if(i.getDatetime().isBefore(now)) {
				pastAppointments.add(i);
			}
		}
		return pastAppointments;
	}
	
	public Provider searchProvider(ProviderType something){
		Provider pro = new Provider();
		for(Provider p: providers) {
			if(p.getTitle().equals(something)) {
				pro = p;
			}
		}
		return pro;
	}
	
	public void receivePayment(Payment payment) {
		payments.add(payment);
	}
	
	public double getAccountBalance(int patientid) {
		int bal = 0;
		for(Patient p : patients) {
			if(p.getUniqueId() == patientid) {
				bal = p.getAccountBalance();
			}
		}
		return bal;
	}
	
	public Patient searchPatient(int patientid){
		Patient pat = new Patient();
		for(Patient p: patients) {
			if(p.getUniqueId() == patientid) {
				pat = p;
			}
		}
		return pat;
	}
	
	public Appointment searchAppointment(int something){
		Appointment app = new Appointment();
		app = null;
		for(Appointment a: appointments) {
			if(a.getUniqueId()==something) {
				app = a;
			}
		}
		if(app == null) {
			View.out("no appointment could be found with that id");
		}
		return app;
	}
	
}
