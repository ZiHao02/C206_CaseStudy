import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Quotations qt1;
	private Quotations qt2;
	private Quotations qt3;
	
	private ArrayList<Quotations> quotationList	= new ArrayList<Quotations>();
	
	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		//preparing test data
		qt1 = new Quotations("RV001", "QT015", "Bedroom", "Flooring", 450.00, "Anne", LocalDate.of(2022, 12, 22), 735.50);
		qt2 = new Quotations("RV004", "QT016", "Living Room", "Door", 200.00, "Anne", LocalDate.of(2022, 12, 28), 280.50);
		qt3 = new Quotations("RV004", "QT017", "Living Room", "Window", 150.00, "Anne", LocalDate.of(2022, 12, 28), 250.00);
	}
	
	@Test
	public void testAddQuotations() {
		//check list is not null so that adding of item is possible
		assertNotNull("Check if there is valid Quotation arraylist to add to", quotationList);
		//from an empty list, after adding 1 item, the size of the list 1
		C206_CaseStudy.addQuotation(quotationList, qt1);
		assertEquals("Check that Quotation arraylist size is 1", 1, quotationList.size());
		assertSame("Check that Quotation is added", qt1, quotationList.get(0));
		//from the list above after adding 1, after adding 1 more item, the size of the list 2
		C206_CaseStudy.addQuotation(quotationList, qt2);
		assertEquals("Check that Quotation arraylist size is 2", 2, quotationList.size());
		assertSame("Check that Quotation is added", qt2, quotationList.get(1));
	}
	@Test
	public void testRetrieveAllQuotation() {
		//test to ensure the list is not null but empty
		assertNotNull("Test if there is valid Quotation arraylist to retrieve item", quotationList);
		
		//test if the list of quotations retrieved is empty
		String allQuotations = C206_CaseStudy.retrieveAllQuotation(quotationList, "RV001");
		String testOutput = "Request_ID not found.";
		assertEquals("Check that ViewAllQuotationlist", testOutput, allQuotations);
		//if given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addQuotation(quotationList, qt1);
		C206_CaseStudy.addQuotation(quotationList, qt2);
		C206_CaseStudy.addQuotation(quotationList, qt3);
		assertEquals("Test that Quotation arraylist size is 3", 3, quotationList.size());
		//test if the expected output string is the same as the list of quotations retrieved from C206_CaseStudy
		allQuotations = C206_CaseStudy.retrieveAllQuotation(quotationList, "RV004");
		testOutput =  String.format("\n%-13s %-15s %-22s %-18s %-24s %-11s %-13s %-15s\n", "REQUEST_ID", "QUOTATION_ID", "RENOVATION CATEGORY", "RENOVATION ITEM", "RENOVATION ITEM PRICE", "DESIGNER", "START DATE", "TOTAL QUOTATION SUM");
		testOutput += String.format("%-13s %-15s %-22s %-18s %-24s %-11s %-13s %-15s\n", "RV004", "QT016", "Living Room", "Door", "$200.0", "Anne", "28 Dec 2022", "$280.5");
		testOutput += String.format("%-13s %-15s %-22s %-18s %-24s %-11s %-13s %-15s\n", "RV004", "QT017", "Living Room", "Window", "$150.0", "Anne", "28 Dec 2022", "$250.0");
	
		assertEquals("Test that ViewAllQuotationlist", testOutput, allQuotations);
	}
	@Test
	public void testDeleteQuotation() {
		//test to ensure the list is not null but empty
		assertNotNull("Test if there is valid Quotation arraylist to retrieve item", quotationList);
		C206_CaseStudy.addQuotation(quotationList, qt1);
		C206_CaseStudy.deleteQuotation(quotationList, "QT015");
		assertEquals("Test that Quotation arraylist size is 0", 0, quotationList.size());
		
		C206_CaseStudy.addQuotation(quotationList, qt1);
		C206_CaseStudy.addQuotation(quotationList, qt2);
		C206_CaseStudy.deleteQuotation(quotationList, "QT016");
		assertEquals("Test that Quotation arraylist size is 1", 1, quotationList.size());
	}

	@After
	public void tearDown() throws Exception {
		qt1 = null;
		qt2 = null;
		quotationList = null;
	}

//	@Test
//	public void c206_test() {
//		//fail("Not yet implemented"); 
////		assertTrue("C206_CaseStudy_SampleTest ",true);
//	}

}
