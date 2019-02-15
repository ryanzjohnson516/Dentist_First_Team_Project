package edu.neumont.bell.model;

public class Procedure {

	private String code;
	private String descirption;
	private double cost;
	
	public Procedure() {}
	
	public Procedure(String code2, String description, Double doub) {
		this.setCode(code2);
		this.setCost(doub);
		this.setDescirption(description);
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescirption() {
		return descirption;
	}
	public void setDescirption(String descirption) {
		this.descirption = descirption;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

}
