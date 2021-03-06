package edu.neumont.bell.model;

public class Payment {

	private double amount;
	private Patient patient;
	private boolean source;
	
	public Payment() {}
	
	public Payment(double am, Patient p, boolean s){
		this.setAmount(am);
		this.setPatient(p);
		this.setSource(s);
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public boolean isSource() {
		return source;
	}
	public void setSource(boolean source) {
		this.source = source;
	}
}
