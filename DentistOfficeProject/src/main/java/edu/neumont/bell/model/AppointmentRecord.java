package edu.neumont.bell.model;

import java.util.List;

public class AppointmentRecord {

	private List<ProcedureRecord> procedures;

	public List<ProcedureRecord> getProcedures() {
		return procedures;
	}

	public void setProcedures(List<ProcedureRecord> procedures) {
		this.procedures = procedures;
	}
	
}
