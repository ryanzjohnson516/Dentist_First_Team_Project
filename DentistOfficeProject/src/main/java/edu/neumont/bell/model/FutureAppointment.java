package edu.neumont.bell.model;

import java.util.List;

public class FutureAppointment extends Appointment{

	private Patient patient;
	private List<Provider> providers;
	private List<Procedure> procedures;
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public List<Provider> getProviders() {
		return providers;
	}
	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}
	public List<Procedure> getProcedures() {
		return procedures;
	}
	public void setProcedures(List<Procedure> procedures) {
		this.procedures = procedures;
	}
	
	
}
