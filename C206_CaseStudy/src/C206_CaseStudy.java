import java.time.LocalDate;
import java.util.ArrayList;

public class C206_CaseStudy {

	private static ArrayList<admin_Class> userList = new ArrayList<admin_Class>();
	private static ArrayList <Quotations> quotationList = new ArrayList<Quotations>();
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_QUIT = 4;
//	private static final int OPTION_QUIT = 5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		userList.add(new admin_Class("Bob", "User", "bob@mail.com", "SecurePa$sW0rd"));	
		userList.add(new admin_Class("Alice", "User", "bob@mail.com", "SecurePa$sW0rd"));	
		userList.add(new admin_Class("Charile", "User", "bob@mail.com", "SecurePa$sW0rd"));	
		userList.add(new admin_Class("Emily", "User", "bob@mail.com", "SecurePa$sW0rd"));	
		
		quotationList.add(new Quotations("RV001", "QT001", "Kitchen", "Flooring", 550.00, "Anne", LocalDate.of(2022, 10, 8), 700.00));
		quotationList.add(new Quotations("RV001", "QT002", "Bedroom", "Closet", 350.00, "Anne", LocalDate.of(2022, 10, 12), 550.00));
		quotationList.add(new Quotations("RV002", "QT003", "Living Room", "Door", 200.00, "Ben", LocalDate.of(2022, 12, 14), 220.00));
		quotationList.add(new Quotations("RV003", "QT004", "Toilet", "Flooring", 550.00, "Carrol", LocalDate.of(2023, 05, 9), 600.00));
		
		C206_CaseStudy mw = new C206_CaseStudy();

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
	}
	
	public void designersPage() {
		//Add what designers can do
		int option = -1;
		while (option != 4) {
			menuDesigner();
			option = Helper.readInt("Enter choice > ");
			if (option == OPTION_VIEW) {
				viewAllQuotation();
			} else if (option == OPTION_ADD) {
				addQuotation();
			} else if (option == OPTION_DELETE) {
				deleteQuotation();
			}else if (option == OPTION_QUIT) {
				System.out.println("Thank You~");
			}
		}
	}
	
	private void menuDesigner() {
		C206_CaseStudy.setHeader("Designer Interface");
		System.out.println("1. View All Quotations");
		System.out.println("2. Adding New Quotations");
		System.out.println("3. Deleting Quotations by Quotation_ID");
		System.out.println("4. Quit");
	}
	
	public void viewAllQuotation() {
		String output = String.format("\n%-13s %-15s %-22s %-18s %-24s %-11s %-13s %-15s\n", "REQUEST_ID", "QUOTATION_ID", "RENOVATION CATEGORY", "RENOVATION ITEM", "RENOVATION ITEM PRICE", "DESIGNER", "START DATE", "TOTAL QUOTATION SUM");
		for (Quotations q : quotationList) {
			output += String.format("%-84s\n", q.toString());
		}
		System.out.println(output);
	}
	
	public void addQuotation() {
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
		
		if(!rID.isEmpty() && !qID.isEmpty() & !rc.isEmpty() && !rcItem.isEmpty() && itemPrice > 0 && !dName.isEmpty() && sDDate > 0 && sMDate > 0 && sYDate > 0 && tSum > 0) {
			quotationList.add(new Quotations(rID, qID, rc, rcItem, itemPrice, dName, LocalDate.of(sYDate, sMDate, sDDate), tSum));
			System.out.println("Quotation added successfully.");
		}
		else {
			System.out.println("Quotation failed to add.");
		}
	}
	
	public void deleteQuotation() {
		boolean removed = false;
		String qID = Helper.readString("\nEnter quotation id > ");
		for (int q = 0; q < quotationList.size(); q++) {
			if (quotationList.get(q).getQID().equals(qID)) {
				quotationList.remove(q);
				removed = true;
			}
		}
		if(removed == true) {
			System.out.println("Quotation removed successfully.");
		}
		else {
			System.out.println("Quotation failed to remove.");
		}
	}
	
}



