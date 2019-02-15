package edu.neumont.bell.model;

import java.util.List;

public class Patient extends Person{

	private InsuranceInfo insurance;
	private PaymentCard paymentCard;
	
	public Patient() {}
	
	public Patient(String fn, String ln, int uid, String em, String pn, InsuranceInfo in, PaymentCard pc) {
		super(fn, ln, uid, em, pn);
		this.setInsurance(in);
		this.setPaymentCard(pc);
	}
	
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
	public int getAccountBalance(List<Payment> payments, List<ProcedureRecord> procidures) {
		int bal = 0;
		for(Payment pay: payments) {
			bal += pay.getAmount();
		}
		for(ProcedureRecord pro : procidures) {
			bal -= pro.getCost();
		}
		
		return bal;
	}
	
	
}
