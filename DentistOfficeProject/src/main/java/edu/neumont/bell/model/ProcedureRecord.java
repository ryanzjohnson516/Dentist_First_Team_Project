package edu.neumont.bell.model;

public class ProcedureRecord {

	private Patient patient;
	private Provider provider;
	private Appointment appointment;
	private Procedure procedure;
	private double cost;
	
	public ProcedureRecord() {};
	
	public ProcedureRecord(Patient pat, Provider pro, Appointment app, Procedure proc, double c) {
		this.setPatient(pat);
		this.setProvider(pro);
		this.setAppointment(app);
		this.setProcedure(proc);
		this.setCost(c);
	}
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public Procedure getProcedure() {
		return procedure;
	}
	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
