import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

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
	
	private ArrayList<Quotations> quotationList	= new ArrayList<Quotations>();
	private ArrayList<admin_Class> userList	= new ArrayList<admin_Class>();
	
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
		//from the list above after adding 3, adding 1 more item, the size of the list should still be 4
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
