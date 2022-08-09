import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	//phoebe
	private Quotations qt1;
	private Quotations qt2;
	private Quotations qt3;
	private Quotations qt4;
	private Quotations qt5;
	private Quotations qt6;
	
	//Zi Hao
	private admin_Class user1;
	private admin_Class user2;
	private admin_Class user3;
	private admin_Class user4;
	private admin_Class user5;
	private admin_Class user6;
	
	//Jaden
	private QuotationRequests request1;
	private QuotationRequests request2;
	private QuotationRequests request3;
	private QuotationRequests request4;
	
	
	private Package pack1;
	private Package pack2;
	private Package pack3;
	private Package pack4;
	private Package pack5;
	private Package pack6;
	
	private ArrayList<Quotations> quotationList	= new ArrayList<Quotations>();
	private ArrayList<admin_Class> userList = new ArrayList<admin_Class>();
	private static ArrayList <QuotationRequests> requestQuotationList = new ArrayList<QuotationRequests>();
	private ArrayList<Package> packageList = new ArrayList<Package>();
	
	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		//preparing test data
		//phoebe
		qt1 = new Quotations("RV001", "QT015", "Bedroom", "Flooring", 450.00, "Anne", LocalDate.of(2022, 12, 22), 735.50);
		qt2 = new Quotations("RV004", "QT016", "Living Room", "Door", 200.00, "Ben", LocalDate.of(2022, 12, 28), 280.50);
		qt3 = new Quotations("RV004", "QT017", "Living Room", "Window", 150.00, "Anne", LocalDate.of(2022, 12, 28), 250.00);
		qt4 = new Quotations("RV004", "QT016", "Toilet", "Door", 120.00, "Darrol", LocalDate.of(2023, 02, 28), 175.00);
		qt5 = new Quotations("RV005", "QT015", "Bedroom", "Window", 170.00, "Anne", LocalDate.of(2023, 05, 21), 260.00);
		qt6 = new  Quotations("RV006", "QT018", "Kitchen", "Basin", 120.00, "Candy", LocalDate.of(2023, 04, 12), 175.00);
		

		//Zi Hao
		user1 = new admin_Class("Bob", "User", "bob@mail.com", "SecurePa$sW0rd");	
		user2 = new admin_Class("Alice", "User", "alice@mail.com", "SecurePa$sW0rd");
		user3 = new admin_Class("Emily", "User", "emily@mail.com", "SecurePa$sW0rd");	
		user4 = new admin_Class("Emily", "User", "emily@mail.com", "SecurePa$sW0rd");
		user5 = new admin_Class("Alice", "User", "alice@mail.com", "SecurePa$sW0rd");
		user6 = new admin_Class("Anna", "User", "anna@mail.com", "SecurePa$sW0rd");
		
		//Jaden
		request1 = new QuotationRequests("HDB", 85, "John", 97324510, "john@mail.com", 640.00, "2022/7/21", "Toilet", 6, 4, "No", "Yes");
		request2 = new QuotationRequests("HDB", 85, "John", 97324510, "john@mail.com", 640.00, "2022/7/21", "Toilet", 6, 4, "No", "Yes");
		request3 = new QuotationRequests("Landed", 420, "Adam", 91336502, "adam@mail.com", 946.00, "2022/7/21", "Room", 8, 3, "Modern", "No");
		request4 = new QuotationRequests("Private", 98, "Ben", 67882174, "ben@mail.com", 508.00, "2022/7/21", "Kitchen", 4, 2, "No", "Yes");

		//kihyeok
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		pack1 = new Package("PK1", "First Package", dFormat.parse("2022-01-01"), dFormat.parse("2022-01-02"), 3);
		pack2 = new Package("PK2", "Second Package", dFormat.parse("2022-01-01"), dFormat.parse("2022-01-02"), 3);
		pack3 = new Package("PK3", "Third Package", dFormat.parse("2022-01-01"), dFormat.parse("2022-01-02"), 3);
		pack4 = new Package("PK3", "Fourth Package", dFormat.parse("2022-01-01"), dFormat.parse("2022-01-02"), 3);
		pack5 = new Package("PK5", "Fifth Package", dFormat.parse("2022-01-01"), dFormat.parse("2022-01-02"), 3);
		pack6 = new Package("PK6", "Sixth Package", dFormat.parse("2022-01-01"), dFormat.parse("2022-01-02"), 3);

	}
	
	@Test
	//phoebe
	public void testAddQuotations() {
		//check list is not null so that adding of item is possible
		assertNotNull("Check if there is valid Quotation arraylist to add to", quotationList);
		
		//normal
		//from an empty list, after adding 1 item, the size of the list 1 should be 1
		C206_CaseStudy.addQuotation(quotationList, qt1);
		assertEquals("Check that Quotation arraylist size is 1 after adding", 1, quotationList.size());
		assertSame("Check that Quotation is added", qt1, quotationList.get(0));
		
		//normal
		//from the list above after adding 1, add 1 more item, the size of the list should be 2
		C206_CaseStudy.addQuotation(quotationList, qt2);
		assertEquals("Check that Quotation arraylist size is 2 after adding", 2, quotationList.size());
		assertSame("Check that Quotation is added", qt2, quotationList.get(1));
		
		//normal
		//from the list above after adding 2, add 1 more item, the size of the list should be 3
		C206_CaseStudy.addQuotation(quotationList, qt3);
		assertEquals("Check that Quotation arraylist size is 3 after adding", 3, quotationList.size());		
		assertSame("Check that Quotation is added", qt3, quotationList.get(2));
		
		//error
		//from the list above after adding 3, adding 1 more item with duplicated quotation id, the size of the list should still be 3
		C206_CaseStudy.addQuotation(quotationList, qt4);
		assertEquals("Check that Quotation arraylist size is 3 after adding", 3, quotationList.size());
		
		//error
		//from the list above after adding 3, adding 1 more item with duplicated quotation id, the size of the list should still be 3
		C206_CaseStudy.addQuotation(quotationList, qt5);
		assertEquals("Check that Quotation arraylist size is 3 after adding", 3, quotationList.size());
		
		//normal
		//from the list above after adding 3, adding 1 more item, the size of the list should still be 4
		C206_CaseStudy.addQuotation(quotationList, qt6);
		assertEquals("Check that Quotation arraylist size is 4 after adding", 4, quotationList.size());		
		assertSame("Check that Quotation is added", qt6, quotationList.get(3));
	}
	
	@Test
	//phoebe
	public void testRetrieveAllQuotation() {
		//test to ensure the list is not null but empty
		assertNotNull("Test if there is valid Quotation arraylist to retrieve item", quotationList);
		
		//error
		//test if the list of quotations retrieved is empty
		String allQuotations = C206_CaseStudy.retrieveAllQuotation(quotationList, "RV001");
		String testOutput = "Request_ID not found.";
		assertEquals("Check that ViewAllQuotationlist is", testOutput, allQuotations);
		
		//normal
		//if given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addQuotation(quotationList, qt1);
		C206_CaseStudy.addQuotation(quotationList, qt2);
		C206_CaseStudy.addQuotation(quotationList, qt3);
		assertEquals("Test that Quotation arraylist size is 3 after adding", 3, quotationList.size());
		
		//normal
		//test if the expected output string is the same as the list of quotations retrieved from C206_CaseStudy
		allQuotations = C206_CaseStudy.retrieveAllQuotation(quotationList, "RV004");
		testOutput =  String.format("\n%-13s %-15s %-22s %-18s %-24s %-11s %-13s %-15s\n", "REQUEST_ID", "QUOTATION_ID", "RENOVATION CATEGORY", 
				"RENOVATION ITEM", "RENOVATION ITEM PRICE", "DESIGNER", "START DATE", "TOTAL QUOTATION SUM");
		testOutput += String.format("%-13s %-15s %-22s %-18s %-24s %-11s %-13s %-15s\n", "RV004", "QT016", "Living Room", "Door", "$200.0", 
				"Ben", "28 Dec 2022", "$280.5");
		testOutput += String.format("%-13s %-15s %-22s %-18s %-24s %-11s %-13s %-15s\n", "RV004", "QT017", "Living Room", "Window", "$150.0", 
				"Anne", "28 Dec 2022", "$250.0");
		assertEquals("Test that ViewAllQuotationlist is", testOutput, allQuotations);
	}
	
	@Test
	//phoebe
	public void testDeleteQuotation() {
		//test to ensure the list is not null but empty
		assertNotNull("Test if there is valid Quotation arraylist to retrieve item", quotationList);
		
		//normal
		//test if the size of the list is 0 after adding 1 and deleting 1
		C206_CaseStudy.addQuotation(quotationList, qt1);
		C206_CaseStudy.deleteQuotation(quotationList, "QT015");
		assertEquals("Test that Quotation arraylist size is 0 after adding", 0, quotationList.size());
		
		//normal
		//test if the size of the list is 1 after adding 2 and deleting 1
		C206_CaseStudy.addQuotation(quotationList, qt1);
		C206_CaseStudy.addQuotation(quotationList, qt2);
		C206_CaseStudy.deleteQuotation(quotationList, "QT016");
		assertEquals("Test that Quotation arraylist size is 1 after deleting", 1, quotationList.size());
		
		//error
		//test if non-existed quotation id can delete
		C206_CaseStudy.deleteQuotation(quotationList, "QT017");
		assertEquals("Test that Quotation arraylist size is 1 after deleting", 1, quotationList.size());
	}
	
	@Test
	//Zi Hao
	public void testAddUsers() {
		//check list is not null so that adding of user is possible
		assertNotNull("Check if there is an arraylist to add users to", userList);
		
		//normal
		//from an empty list, after adding 1 user, the size of the list 1 should be 1
		C206_CaseStudy.addUsers(userList, user1);
		assertEquals("Check that User arraylist size is 1 after adding", 1, userList.size());
		assertSame("Check that User is added", user1, userList.get(0));
		
		//normal
		//from the list above after adding 1, add 1 more item, the size of the list should be 2
		C206_CaseStudy.addUsers(userList, user2);
		assertEquals("Check that User arraylist size is 2 after adding", 2, userList.size());
		assertSame("Check that User is added", user2, userList.get(1));
		
		//normal
		//from the list above after adding 2, add 1 more item, the size of the list should be 3
		C206_CaseStudy.addUsers(userList, user3);
		assertEquals("Check that User arraylist size is 3 after adding", 3, userList.size());		
		assertSame("Check that User is added", user3, userList.get(2));
		
		//error
		//from the list above after adding 3, adding 1 more item with duplicated username, the size of the list should still be 3
		C206_CaseStudy.addUsers(userList, user4);
		assertEquals("Check that User arraylist size is 3 after adding", 3, userList.size());
		
		//error
		//from the list above after adding 3, adding 1 more item with duplicated username, the size of the list should still be 3
		C206_CaseStudy.addUsers(userList, user5);
		assertEquals("Check that User arraylist size is 3 after adding", 3, userList.size());
		
		//normal
		//from the list above after adding 3, adding 1 more item, the size of the list should be 4
		C206_CaseStudy.addUsers(userList, user6);
		assertEquals("Check that User arraylist size is 4 after adding", 4, userList.size());		
		assertSame("Check that User is added", user6, userList.get(3));
	}
	
	@Test
	// Zi Hao
	public void testRetrieveAllUsers() {
		//test to ensure the list is not null but empty
		assertNotNull("Test if there is valid userlist arraylist to retrieve user", userList);
		
		//error
		//test if the list of quotations retrieved is empty
		String Nousers = C206_CaseStudy.viewAllusers(userList);
		String testOutput = "No users currently";
		assertEquals("Check that ViewAllQuotationlist is", testOutput, Nousers);
		
		//normal
		//if given an empty list, after adding 3 users, test if the size of the list is 3
		C206_CaseStudy.addUsers(userList, user1);
		C206_CaseStudy.addUsers(userList, user2);
		C206_CaseStudy.addUsers(userList, user3);
		assertEquals("Test that user arraylist size is 3 after adding", 3, userList.size());
		
		//normal
		//test if the expected output string is the same as the list of users retrieved from C206_CaseStudy
		String allusers = C206_CaseStudy.viewAllusers(userList);
		
		testOutput =  String.format("%-10s %-10s %-20s %-20s %-10s\n", "Name", "role", "email", "password", "status");
		testOutput += String.format("%-10s %-10s %-20s %-20s %-10s\n", "Bob", "User", "bob@mail.com", "SecurePa$sW0rd", "New");
		testOutput += String.format("%-10s %-10s %-20s %-20s %-10s\n", "Alice", "User", "alice@mail.com", "SecurePa$sW0rd", "New");
		testOutput += String.format("%-10s %-10s %-20s %-20s %-10s\n", "Emily", "User", "emily@mail.com", "SecurePa$sW0rd", "New");
		assertEquals("Test that viewAllusers is", testOutput, allusers);
	}
	
	@Test
	// Zi Hao
	public void testDeleteUsers() {
		//test to ensure the list is not null but empty
		assertNotNull("Test if there is a valid user arraylist to delete item", userList);
		
		//normal
		//test if the size of the list is 0 after adding 1 and deleting 1
		C206_CaseStudy.addUsers(userList, user1);
		C206_CaseStudy.deleteUserbyName(userList, "Bob");
		assertEquals("Test that user arraylist size is 0 after adding and deleting", 0, userList.size());
		
		//normal
		//test if the size of the list is 1 after adding 2 and deleting 1
		C206_CaseStudy.addUsers(userList, user1);
		C206_CaseStudy.addUsers(userList, user2);
		C206_CaseStudy.deleteUserbyName(userList, "Alice");
		assertEquals("Test that user arraylist size is 1 after deleting", 1, userList.size());
		
		//error
		//test if non-existed quotation id can delete
		C206_CaseStudy.deleteUserbyName(userList, "Jack");
		assertEquals("Test that user arraylist size is 1 after deleting", 1, userList.size());
	}
	@Test
	//Jaden
	public void testAddRequests() {
		//check list is not null so that adding of user is possible
		assertNotNull("Check if there is an arraylist to add users to", requestQuotationList.size());
		
		//normal
		//from an empty list, after adding 1 user, the size of the list 1 should be 1
		C206_CaseStudy.addRequests(requestQuotationList, request1);
		assertEquals("Check that User arraylist size is 1 after adding", 1, requestQuotationList.size());

		
		//normal
		//from the list above after adding 1, add 1 more item, the size of the list should be 2
		C206_CaseStudy.addRequests(requestQuotationList, request2);
		
		
		//normal
		//from the list above after adding 2, add 1 more item, the size of the list should be 3
		C206_CaseStudy.addRequests(requestQuotationList, request3);
			
		
		
		C206_CaseStudy.addRequests(requestQuotationList, request4);
		assertEquals("Check that User arraylist size is 3 after adding", 3, requestQuotationList.size());		
		
		
	}
	
	@Test
	//Jaden
	public void testRetrieveAllQuotationRequests() {
		
		assertNotNull("Test if there is valid Quotation Request arraylist to retrieve item", requestQuotationList);
		
		
		String allRequests = C206_CaseStudy.retrieveAllQuotationRequests(requestQuotationList, "John");
		String testOutput = "Requestor Name not found.";
		assertEquals("Check that ViewAllQuotationRequests list is", testOutput, allRequests);
		
		
		C206_CaseStudy.addRequests(requestQuotationList, request1);
		C206_CaseStudy.addRequests(requestQuotationList, request2);
		C206_CaseStudy.addRequests(requestQuotationList, request3);
		assertEquals("Check that ViewAllQuotationRequests list is", testOutput, allRequests);
		
		
		allRequests = C206_CaseStudy.retrieveAllQuotationRequests(requestQuotationList, "Ben");
		testOutput =  String.format("\n%-13s %-15s %-22s %-18s %-24s %-11s %-13s %-15s %20s %-10s %-21s\n", "Property Type", "Area Size", "Requestor Name", "Contact Number", "Email", "Budget", "Completion Date", "Renovation Type", "Number of Rooms", "Number of Toilets", "Renovation Style?", "Urgent Request?");
		testOutput += String.format("\n%-13s %-15s %-22s %-18s %-24s %-11s %-13s %-15s %20s %-10s %-21s\n", "Private", "98", "Ben", "67882174", "ben@mail.com", "508.00", "2022/7/21", "600.00", "Kitchen", "4", "2", "No", "Yes");
		testOutput += String.format("\n%-13s %-15s %-22s %-18s %-24s %-11s %-13s %-15s %20s %-10s %-21s\n", "Landed", "400", "Ben", "61947182", "ben@mail.com", "900.00", "2022/9/2", "500.00", "Toilet", "3", "4", "Yes", "No");
		
	}
	@Test
	//Jaden
	public void testDeleteQuotationRequests() {
		
		assertNotNull("Test if there is valid Quotation Requests arraylist to retrieve item", requestQuotationList);
		
		
		C206_CaseStudy.addRequests(requestQuotationList, request1);
		C206_CaseStudy.deleteRequest(requestQuotationList, "John");
	
		
		
		C206_CaseStudy.addRequests(requestQuotationList, request1);
		C206_CaseStudy.addRequests(requestQuotationList, request2);
		C206_CaseStudy.deleteRequest(requestQuotationList, "David");

		
		
		C206_CaseStudy.deleteRequest(requestQuotationList, "Adam");


	}

	

	@Test
	//kihyeok
	public void testAddPackages() {
		//check list is not null
		assertNotNull("Check if packageList is not null", packageList);
		
		//normal
		//add 1 item to empty list. new list should now contain 1
		C206_CaseStudy.addPackage(packageList, pack1);
		assertEquals("Check packageList size is 1 after adding 1", 1, packageList.size());
		assertSame("Check package is added", pack1, packageList.get(0));
		
		//normal
		//add 2 items to list. new list should now contain 3
		C206_CaseStudy.addPackage(packageList, pack2);
		C206_CaseStudy.addPackage(packageList, pack3);
		assertEquals("Check packageList size is 3 after adding 2", 3, packageList.size());
		assertSame("Check package2 is added", pack2, packageList.get(1));
		assertSame("Check package3 is added", pack3, packageList.get(2));
		
		//error
		//adding a duplicate code will result in a failure and there still would be 3 items in the list
		C206_CaseStudy.addPackage(packageList, pack4);
		assertEquals("Check packageList size is 3 after adding", 3, packageList.size());
	}

	@Test
	//kihyeok
	public void testDeletePackages() {
		//check list is not null
		assertNotNull("Check if packageList is not null", packageList);
		
		//normal
		//add 1 item to empty list, then delete it. new list should now contain 0
		C206_CaseStudy.addPackage(packageList, pack1);
		C206_CaseStudy.deletePackage(packageList, "PK1");
		assertEquals("Check packageList size is still 0 after adding and deleting 1", 0, packageList.size());
		
		//error
		//add 1 item and delete non-existent item. new list should now contain 1
		C206_CaseStudy.addPackage(packageList, pack2);
		C206_CaseStudy.deletePackage(packageList, "PK8");
		assertEquals("Check packageList size is 1 after adding 1 and failing to delete 1", 1, packageList.size());
	}

	@After
	public void tearDown() throws Exception {
		qt1 = null;
		qt2 = null;
		qt3 = null;
		qt4 = null;
		qt5 = null;
		qt6 = null;
		quotationList = null;
	}

//	@Test
//	public void c206_test() {
//		//fail("Not yet implemented"); 
////		assertTrue("C206_CaseStudy_SampleTest ",true);
//	}

}
