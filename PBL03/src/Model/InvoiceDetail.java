package Model;

import java.util.ArrayList;

public class InvoiceDetail {
    private String invoiceDetailID;
    private String invoiceID;
    ArrayList<Product> items;
    private static int IDCounter = 1;
    public InvoiceDetail() {
    	
    }
    public InvoiceDetail(ArrayList<Product> items, String invoiceID) {
    	invoiceID = "IN";
    	String counter = String.format("%05d", IDCounter);
    	invoiceID += counter;
    	IDCounter++;
    	this.items = items;
    	this.invoiceID = invoiceID;
    }
    
	public String getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}
	public String getInvoiceDetaliID() {
		return this.invoiceDetailID;
	}
	public void setInvoiceDetailID(String id) {
		this.invoiceDetailID = id;
	}
	public ArrayList<Product> getItems() {
		return items;
	}
	public void setItems(ArrayList<Product> items) {
		this.items = items;
	}
    
}
