package edu.neumont.bell.model;

public class Person {

	private String firstName;
	private String lastName;
	private int uniqueId;
	private String email;
	private String phone;
	
	public Person () {}
	
	public Person(String fn, String ln, int uid, String em, String pn) {
		this.setFirstName(fn);
		this.setLastName(ln);
		this.setUniqueId(uid);
		this.setEmail(em);
		this.setPhone(pn);
	}
	
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
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
