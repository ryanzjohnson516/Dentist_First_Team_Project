package edu.neumont.bell.model;

import java.time.LocalDate;

public class PaymentCard {

	private long number;
	private LocalDate expires;
	private String name;
	private int cvv;
	private String postalCode;
	
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public LocalDate getExpires() {
		return expires;
	}
	public void setExpires(LocalDate expires) {
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
