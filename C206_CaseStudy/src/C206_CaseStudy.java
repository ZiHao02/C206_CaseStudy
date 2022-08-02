import java.time.LocalDate;
import java.util.ArrayList;





public class C206_CaseStudy {

	
	
	private static ArrayList<admin_Class> userList = new ArrayList<admin_Class>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		userList.add(new admin_Class("Bob", "User", "bob@mail.com", "SecurePa$sW0rd"));	
		userList.add(new admin_Class("Alice", "User", "bob@mail.com", "SecurePa$sW0rd"));	
		userList.add(new admin_Class("Charile", "User", "bob@mail.com", "SecurePa$sW0rd"));	
		userList.add(new admin_Class("Emily", "User", "bob@mail.com", "SecurePa$sW0rd"));	
		C206_CaseStudy mw = new C206_CaseStudy();

		mw.start();
		
		
	}
	
	public void start() {
		int option = -1;
		while (option != 4) {
			menu();
			option = Helper.readInt("Enter choice > ");
			if (option == 1) {
				viewAllusers();
			} else if (option == 2) {
				addUsers();
			} else if (option == 3) {
				deleteUserbyName();
			}else if (option == 4) {
				System.out.println("Thank You~");
			}
		}
	}
	
	private void menu() {
		Helper.line(80, "=");
		System.out.println("Admin Interface");
		Helper.line(80, "=");
		System.out.println("1. View All Users");
		System.out.println("2. Adding New Users");
		System.out.println("3. Deleting Users by Name");
		System.out.println("4. Back");
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
}
