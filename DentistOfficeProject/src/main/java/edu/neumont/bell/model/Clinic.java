package edu.neumont.bell.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.neumont.bell.View.View;

public class Clinic {

	private List<User> users = new ArrayList<>();
	private List<Patient> patients = new ArrayList<>();
	private List<Provider> providers = new ArrayList<>();
	private List<Payment> payments = new ArrayList<>();
	private List<ProcedureRecord> procidureRecords = new ArrayList<>();
	private List<Procedure> procidures = new ArrayList<>();
	private List<Appointment> appointments = new ArrayList<>();
	private Date now = new Date(2019,2,15);
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
				}else {
					view.out("No user was found under these credentials.");
				}
			}
			break;
		case 2:
			String fn = view.getInput("Enter the first name: ", false);
			String ln = view.getInput("Enter the last name: ", false);
			List<Patient> p = searchPatient(fn, ln);
			for(Patient pat : p) {
			view.out("First name: " + pat.getFirstName() + "Last name: " + pat.getLastName() + "Email: " + pat.getEmail());
			}
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
			if (i.getDatetime().after(now)) {
				futureAppointments.add(i);
			}
		}
		return futureAppointments;
	}

	public List<Appointment> getPastAppointments() {
		List<Appointment> pastAppointments = new ArrayList<>();
		for (Appointment i : appointments) {
			if (i.getDatetime().before(now)) {
				pastAppointments.add(i);
			}
		}
		return pastAppointments;
	}

	public List<Provider> searchProvider(ProviderType something) {
		List<Provider> pro = new ArrayList<>();
		for (Provider p : providers) {
			if (p.getTitle().equals(something)) {
				pro.add(p);
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
		for (ProcedureRecord pro : procidureRecords) {
			if (pro.getPatient().equals(p)) {
				myProcedures.add(pro);
			}
		}
		return myProcedures;
	}

	public List<Patient> searchPatient(String fn, String ln) {
		List<Patient> pat = new ArrayList<>();
		for (Patient p : patients) {
			if (p.getFirstName().equals(fn) && p.getLastName().equals(ln)) {
				pat.add(p);
			}
		}
		return pat;
	}

	public List<Appointment> searchAppointment(int something) {
		List<Appointment> app = new ArrayList<>();
		for (Appointment a : appointments) {
			if (a.getUniqueId() == something) {
				app.add(a);
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
	
	private void createstandardUser() {
		String username =view.getInput("Please enter a username: ", false);
		String password = view.getInput("Please enter a password: ", false);
		User u = new User(username,password,UserRole.Standard);
		addUser(u);
	}
	
	private void createAdminUser() {
		String username =view.getInput("Please enter a username: ", false);
		String password = view.getInput("Please enter a password: ", false);
		User u = new User(username,password,UserRole.Administrative);
		addUser(u);
	}
	
	private void createAppointment() {
		int day = view.askForInput("Please enter the day: ", 1, 31);
		int month = view.askForInput("Please enter the month: ", 1, 12);
		int year = view.askForInput("please enter the year: ", 2000, 2050);
		Date date = new Date(day,month,year);
		int uid = appointments.size() + 1;
		Appointment app = new Appointment(date,uid);
	}
	
	private void createProcedure() {
		String code = view.getInput("Please enter the code: ", false);
		String Description = view.getInput("Please enter a description: ", false);
		Double doub = view.getDouble("Please enter the price: ", false);
		Procedure proc = new Procedure(code, Description, doub);
	}
	
	private void createPatient() {
		
	}
}
