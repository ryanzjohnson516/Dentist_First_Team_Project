package edu.neumont.bell.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.neumont.bell.View.View;

public class Clinic {

	private List<User> users = new ArrayList<>();
	private List<Patient> patients = new ArrayList<>();
	private List<Provider> providers = new ArrayList<>();
	private List<Payment> payments = new ArrayList<>();
	private List<ProcedureRecord> procidures = new ArrayList<>();
	private List<Appointment> appointments = new ArrayList<>();
	private LocalDate now = LocalDate.now();
	private View view = new View();

	public void run() {
		StandardUser su = new StandardUser();
		AdministrativeUser au = new AdministrativeUser();

		loadClinic();
		int choice = view.askForInput("Pick one:\n3. Tests\n2. Search\n3. Login\nEnter here: ", 1, 3);
		if (choice == 1) {
			tests();
		}else if(choice == 2) {
			search();
		}else if(choice == 3){
			User current = login();
			if (!users.isEmpty()) {
				changePass(current);
			}
			if (current instanceof AdministrativeUser) {
				au.runAdmin(view.askForInput("", 1, 3), current);
			} else {
				su.runStandard(view.askForInput("Please chose one:\n1. View current information\n2. Edit information\nEnter here: ", 1, 2), current);
			}
		}else {
			view.out("A problem happened in run, choice was not 1-3.");
		}
	}

	private void search() {
		int choice = view.askForInput("Pick one:\n1. Search users \n2. Search patients \n3. Search providers\n4. Search payments\n5. Search procidures\n6. search appointments\nEnter here: ", 1, 6);
		
		switch(choice) {
		case 1:
			String un = view.getInput("Username to search by: ", true);
			String ps = view.getInput("Password to search by: ", true);
			for(User u : users) {
				if(u.getPassword().equals(ps) && u.getUsername().equals(un)){
						u.view(u);
						return;
				}
			}
			break;
		case 2:
			// TODO Auto-generated method stub
			break;
		case 3:
			// TODO Auto-generated method stub
			break;
		case 4:
			// TODO Auto-generated method stub
			break;
		case 5:
			// TODO Auto-generated method stub
			break;
		case 6:
			// TODO Auto-generated method stub
			break;
		}
	}

	private void tests() {
		// TODO Auto-generated method stub
		
	}

	private void changePass(User current) {
		if (current.getPassword().equals("1234Password") && current.getUsername().equals("Administrator")) {
			current.setPassword(view.getString(current.getPassword()));
		}
	}

	private void loadClinic() {
		// TODO Auto-generated method stub

	}

	private void saveClinic() {
		// TODO Auto-generated method stub
	}

	private User login() {
		if (!users.isEmpty()) {
			String un = view.getInput("Please enter the username: ", false);
			String pss = view.getInput("Please enter the password: ", false);

			for (User u : users) {
				if (u.getUsername().equalsIgnoreCase(un) && u.getPassword().equals(pss)) {
					return u;
				} else {
					view.out("No user was found.");
					return null;
				}
			}
		} else {
			boolean newUser = view.getBool("No users are loaded in, would you like to add one? (Y,N): ");
			if (newUser) {
				UserRole role = UserRole.Administrative;
				addUser(new User(view.getInput("Enter Username: ", false), view.getInput("Enter Password: ", false),
						role));
			} else {
				view.out("No user is being added.");
			}
		}
		return null;
	}

	public List<Appointment> getFutureAppointments() {
		List<Appointment> futureAppointments = new ArrayList<>();
		for (Appointment i : appointments) {
			if (i.getDatetime().isAfter(now)) {
				futureAppointments.add(i);
			}
		}
		return futureAppointments;
	}

	public List<Appointment> getPastAppointments() {
		List<Appointment> pastAppointments = new ArrayList<>();
		for (Appointment i : appointments) {
			if (i.getDatetime().isBefore(now)) {
				pastAppointments.add(i);
			}
		}
		return pastAppointments;
	}

	public Provider searchProvider(ProviderType something) {
		Provider pro = new Provider();
		for (Provider p : providers) {
			if (p.getTitle().equals(something)) {
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
		for (Patient p : patients) {
			if (p.getUniqueId() == patientid) {
				bal = p.getAccountBalance(getMyPayments(p), getMyProcidures(p));
			}
		}
		return bal;
	}

	private List<ProcedureRecord> getMyProcidures(Patient p) {
		List<ProcedureRecord> myProcedures = new ArrayList<>();
		for (ProcedureRecord pro : procidures) {
			if (pro.getPatient().equals(p)) {
				myProcedures.add(pro);
			}
		}
		return myProcedures;
	}

	public Patient searchPatient(int patientid) {
		Patient pat = new Patient();
		for (Patient p : patients) {
			if (p.getUniqueId() == patientid) {
				pat = p;
			}
		}
		return pat;
	}

	public Appointment searchAppointment(int something) {
		Appointment app = new Appointment();
		app = null;
		for (Appointment a : appointments) {
			if (a.getUniqueId() == something) {
				app = a;
			}
		}
		return app;
	}

	private List<Payment> getMyPayments(Patient patient) {
		List<Payment> myPayments = new ArrayList<>();
		for (Payment pay : payments) {
			if (pay.getPatient().equals(patient)) {
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

	public void removeUser(User user) {
		for (User u : users) {
			if (u.equalTo(user)) {
				users.remove(u);
			}
		}
	}
}
