package edu.neumont.bell.model;

import java.util.Date;

public class Appointment {

	private Date datetime;
	private int uniqueId;
	
	public Appointment() {}
	
	public Appointment(Date date, int uid) {
		this.setDatetime(date);
		this.setUniqueId(uid);
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}
}
