import java.util.Date;
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 21031348, 7 Aug 2022 11:04:08 pm
 */
public class Package {
	private String code;
	private String description;
	private Date startDate;
	private Date endDate;
	private int amount;
	
	public Package(String code, String description, Date startDate, Date endDate, int amount) {
		this.code = code;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
	}
	
	public String getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public int getAmount() {
		return amount;
	}

}
