package edu.neumont.bell.model;

import java.time.LocalDate;
import java.util.Date;

public class PaymentCard {

	private long number;
	private Date expires;
	private String name;
	private int cvv;
	private String postalCode;
	
	public PaymentCard() {}
	
	public PaymentCard(long num, Date ex, String na, int cv, String pc) {
		this.setNumber(num);
		this.setExpires(ex);
		this.setName(na);
		this.setCvv(cv);
		this.setPostalCode(pc);
	}
	
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public Date getExpires() {
		return expires;
	}
	public void setExpires(Date expires) {
		this.expires = expires;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
