package edu.neumont.bell.model;

public class Person {

	private String firstName;
	private String lastName;
	private int uniqueId;
	private String email;
	private long phoneNumber;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phoneNumber;
	}
	public void setPhone(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
