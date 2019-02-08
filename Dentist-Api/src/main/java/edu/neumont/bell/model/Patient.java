package edu.neumont.bell.model;

import java.util.List;

public class Patient extends Person{

	private InsuranceInfo insurance;
	private PaymentCard paymentCard;
	private List<Procedure> account;
	
	public InsuranceInfo getInsurance() {
		return insurance;
	}
	public void setInsurance(InsuranceInfo insurance) {
		this.insurance = insurance;
	}
	public PaymentCard getPaymentCard() {
		return paymentCard;
	}
	public void setPaymentCard(PaymentCard paymentCard) {
		this.paymentCard = paymentCard;
	}
	public List<Procedure> getAccount() {
		return account;
	}
	public void setAccount(List<Procedure> account) {
		this.account = account;
	}
	
}
