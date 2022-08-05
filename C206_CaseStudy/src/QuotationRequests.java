public class QuotationRequests {
	private String propertyType;
	private double areaSize;
	private String requestorName;
	private int contactNumber;
	private String email;
	private double budget;
	private String completionDate;
	private String renovationType;
	private int numberOfRooms;
	private int numberOfToilets;
	private String renovationStyle;
	private String urgentRequest;
	/**
	 * @param propertyType
	 * @param areaSize
	 * @param requestorName
	 * @param contactNumber
	 * @param email
	 * @param budget
	 * @param completionDate
	 * @param renovationType
	 * @param numberOfRooms
	 * @param numberOfToilets
	 * @param renovationStyle
	 * @param urgentRequest
	 */
	public QuotationRequests(String propertyType, double areaSize, String requestorName, int contactNumber,
			String email, double budget, String completionDate, String renovationType, int numberOfRooms,
			int numberOfToilets, String renovationStyle, String urgentRequest) {
		
		super();
		this.propertyType = propertyType;
		this.areaSize = areaSize;
		this.requestorName = requestorName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.budget = budget;
		this.completionDate = completionDate;
		this.renovationType = renovationType;
		this.numberOfRooms = numberOfRooms;
		this.numberOfToilets = numberOfToilets;
		this.renovationStyle = renovationStyle;
		this.urgentRequest = urgentRequest;
	}
	
		
	
		
	
		
	public QuotationRequests(String string, int i, String string2, int j, String string3, double d, String string4,
			double e, String string5, int k, int l, String string6, String string7) {
		
	}


	public String getPropertyType() {
		return propertyType;
	}

	public double getAreaSize() {
		return areaSize;
	}

	public String getRequestorName() {
		return requestorName;
	}
	
	public int getContactNumber() {
		return contactNumber;
	}

	public String getEmail() {
		return email;
	}
	
	public String getBudget() {
		String budgetPrice = "$" + Double.toString(budget);
		return budgetPrice;
	}
	
	public String getCompletionDate() {
		return completionDate;
	}
	
	public String getRenovationType() {
		return renovationType;
	}
	
	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public int getNumberOfToilets() {
		return numberOfToilets;
	}
	
	public String getRenovationStyle() {
		return renovationStyle;
	}
	
	public String getUrgentRequest() {
		return urgentRequest;
	}

	public String toString() {
		String output = "";
		output = String.format("%-15s %-10s %-20s %-20s %-20s %-15s %-20s %-10s %-15s %-10s %-20s", getPropertyType(), getAreaSize(), getRequestorName(), getContactNumber(), getEmail(), getBudget(), getCompletionDate(), getRenovationType(), getNumberOfToilets(), getRenovationStyle(), getUrgentRequest());
		return output;
	}
}
