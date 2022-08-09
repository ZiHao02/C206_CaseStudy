import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


public class C206_CaseStudy {

	private static ArrayList<admin_Class> userList = new ArrayList<admin_Class>();
	private static ArrayList <QuotationRequests> requestQuotationList = new ArrayList<QuotationRequests>();
	private static ArrayList <Quotations> quotationList = new ArrayList<Quotations>();
	private static ArrayList <Package> packageList = new ArrayList<Package>();
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_QUIT = 4;
//	private static String qID = "";
//	private static String rID = "";
	private static String rId = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C206_CaseStudy mw = new C206_CaseStudy();
		
		userList.add(new admin_Class("Bob", "User", "bob@mail.com", "SecurePa$sW0rd"));	
		userList.add(new admin_Class("Alice", "User", "bob@mail.com", "SecurePa$sW0rd"));	
		userList.add(new admin_Class("Charile", "User", "bob@mail.com", "SecurePa$sW0rd"));	
		userList.add(new admin_Class("Emily", "User", "bob@mail.com", "SecurePa$sW0rd"));	
		
		requestQuotationList.add(new QuotationRequests("HDB", 85, "John", 97324510, "john@mail.com", 640.00, "2022/7/21", "Toilet", 6, 4, "No", "Yes"));
		requestQuotationList.add(new QuotationRequests("HDB", 70, "David", 67014597, "david@mail.com", 251.00, "2022/7/21", "Whole House", 5, 3, "No", "No"));
		requestQuotationList.add(new QuotationRequests("Landed", 420, "Adam", 91336502, "adam@mail.com", 946.00, "2022/7/21", "Room", 8, 3, "Modern", "No"));
		requestQuotationList.add(new QuotationRequests("Private", 98, "Ben", 67882174, "ben@mail.com", 508.00, "2022/7/21", "Kitchen", 4, 2, "No", "Yes"));
		
		quotationList.add(new Quotations("RV001", "QT001", "Kitchen", "Flooring", 550.00, "Anne", LocalDate.of(2022, 10, 8), 700.00));
		quotationList.add(new Quotations("RV001", "QT002", "Bedroom", "Closet", 350.00, "Anne", LocalDate.of(2022, 10, 12), 550.00));
		quotationList.add(new Quotations("RV002", "QT003", "Living Room", "Door", 200.00, "Ben", LocalDate.of(2022, 12, 14), 220.00));
		quotationList.add(new Quotations("RV003", "QT004", "Toilet", "Flooring", 550.00, "Carrol", LocalDate.of(2023, 05, 9), 600.00));
		try {
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		packageList.add(new Package("PK1", "First Package", dFormat.parse("2022-01-01"), dFormat.parse("2022-01-02"), 3));
		packageList.add(new Package("PK2", "Second Package", dFormat.parse("2022-01-01"), dFormat.parse("2022-01-02"), 3));
		packageList.add(new Package("PK3", "Third Package", dFormat.parse("2022-01-01"), dFormat.parse("2022-01-02"), 3));
		packageList.add(new Package("PK3", "Fourth Package", dFormat.parse("2022-01-01"), dFormat.parse("2022-01-02"), 3));
		packageList.add(new Package("PK5", "Fifth Package", dFormat.parse("2022-01-01"), dFormat.parse("2022-01-02"), 3));
		packageList.add(new Package("PK6", "Sixth Package", dFormat.parse("2022-01-01"), dFormat.parse("2022-01-02"), 3));
		} catch (Exception e) 
		{
			
		}
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
        while (option != 7) {
            menuAdmin();
            option = Helper.readInt("Enter choice > ");
            if (option == OPTION_VIEW) {
                System.out.println(C206_CaseStudy.viewAllusers(userList));
            } else if (option == OPTION_ADD) {
                admin_Class user = inputUser();
                C206_CaseStudy.addUsers(userList, user);
            } else if (option == OPTION_DELETE) {
                String username = Helper.readString("\nEnter User's name > ");
                C206_CaseStudy.deleteUserbyName(userList, username);
            }
            else if (option == 4) {
                C206_CaseStudy.viewAllPackages(packageList);
            }
            else if (option == 5) {
                C206_CaseStudy.inputPackage(packageList);
            }
            else if (option == 6) {
                String code = Helper.readString("\nEnter package code > ");
                C206_CaseStudy.deletePackage(packageList, code);
            }
            else if (option == OPTION_QUIT) {
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
	
	private static void menuAdmin() {
        C206_CaseStudy.setHeader("Admin Interface");
        System.out.println("1. View All Users");
        System.out.println("2. Adding New Users");
        System.out.println("3. Deleting Users by Name");
        System.out.println("4. View All Packages");
        System.out.println("5. Add Package");
        System.out.println("6. Add Package by Code");
        System.out.println("7. Quit");
    }
	
	// Zi Hao
	public admin_Class inputUser() {
		admin_Class user = new admin_Class("", "", "", "");
		String name = Helper.readString("Enter New User's Name: ");
		String role = Helper.readString("Enter Role: ");
		String email = Helper.readString("Enter Email: ");
		String password = Helper.readString("Enter Passowrd: ");
		if (!name.isEmpty() && !role.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
			user = new admin_Class(name, role, email, password);
		}
		return user;
	}
	
	// Zi Hao
	public static void addUsers(ArrayList<admin_Class> userlist, admin_Class user) {
		boolean canAdd = false;
		if (userlist.size() == 0) {
			canAdd = true;
		}else if (userlist.size() > 0) {
			for (int i = 0; i < userlist.size(); i++) {
				if (!userlist.get(i).getName().equals(user.getName())) {
					canAdd = true;
				}else {
					canAdd = false;
					break;
				}
			}
		}
		if (canAdd) {
			userlist.add(user);
			System.out.println("User added successfully");
		}else {
			System.out.println("User failed to add due to duplicaiton.");
		}
		
	}	
	
	// Zi Hao
	public static String viewAllusers(ArrayList<admin_Class> userlist) {
		String output = String.format("%-10s %-10s %-20s %-20s %-10s\n", "Name", "role", "email", "password", "status");
		String output1 = "No users currently";
		boolean hasUsers = false;
		
		if (userlist.size() == 0) {
			hasUsers = false;
		}else {
			for (admin_Class x : userlist) {
				output += String.format("%-10s %-10s %-20s %-20s %-10s\n", x.getName(), x.getRole(), x.getEmail(), x.getPassword(), x.getStatus());	
				hasUsers = true;
			}
		}
		if (hasUsers) {
			return output;
		}else {
			return output1;
		}
		
	}
	
	// Zi Hao
	public static void deleteUserbyName(ArrayList<admin_Class> userlist, String username) {
		boolean canDelete = false;
		if(userlist.size() == 0) {
			canDelete = true;
		}else {
			for (int i = 0; i < userlist.size(); i++) {
				if (userlist.get(i).getName().equalsIgnoreCase(username)) {
					userlist.remove(i);
					canDelete = true;
				}
			}
		}
		if (canDelete) {
			System.out.println("User deleted successfully");
		}else {
			System.out.println("User failed to delete");
		}	
	}

	//Jaden
	public void customerPage() {
		
		int option = -1;
		while (option != 4) {
			menuCustomer();
			option = Helper.readInt("Enter choice > ");
			
			if (option == OPTION_VIEW) {
				String requestorName = Helper.readString("Enter requestor name > ");
				C206_CaseStudy.viewAllQuotationRequests(requestQuotationList);
				
			} else if (option == OPTION_ADD) {
				QuotationRequests request = inputRequests();
				C206_CaseStudy.addRequests(requestQuotationList, request);
				
			} else if (option == OPTION_DELETE) {
				String requestorName = Helper.readString("\nEnter requestor name > ");
				C206_CaseStudy.deleteRequest(requestQuotationList, requestorName);
				
			}else if (option == OPTION_QUIT) {
				System.out.println("Thank You~");
			}
		}
	}
	
	//Jaden
	private void menuCustomer() {
		C206_CaseStudy.setHeader("Customer Menu");
		System.out.println("1. View All Quotation Requests");
		System.out.println("2. Add New Quotation Requests");
		System.out.println("3. Delete Quotations by Requestor Name");
		System.out.println("4. Quit");
	}
	
	//Jaden
	public static String retrieveAllQuotationRequests(ArrayList<QuotationRequests> requestQuotationslist, String requestorName) {
		boolean found = false;
		String output = "";
		String output1 = "";
		
		if(requestQuotationslist.size() == 0) {
			found = false;
		}
		else {
			for(QuotationRequests qr : requestQuotationList) {
				if (qr.getRequestorName().equalsIgnoreCase(requestorName)) {
					output1 += String.format("%-84s\n", qr.toString());
					found = true;
				}
			}
		}
		if(found == true) {
			output += String.format("\n%-13s %-15s %-22s %-18s %-24s %-11s %-13s %-15s %20s %-10s %-21s\n", "Property Type", "Area Size", "Requestor Name", "Contact Number", "Email", "Budget", "Completion Date", "Renovation Type", "Number of Rooms", "Number of Toilets", "Renovation Style?", "Urgent Request?");
			output += output1;
		}
		else {
			output = ("Requestor Name not found.");
		}
		
		return output;
	}
	
	//Jaden
	public static void viewAllQuotationRequests(ArrayList<QuotationRequests> requestQuotationsList) {
		String output = "";
		output += retrieveAllQuotationRequests(requestQuotationsList, output);
		System.out.println(output);
	}
	
	//Jaden
	public QuotationRequests inputRequests() {
		QuotationRequests request = new QuotationRequests("", 0, "", 0, "", 0, "", "", 0, 0, "", "");
		String propertyType = Helper.readString("\nEnter property type: ");
		double areaSize = Helper.readDouble("Enter area size: ");
		String requestorName = Helper.readString("Enter requestor name: ");
		int contactNumber = Helper.readInt("Enter contact number: ");
		String email = Helper.readString("Enter email: ");
		double budget = Helper.readDouble("Enter Budget: ");
		String completionDate  = Helper.readString("Enter completion date: ");
		String renovationType = Helper.readString("Enter renovation type: ");
		int numberOfRooms = Helper.readInt("Enter number of rooms: ");
		int numberOfToilets = Helper.readInt("Enter Number of toilets: ");
		String renovationStyle = Helper.readString("Enter your renovation style if any: ");
		String urgentRequest = Helper.readString("Is it an urgent Request?: ");

		if(propertyType.isEmpty() && areaSize > 0 & !requestorName.isEmpty() && contactNumber >= 0 && !email.isEmpty() && budget > 0 && !completionDate.isEmpty()
				&& !renovationType.isEmpty() && numberOfRooms > 0 && numberOfToilets > 0 && !renovationStyle.isEmpty() && !urgentRequest.isEmpty()) {
			request = new QuotationRequests(propertyType, areaSize, requestorName, contactNumber,
					email, budget, completionDate, renovationType, numberOfRooms,
					numberOfToilets, renovationStyle, urgentRequest);
		}
		return request;
	}
	
	//Jaden
	public static void addRequests(ArrayList<QuotationRequests> requestQuotationList, QuotationRequests request) {
		boolean canAdd = false;
		if(requestQuotationList.size() == 0) {
			canAdd = true;
		}
		else if (requestQuotationList.size() > 0){
			for (int qr = 0; qr < requestQuotationList.size(); qr++) {
				if (!requestQuotationList.get(qr).getRequestorName().equalsIgnoreCase(request.getRequestorName())) {
					canAdd = true;
				}
				else {
					canAdd = false;
					break;
				}
			}
		}	
		if(canAdd == true) {
			requestQuotationList.add(request);
			System.out.println("Quotation Request added successfully.");
		}
		else {
			System.out.println("Quotation Request failed to add.");
		}
	}
	
	//Jaden
	public static void deleteRequest(ArrayList<QuotationRequests> requestQuotationList, String requestorName) {
		boolean isDeleted = false;
		if(requestQuotationList.size() == 0) {
			isDeleted = true;
		}
		else {
			for (int qr = 0; qr < requestQuotationList.size(); qr++) {
				if (requestQuotationList.get(qr).getRequestorName().equalsIgnoreCase(requestorName)) {
					requestQuotationList.remove(qr);
					isDeleted = true;
				}
			}
		}
		if(isDeleted == true) {
			System.out.println("Quotation Request deleted successfully.");
		}
		else {
			System.out.println("Quotation Request failed to delete.");
		}
	}
	
	//phoebe
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
	
	//phoebe
	private static void menuDesigner() {
		C206_CaseStudy.setHeader("Designer Interface");
		System.out.println("1. View All Quotations");
		System.out.println("2. Add New Quotations");
		System.out.println("3. Delete Quotations by Quotation ID");
		System.out.println("4. Quit");
	}
	
	//phoebe
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
			output += String.format("\n%-13s %-15s %-22s %-18s %-24s %-11s %-13s %-15s\n", "REQUEST_ID", "QUOTATION_ID", "RENOVATION CATEGORY", 
					"RENOVATION ITEM", "RENOVATION ITEM PRICE", "DESIGNER", "START DATE", "TOTAL QUOTATION SUM");
			output += output1;
		}
		else {
			output = "Request_ID not found.";
		}
		
		return output;
	}
	
	//phoebe
	public static void viewAllQuotation(ArrayList<Quotations> quotationList) {
		String output = "";
		output += retrieveAllQuotation(quotationList, rId);
		System.out.println(output);
	}
	
	//phoebe
	public Quotations inputQuotation() {
		Quotations qt = new Quotations("", "", "", "", 0, "", LocalDate.now(), 0);
		String rID = Helper.readString("\nEnter request id > ");
		String qID = Helper.readString("Enter quotation id > ");
		String rc = Helper.readString("Enter renovation catergory > ");
		String rcItem = Helper.readString("Enter renovation item > ");
		double itemPrice = Helper.readDouble("Enter price of renovation item > ");
		String dName = Helper.readString("Enter designer name > ");
		int sDDate = Helper.readInt("Enter day in month of start date > ");
		int sMDate = Helper.readInt("Enter month of start date > ");
		int sYDate = Helper.readInt("Enter year of start date > ");
		double tSum = Helper.readDouble("Enter total quotation amount > ");

		if(!rID.isEmpty() && !qID.isEmpty() & !rc.isEmpty() && !rcItem.isEmpty() && itemPrice > 0 && !dName.isEmpty() && sDDate > 0 
				&& sMDate > 0 && sYDate > 0 && tSum > 0) {
			qt = new Quotations(rID.toUpperCase(), qID.toUpperCase(), rc, rcItem, itemPrice, dName, LocalDate.of(sYDate, sMDate, sDDate), tSum);
		}
		return qt;
	}
	
	//phoebe
	public static void addQuotation(ArrayList<Quotations> quotationList, Quotations qt) {
		boolean canAdd = false;
		if(quotationList.size() == 0) {
			canAdd = true;
		}
		else if (quotationList.size() > 0){
			for (int q = 0; q < quotationList.size(); q++) {
				if (!quotationList.get(q).getQID().equalsIgnoreCase(qt.getQID())) {
					canAdd = true;
				}
				else {
					canAdd = false;
					break;
				}
			}
		}	
		if(canAdd == true) {
			quotationList.add(qt);
			System.out.println("Quotation added successfully.");
		}
		else {
			System.out.println("Quotation failed to add due to duplication.");
		}
	}
	
	//phoebe
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
	//Kihyeok
	public static void viewAllPackages(ArrayList<Package> packageList) {
		String output = String.format("%-7s %-30s %-12s %-12s %-7s\n", "CODE", "DESCRIPTION", "START DATE", "END DATE", "AMOUNT");

		for (Package p : packageList) {
			output += String.format("%-7s %-30s %-12s %-12s %-7d\n", p.getCode(), p.getDescription(), p.getStartDate().toString(), p.getEndDate().toString(), p.getAmount());
		}

		System.out.println(output);
	}

	public static void inputPackage(ArrayList<Package> packageList) {

		String code = Helper.readString("Enter Package Code > ");
		String description = Helper.readString("Enter Description > ");
		Date startDate = Helper.readDate("Enter Start Date > ");
		Date endDate = Helper.readDate("Enter End Date > ");
		int amount = Helper.readInt("Enter Package Amount > ");

		addPackage(packageList, new Package(code, description, startDate, endDate, amount));
	}

	public static void addPackage(ArrayList<Package> packageList, Package p) {

		for(int i=0; i<packageList.size(); i++)
		{
			if(p.getCode() == packageList.get(i).getCode())
			{
				System.out.println("Package failed to add due to duplication.");
				return;
			}
		}

		packageList.add(p);
		System.out.println("Package added successfully.");
	}

	public static void deletePackage(ArrayList<Package> packageList, String code) {
		for(int i=0; i<packageList.size(); i++)
		{
			if(code == packageList.get(i).getCode())
			{
				packageList.remove(i);
				System.out.println("Package removed successfully.");
				return;
			}
		}

		System.out.println("Package failed to delete.");
	}
}