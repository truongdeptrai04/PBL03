package Service;

import java.util.ArrayList;

import DAO.InvoiceDAO;
import DAO.InvoiceDAOImpl;
import DAO.ProductDAO;
import DAO.ProductDAOImpl;
import Model.Invoice;
import Model.InvoiceDetail;

public class InvoiceServiceImpl implements InvoiceService{
	private InvoiceDAO invoiceDAO = null;
	public InvoiceServiceImpl() {
		this.invoiceDAO = new InvoiceDAOImpl();
		}
	@Override
	public ArrayList<Invoice> getList() {
		return invoiceDAO.getList();
	}
	@Override
	public String generateInvoiceID() {
		// TODO Auto-generated method stub
		return invoiceDAO.generateInvoiceID();
	}
	@Override
	public String generateInvoiceDetailID() {
		// TODO Auto-generated method stub
		return invoiceDAO.generateInvoiceDetailID();
	}
	@Override
	public void Insert(Invoice invoice) {
		// TODO Auto-generated method stub
		invoiceDAO.Insert(invoice);
	}
	@Override
	public void InvertDetail(InvoiceDetail invoicdeDetail) {
		// TODO Auto-generated method stub
		invoiceDAO.InvertDetail(invoicdeDetail);
	}
	@Override
	public int Delete(Invoice invoice) {
		// TODO Auto-generated method stub
		return invoiceDAO.Delete(invoice);
	}
	@Override
	public int DeleteDetail(InvoiceDetail invoicdeDetail) {
		// TODO Auto-generated method stub
		return invoiceDAO.DeleteDetail(invoicdeDetail);
	}
	@Override
	public int Delete(String invoice) {
		return invoiceDAO.Delete(invoice);
	}
}
