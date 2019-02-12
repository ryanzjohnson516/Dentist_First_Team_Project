package edu.neumont.bell.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.neumont.bell.View.View;

public class Clinic {
	
	private List<User> users;
	private List<Patient> patients;
	private List<Provider> providers;
	private List<Payment> payments;
	private List<ProcedureRecord> procidures;
	private List<Appointment> appointments;
	private LocalDate now = LocalDate.now();
	private View view = new View();
	
	public void run() {
		loadClinic();
		User current = login();
		changePass(current);
		
		if(current instanceof AdministrativeUser) {
			runAdmin(view.askForInput("", 1, 3));
		}else {
			runStandard(view.askForInput("", 1, 3));
		}
		
	}
	
	private void runStandard(int askForInput) {
		// TODO Auto-generated method stub
		
	}

	private void runAdmin(int askForInput) {
		// TODO Auto-generated method stub
		
	}

	private void changePass(User current) {
		if(current.getPassword().equals("1234Password") && current.getUsername().equals("Administrator")) {
			current.setPassword(view.getString(current.getPassword()));
		}
	}

	private void loadClinic() {
		// TODO Auto-generated method stub
		
	}

	private User login() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Appointment> getFutureAppointments(){
		List<Appointment> futureAppointments = new ArrayList<>();
		for(Appointment i: appointments) {
			if(i.getDatetime().isAfter(now)) {
				futureAppointments.add(i);
			}
		}
		return futureAppointments;
	}
	
	public List<Appointment> getPastAppointments(){
		List<Appointment> pastAppointments = new ArrayList<>();
		for(Appointment i: appointments) {
			if(i.getDatetime().isBefore(now)) {
				pastAppointments.add(i);
			}
		}
		return pastAppointments;
	}
	
	public Provider searchProvider(ProviderType something){
		Provider pro = new Provider();
		for(Provider p: providers) {
			if(p.getTitle().equals(something)) {
				pro = p;
			}
		}
		return pro;
	}
	
	public void receivePayment(Payment payment) {
		payments.add(payment);
	}
	
	public double getAccountBalance(int patientid) {
		int bal = 0;
		for(Patient p : patients) {
			if(p.getUniqueId() == patientid) {
				bal = p.getAccountBalance(getMyPayments(p), getMyProcidures(p));
			}
		}
		return bal;
	}
	
	private List<ProcedureRecord> getMyProcidures(Patient p) {
		List<ProcedureRecord> myProcedures = new ArrayList<>();
		for(ProcedureRecord pro : procidures) {
			if(pro.getPatient().equals(p)) {
				myProcedures.add(pro);
			}
		}
		return myProcedures;
	}

	public Patient searchPatient(int patientid){
		Patient pat = new Patient();
		for(Patient p: patients) {
			if(p.getUniqueId() == patientid) {
				pat = p;
			}
		}
		return pat;
	}
	
	public Appointment searchAppointment(int something){
		Appointment app = new Appointment();
		app = null;
		for(Appointment a: appointments) {
			if(a.getUniqueId()==something) {
				app = a;
			}
		}
		return app;
	}
	
	private List<Payment> getMyPayments(Patient patient) {
		List<Payment> myPayments = new ArrayList<>();
		for(Payment pay : payments) {
			if(pay.getPatient().equals(patient)) {
				myPayments.add(pay);
			}
		}
		return myPayments;
		
	}

	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	public void addUser(User user) {
		users.add(user);
	}
	public void removeUser (User user) {
		for(User u: users) {
			if(u.equalTo(user)) {
				users.remove(u);
			}
		}
	}
}
