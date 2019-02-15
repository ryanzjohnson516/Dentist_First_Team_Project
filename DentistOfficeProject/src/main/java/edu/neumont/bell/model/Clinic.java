package edu.neumont.bell.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.neumont.bell.View.View;

public class Clinic implements Serializable {

	private static final long serialversionUID = 1L;
	private List<User> users = new ArrayList<>();
	private List<Patient> patients = new ArrayList<>();
	private List<Provider> providers = new ArrayList<>();
	private List<Payment> payments = new ArrayList<>();
	private List<ProcedureRecord> procidureRecords = new ArrayList<>();
	private List<Procedure> procidures = new ArrayList<>();
	private List<Appointment> appointments = new ArrayList<>();
	private Date now = new Date(2019, 2, 15);
	private View view = new View();

	public void run() throws IOException {
		boolean wantsToRunClinic = true;
		do {
			StandardUser su = new StandardUser();
			AdministrativeUser au = new AdministrativeUser();

			//loadClinic();
			int choice = view.askForInput("Pick one:\n3. Tests\n2. Search\n3. Login\nEnter here: ", 1, 3);
			if (choice == 1) {
				tests();
			} else if (choice == 2) {
				search();
			} else if (choice == 3) {
				User current = login();
				if (!users.isEmpty()) {
					changePass(current);
				}
				if (current instanceof AdministrativeUser) {
					runAdmin(view.askForInput("", 1, 7), current);
				} else {
					runStandard(current);
				}
			} else {
				view.out("A problem happened in run, choice was not 1-3.");
			}
		} while (wantsToRunClinic);
		saveClinic();
	}

	private void search() {
		int choice = view.askForInput(
				"Pick one:\n1. Search Users \n2. Search Patients \n3. Search Providers\n4. Search Payments\n5. Search Procedures\n6. Search Appointments\nEnter here: ",
				1, 6);

		switch (choice) {
		case 1:
			String un = view.getInput("Username to search by: ", true);
			String ps = view.getInput("Password to search by: ", true);
			for (User u : users) {
				if (u.getPassword().equals(ps) && u.getUsername().equals(un)) {
					u.view(u);
					return;
				} else {
					view.out("No user was found under these credentials.");
				}
			}
			break;
		case 2:

			String fn = view.getInput("Enter the first name: ", false);
			String ln = view.getInput("Enter the last name: ", false);
			List<Patient> p = searchPatient(fn, ln);
			for (Patient pat : p) {
				view.out("First name: " + pat.getFirstName() + "Last name: " + pat.getLastName() + "Email: "
						+ pat.getEmail());
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

	private void loadClinic() throws IOException {
		FileInputStream file = new FileInputStream("Clinic.txt");
		ObjectInputStream in = new ObjectInputStream(file);
	}

	private void saveClinic() throws IOException {
		FileOutputStream file = new FileOutputStream("Clinic.txt");
		ObjectOutputStream out = new ObjectOutputStream(file);
		out.writeObject(this.getClass());
		out.close();
		file.close();
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

	public List<Appointment> searchAppointment(int id) {
		List<Appointment> app = new ArrayList<>();
		for (Appointment a : appointments) {
			if (a.getUniqueId() == id) {
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

	public void createStandardUser() {
		String username = view.getInput("Please enter a username: ", false);
		String password = view.getInput("Please enter a password: ", false);
		User u = new User(username, password, UserRole.Standard);
		addUser(u);
	}

	public void createAdminUser() {
		String username = view.getInput("Please enter a username: ", false);
		String password = view.getInput("Please enter a password: ", false);
		User u = new User(username, password, UserRole.Administrative);
		addUser(u);
	}

	public Appointment createAppointment() {
		int day = view.askForInput("Please enter the day: ", 1, 31);
		int month = view.askForInput("Please enter the month: ", 1, 12);
		int year = view.askForInput("please enter the year: ", 2000, 2050);
		Date date = new Date(day, month, year);
		int uid = appointments.size() + 1;
		Appointment app = new Appointment(date, uid);
		return app;
	}

	public Procedure createProcedure() {
		String code = view.getInput("Please enter the code: ", false);
		String Description = view.getInput("Please enter a description: ", false);
		Double doub = view.getDouble("Please enter the price: ", false);
		Procedure proc = new Procedure(code, Description, doub);
		return proc;
	}

	public Date createDate() {
		int day = view.askForInput("Please enter the day: ", 1, 31);
		int month = view.askForInput("Please enter the month: ", 1, 12);
		int year = view.askForInput("please enter the year: ", 2000, 2050);
		Date date = new Date(day, month, year);
		return date;
	}

	public PaymentCard createPaymentCard() {
		Long l = view.getLong("Please enter the card number");
		Date d = createDate();
		String name = view.getInput("Please enter the name: ", false);
		int cvv = view.askForInput("Please enter the cvv: ", 100, 999);
		String pc = view.getInput("Please enter the postal code: ", false);
		PaymentCard pay = new PaymentCard(l, d, name, cvv, pc);
		return pay;

	}

	public InsuranceInfo createInsuranceInfo() {
		String name = view.getInput("Please enter the insurance name: ", false);
		String groupID = view.getInput("Please enter the group ID: ", false);
		String memberID = view.getInput("Please enter the member ID: ", false);
		InsuranceInfo ii = new InsuranceInfo(name, groupID, memberID);
		return ii;
	}

	public void createPatient() {
		String fn = view.getInput("Please enter the firstname: ", false);
		String ln = view.getInput("Please enter the last name", false);
		int uid = patients.size() + 1;
		String email = view.getInput("Please enter the email: ", false);
		String pn = view.getInput("Please enter the phone number: ", false);
		InsuranceInfo ii = createInsuranceInfo();
		PaymentCard pc = createPaymentCard();
		Patient pat = new Patient(fn, ln, uid, email, pn, ii, pc);
		patients.add(pat);
	}
	
	private void createProvider() {
		int choice = view.askForInput("Please pick the type of provider: \n1. Dentist\n2. Hygenist\n3. Assistant\n Enter Here: ", 1, 3);
		ProviderType pt = null;
		switch(choice) {
		case 1:
			pt = ProviderType.Dentist;
			break;
		case 2:
			pt = ProviderType.Hygienist;
			break;
		case 3:
			pt = ProviderType.Assistant;
			break;
		}
		Provider pro = new Provider(pt);
		providers.add(pro);
	}

	public void runStandard(User current) {
		boolean wantsToContinue = true;
		do {
			int choice = view.askForInput(
					"Please chose one:\n1. View current information\n2. Edit information\n3. Create Appointment\n4. Create Patient\n5. Create User\n6. Create Provider\n7. Create Procedure\n8. Exit\nEnter here: ",
					1, 7);
		switch (choice) {
		case 1:
			current.view(current);
			break;
		case 2:
			editStandard(current);
			break;
		case 3:
			Appointment app = createAppointment();
			appointments.add(app);
			break;
		case 4:
			createPatient();
			break;
		case 5:
			createstandardUser();
			break;
		case 6:
			createProvider();
			break;
		case 7:
			Procedure pro = createProcedure();
			procidures.add(pro);
			break;
		case 8:
			wantsToContinue = false;
			break;
		}
		}while(wantsToContinue);

	}

	private void editStandard(User current) {
		int choice = view.askForInput("Please choise one;\n1. Change Username\2. Change Password\nEnter here: ", 1, 2);
		switch (choice) {
		case 1:
			current.setUsername(view.getInput("Please enter the new username: ", false));
			break;
		case 2:
			current.setPassword(view.getInput("Please enter the new password: ", false));
			break;

		}
	}
	
	public void runAdmin(int choice, User current) {
		boolean wantsToContinue = true;
		do {
		switch (choice) {
		case 1:
			current.view(current);
			break;
		case 2:
			editStandard(current);
			break;
		case 3:
			Appointment app = createAppointment();
			appointments.add(app);
			break;
		case 4:
			createPatient();
			break;
		case 5:
			int input = view.askForInput("Would you like to create a standard or admin user?\n1. Admin\n2. Standard\nEnter here: ", 1, 2);
			if(input == 1) {
				createAdminUser();
			}else {
				createstandardUser();
			}
			
			break;
		case 6:
			createProvider();
			break;
		case 7:
			Procedure pro = createProcedure();
			procidures.add(pro);
			break;
		case 8:
			wantsToContinue = false;
			break;
		}
		}while(wantsToContinue);

		
	}
}
