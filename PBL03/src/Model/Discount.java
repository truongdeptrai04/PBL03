package Model;

import java.sql.Date;
import java.sql.Time;

public class Discount {
    private String discountID;
    private double discountPercent;
    private Date startTime;
    private Date endTime;
    public Discount() {
    	
    }
    public Discount(String discountID, double discountPercent, Date startTime, Date endTime) {
    	this.discountID = discountID;
    	this.discountPercent = discountPercent;
    	this.startTime = startTime;
    	this.endTime = endTime;
    }
    
	public String getDiscountID() {
		return discountID;
	}
	public void setDiscountID(String discountID) {
		this.discountID = discountID;
	}
	public double getDiscountPercent() {
		return discountPercent;
	}
	public String DiscountPercentToString() {
		return Double.toString(discountPercent);
	}
	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date date) {
		this.startTime = date;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
