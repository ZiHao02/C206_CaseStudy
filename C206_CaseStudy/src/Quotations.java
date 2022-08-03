import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 21024102, 3 Aug 2022 4:04:06 pm
 */

/**
 * @author 21024102
 *
 */
public class Quotations {
	private String rID;
	private String qID;
	private String renoCategory;
	private String renoItem;
	private double renoItemPrice;
	private String designerName;
	private LocalDate startDate;
	private double quotationSum;
	private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MMM yyyy");
	
	public Quotations(String rID, String qID, String renoCategory, String renoItem, double renoItemPrice, String designerName, LocalDate startDate, double quotationSum) {
		this.rID = rID;
		this.qID = qID;
		this.renoCategory = renoCategory;
		this.renoItem = renoItem;
		this.renoItemPrice = renoItemPrice;
		this.designerName = designerName;
		this.startDate = startDate;
		this.quotationSum = quotationSum;
	}
	
	public String getRID() {
		return rID;
	}
	
	public String getQID() {
		return qID;
	}
	
	public String getRenoCategory() {
		return renoCategory;
	}
	
	public String getRenoItem() {
		return renoItem;
	}
	
	public String getRenoItemPrice() {
		String price = "$" + Double.toString(renoItemPrice);
		return price;
	}
	
	public String getDesignerName() {
		return designerName;
	}
	
	public String getStartDate() {
		String date = startDate.format(format);
		return date;
	}
	
	public String getQuotationSum(){
		String sum = "$" + Double.toString(quotationSum);
		return sum;
	}
	
	public String toString() {
		String output = "";
		output = String.format("%-13s %-15s %-22s %-18s %-24s %-11s %-13s %-15s", getRID(), getQID(), getRenoCategory(), getRenoItem(), getRenoItemPrice(), getDesignerName(), getStartDate(), getQuotationSum());
		return output;
	}
}

