package Service;

import java.util.ArrayList;

import Model.Invoice;
import Model.InvoiceDetail;

public interface InvoiceService {
	public ArrayList<Invoice> getList();
	public String generateInvoiceID();
	public String generateInvoiceDetailID();
	public void Insert(Invoice invoice);
	public void InvertDetail(InvoiceDetail invoicdeDetail);
	public int Delete(Invoice invoice);
	public int Delete(String invoice);
	public int DeleteDetail(InvoiceDetail invoicdeDetail);
}
