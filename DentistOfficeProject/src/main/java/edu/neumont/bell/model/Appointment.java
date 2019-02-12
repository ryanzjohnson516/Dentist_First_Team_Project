package edu.neumont.bell.model;

import java.time.LocalDate;

public class Appointment {

	private LocalDate datetime;
	private int uniqueId;
	
	public Appointment() {}
	
	public Appointment(LocalDate dt, int uid) {
		this.setDatetime(dt);
		this.setUniqueId(uid);
	}

	public LocalDate getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDate datetime) {
		this.datetime = datetime;
	}

	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}
}
