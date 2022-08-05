import java.time.LocalDate;
import java.util.ArrayList;

public class C206_CaseStudy {

	private static ArrayList<admin_Class> userList = new ArrayList<admin_Class>();
	private static ArrayList <QuotationRequests> requestQuotationList = new ArrayList<QuotationRequests>();
	private static ArrayList <Quotations> quotationList = new ArrayList<Quotations>();
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_QUIT = 4;
	private static String qID = "";
	private static String rID = "";
	private static String rId = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C206_CaseStudy mw = new C206_CaseStudy();
		
		userList.add(new admin_Class("Bob", "User", "bob@mail.com", "SecurePa$sW0rd"));	
		userList.add(new admin_Class("Alice", "User", "bob@mail.com", "SecurePa$sW0rd"));	
		userList.add(new admin_Class("Charile", "User", "bob@mail.com", "SecurePa$sW0rd"));	
		userList.add(new admin_Class("Emily", "User", "bob@mail.com", "SecurePa$sW0rd"));	
		
		requestQuotationList.add(new QuotationRequests("HDB", 85, "John", 97324510, "john@mail.com", 640.00, "2022/7/21", 700.00, "Toilet", 6, 4, "No", "Yes"));
		requestQuotationList.add(new QuotationRequests("HDB", 70, "David", 67014597, "david@mail.com", 251.00, "2022/7/21", 550.00, "Whole House", 5, 3, "No", "No"));
		requestQuotationList.add(new QuotationRequests("Landed", 420, "Adam", 91336502, "adam@mail.com", 946.00, "2022/7/21", 220.00, "Room", 8, 3, "Modern", "No"));
		requestQuotationList.add(new QuotationRequests("Private", 98, "Ben", 67882174, "ben@mail.com", 508.00, "2022/7/21", 600.00, "Kitchen", 4, 2, "No", "Yes"));
		
		quotationList.add(new Quotations("RV001", "QT001", "Kitchen", "Flooring", 550.00, "Anne", LocalDate.of(2022, 10, 8), 700.00));
		quotationList.add(new Quotations("RV001", "QT002", "Bedroom", "Closet", 350.00, "Anne", LocalDate.of(2022, 10, 12), 550.00));
		quotationList.add(new Quotations("RV002", "QT003", "Living Room", "Door", 200.00, "Ben", LocalDate.of(2022, 12, 14), 220.00));
		quotationList.add(new Quotations("RV003", "QT004", "Toilet", "Flooring", 550.00, "Carrol", LocalDate.of(2023, 05, 9), 600.00));
		
		mw.start();
	}
	
	public void start() {
		int option = -1;
		while (option != 4) {
			menu();
			option = Helper.readInt("Enter choice > ");
			if (option == 1) {
				adminPage();
			} else if (option == 2) {
				customerPage();
			} else if (option == 3) {
				designersPage();
			}else if (option == 4) {
				System.out.println("Thank You~");
			}
		}
	}
	
	public static void setHeader(String header) {
		Helper.line(145, "-");
		System.out.println(header);
		Helper.line(145, "-");
	}
	
	public void adminPage() {
		int option = -1;
		while (option != 4) {
			menuAdmin();
			option = Helper.readInt("Enter choice > ");
			if (option == OPTION_VIEW) {
				viewAllusers();
			} else if (option == OPTION_ADD) {
				addUsers();
			} else if (option == OPTION_DELETE) {
				deleteUserbyName();
			}else if (option == OPTION_QUIT) {
				System.out.println("Thank You~");
			}
		}
	}
		
	private void menu() {
		C206_CaseStudy.setHeader("Home Page");
		System.out.println("1. Admin");
		System.out.println("2. Customer");
		System.out.println("3. Designer");
		System.out.println("4. Quit");
	}
	
	private void menuAdmin() {
		C206_CaseStudy.setHeader("Admin Interface");
		System.out.println("1. View All Users");
		System.out.println("2. Adding New Users");
		System.out.println("3. Deleting Users by Name");
		System.out.println("4. Quit");
	}
		
	public void addUsers() {
		String name = Helper.readString("Enter New User's Name: ");
		String role = Helper.readString("Enter Role: ");
		String email = Helper.readString("Enter Email: ");
		String password = Helper.readString("Enter Passowrd: ");
		
		if (!name.isEmpty() && !role.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
			userList.add(new admin_Class(name, role, email, password));
			System.out.println("New User Added");
		}else {
			System.out.println("Please enter a valid input");
		}
	}	
		
	public void viewAllusers() {
		String output = String.format("%-10s %-10s %-20s %-20s %-10s\n", "Name", "role", "email", "password", "status");
		for (admin_Class x : userList) {
			output += String.format("%-10s %-10s %-20s %-20s %-10s\n", x.getName(), x.getRole(), x.getEmail(), x.getPassword(), x.getStatus());
			}
		System.out.println(output);
	}
	
	public void deleteUserbyName() {
		String userInput = Helper.readString("Enter User's Name: ");
		int x =0;
		while (x < userList.size()) {
			if (userList.get(x).getName().equalsIgnoreCase(userInput)) {
				userList.remove(x);
				System.out.println("User Removed");
			}
			x++;
		}
		if (x == userList.size() && x != 0) {
			System.out.println("User Not Found");
		}else if (x == 0) {
			System.out.println("List is Currently Empty");
		}
	}
	
	
	public void customerPage() {
		//Add what customer can do
		int option = -1;
		while (option != 4) {
			menuCustomer();
			option = Helper.readInt("Enter choice > ");
			if (option == OPTION_VIEW) {
				addQuotationRequest();
			} else if (option == OPTION_ADD) {
				viewAllRequests();
			} else if (option == OPTION_DELETE) {
				deleteQuotationRequest();
			}else if (option == OPTION_QUIT) {
				System.out.println("Thank You :D");
			}
		}
	}
		
	private void menuCustomer() {
		C206_CaseStudy.setHeader("Customer Interface");
		System.out.println("1. Add Quotation Requests");
		System.out.println("2. View All Quotation Requests");
		System.out.println("3. Deleting Quotation Requests by Requestor Name");
		System.out.println("4. Quit");
		
		}
	
	
	public void addQuotationRequest() {
		String propertyType = Helper.readString("Enter your property type: ");
	    double areaSize = Helper.readDouble("Enter your area size: ");
	    String requestorName = Helper.readString("Enter your Requestor Name: ");
	    int contactNumber = Helper.readInt("Enter your contact number: ");
		String email = Helper.readString("Enter your email: ");
		double budget = Helper.readDouble("Enter your budget: ");
		String completionDate = Helper.readString("Enter your Target Completion Date: ");
		String renovationType = Helper.readString("Enter your Renovation Type: ");
		int numberOfRooms = Helper.readInt("Enter your number of rooms: ");
		int numberOfToilets = Helper.readInt("Enter your number of toilets: ");
		String renovationStyle = Helper.readString("Enter your Renovation Style: ");
		String urgentRequest = Helper.readString("Is it an urgent request?: ");
		
		if(!propertyType.isEmpty() && areaSize >= 0 & !requestorName.isEmpty() && contactNumber >= 0 && !email.isEmpty() && budget > 0 && !completionDate.isEmpty()  && !renovationType.isEmpty() && numberOfRooms >= 0 && numberOfToilets >= 0 && !renovationStyle.isEmpty() && !urgentRequest.isEmpty()) {
			requestQuotationList.add(new QuotationRequests(propertyType, areaSize, requestorName, contactNumber, email, budget, completionDate, renovationType, numberOfRooms, numberOfToilets, renovationStyle, urgentRequest));
			System.out.println("Quotation Request added successfully.");
		}
		else {
			System.out.println("Quotation Request failed.");
		}
		
	}
	
	public void viewAllRequests() {
		String output = String.format("\n%-13s %-15s %-22s %-18s %-24s %-11s %-13s %-15s\n", "Property Type", "Area Size", "Requestor Name", "Contact Number", "Email", "Budget", "Completion Date", "Renovation Type", "Number of Rooms", "Number of Toilets", "Renovation Style (optional)", "Urgent Request?");
		for (QuotationRequests qr : requestQuotationList) {
			output += String.format("%-84s\n", qr.toString());
		}
		System.out.println(output);
	}
		
	public void deleteQuotationRequest() {
			boolean deleted = false;
			String requestorName = Helper.readString("\nEnter Requestor Name > ");
			for (int qr = 0; qr < quotationList.size(); qr++) {
				if (requestQuotationList.get(qr).getRequestorName().equals(requestorName)) {
					requestQuotationList.remove(qr);
					deleted = true;
				}
			}
			if(deleted == true) {
				System.out.println("Request removed successfully.");
			}
			else {
				System.out.println("Could not remove Request.");
			}
		}
	
	public void designersPage() {
		//Add what designers can do
		int option = -1;
		while (option != 4) {
			menuDesigner();
			option = Helper.readInt("Enter choice > ");
			
			if (option == OPTION_VIEW) {
				rId = Helper.readString("Enter request id > ");
				C206_CaseStudy.viewAllQuotation(quotationList);
				
			} else if (option == OPTION_ADD) {
				Quotations qt = inputQuotation();
				C206_CaseStudy.addQuotation(quotationList, qt);
				
			} else if (option == OPTION_DELETE) {
				String Qid = Helper.readString("\nEnter quotation id > ");
				C206_CaseStudy.deleteQuotation(quotationList, Qid);
				
			}else if (option == OPTION_QUIT) {
				System.out.println("Thank You~");
			}
		}
	}
	
	private void menuDesigner() {
		C206_CaseStudy.setHeader("Designer Interface");
		System.out.println("1. View All Quotations");
		System.out.println("2. Add New Quotations");
		System.out.println("3. Delete Quotations by Quotation_ID");
		System.out.println("4. Quit");
	}
	
	public static String retrieveAllQuotation(ArrayList<Quotations> quotationList, String rId) {
		boolean found = false;
		String output = "";
		String output1 = "";
		
		if(quotationList.size() == 0) {
			found = false;
		}
		else {
			for(Quotations q : quotationList) {
				if (q.getRID().equalsIgnoreCase(rId)) {
					output1 += String.format("%-84s\n", q.toString());
					found = true;
				}
			}
		}
		if(found == true) {
			output += String.format("\n%-13s %-15s %-22s %-18s %-24s %-11s %-13s %-15s\n", "REQUEST_ID", "QUOTATION_ID", "RENOVATION CATEGORY", "RENOVATION ITEM", "RENOVATION ITEM PRICE", "DESIGNER", "START DATE", "TOTAL QUOTATION SUM");
			output += output1;
		}
		else {
			output = "Request_ID not found.";
		}
		
		return output;
	}
	
	public static void viewAllQuotation(ArrayList<Quotations> quotationList) {
		String output = "";
		output += retrieveAllQuotation(quotationList, rId);
		System.out.println(output);
	}
	
	public Quotations inputQuotation() {
		Quotations qt = new Quotations("", "", "", "", 0, "", LocalDate.now(), 0);
		rID += Helper.readString("\nEnter request id > ");
		qID += Helper.readString("Enter quotation id > ");
		String rc = Helper.readString("Enter renovation catergory > ");
		String rcItem = Helper.readString("Enter renovation item > ");
		double itemPrice = Helper.readDouble("Enter price of renovation item > ");
		String dName = Helper.readString("Enter designer name > ");
		int sDDate = Helper.readInt("Enter day in month of start date > ");
		int sMDate = Helper.readInt("Enter month of start date > ");
		int sYDate = Helper.readInt("Enter year of start date > ");
		double tSum = Helper.readDouble("Enter total quotation amount > ");

		if(!rID.isEmpty() && !qID.isEmpty() & !rc.isEmpty() && !rcItem.isEmpty() && itemPrice > 0 && !dName.isEmpty() && sDDate > 0 && sMDate > 0 && sYDate > 0 && tSum > 0) {
			qt = new Quotations(rID, qID, rc, rcItem, itemPrice, dName, LocalDate.of(sYDate, sMDate, sDDate), tSum);
		}
		return qt;
	}
	
	public static void addQuotation(ArrayList<Quotations> quotationList, Quotations qt) {
		boolean canAdd = false;
		if(quotationList.size() == 0) {
			canAdd = true;
		}
		else {
			for (int q = 0; q < quotationList.size(); q++) {
				if (!quotationList.get(q).getQID().equalsIgnoreCase(qID)) {
					canAdd = true;
				}
				else {
					canAdd = false;
				}
			}
		}
	
		if(canAdd == true) {
			quotationList.add(qt);
			System.out.println("Quotation added successfully.");
		}
		else {
			System.out.println("Quotation failed to add.");
		}
	}
	
	public static void deleteQuotation(ArrayList<Quotations> quotationList, String Qid) {
		boolean isDeleted = false;
		if(quotationList.size() == 0) {
			isDeleted = true;
		}
		else {
			for (int q = 0; q < quotationList.size(); q++) {
				if (quotationList.get(q).getQID().equalsIgnoreCase(Qid)) {
					quotationList.remove(q);
					isDeleted = true;
				}
			}
		}
		if(isDeleted == true) {
			System.out.println("Quotation deleted successfully.");
		}
		else {
			System.out.println("Quotation failed to delete.");
		}
	}
}



