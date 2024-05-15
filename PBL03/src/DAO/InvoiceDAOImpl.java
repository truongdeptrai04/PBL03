package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Invoice;
import Model.InvoiceDetail;
import Model.Product;

public class InvoiceDAOImpl implements InvoiceDAO{

	@Override
	public ArrayList<Invoice> getList() {
		Connection cons = JDBC.getConnection();
        String sql = "SELECT * FROM invoice " + 
        		"INNER JOIN customer ON invoice.CustomerID = customer.CustomerID " +
        		"INNER JOIN employee ON invoice.EmployeeID = employee.EmployeeID " +
        		"INNER JOIN discount ON invoice.DiscountID = discount.DiscountID ";
        ArrayList<Invoice> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Invoice invoice = new Invoice();
                invoice.setInvoiceID(rs.getString("InvoiceID"));
                invoice.getCustomer().setName(rs.getString("CustomerName"));;
                invoice.getCustomer().setPhoneNumber(rs.getString("PhoneNumber"));
//                product.setDiscount(rs.getString("dia_chi"));
                invoice.getEmployee().setName(rs.getString("EmployeeName"));
                invoice.setDate(rs.getDate("Date"));
                invoice.getDiscount().setDiscountPercent(rs.getDouble("DiscountPercent"));
                invoice.setTotal(rs.getInt("Total"));
                list.add(invoice);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public String generateInvoiceID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateInvoiceDetailID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Insert(Invoice invoice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void InvertDetail(InvoiceDetail invoicdeDetail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int Delete(Invoice invoice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Delete(String invoiceID) {
		int kq = 0;
	    PreparedStatement deleteFromInvoice = null;
	    PreparedStatement deleteFromInvoiceDetail = null;
		try {
			Connection con = JDBC.getConnection();
	        con.setAutoCommit(false); // Bắt đầu giao dịch

	        String deleteFinalcialbudgetingSQL = "DELETE FROM invoicedetail WHERE InvoiceID = ?";
	        deleteFromInvoiceDetail = con.prepareStatement(deleteFinalcialbudgetingSQL);
	        deleteFromInvoiceDetail.setString(1, invoiceID);
	        kq += deleteFromInvoiceDetail.executeUpdate();


	        String deleteProductSQL = "DELETE FROM invoice WHERE InvoiceID = ?";
	        deleteFromInvoice = con.prepareStatement(deleteProductSQL);
	        deleteFromInvoice.setString(1, invoiceID);
	        kq += deleteFromInvoice.executeUpdate();

	        con.commit();
			
			System.out.println("Ban da thuc thi: " + deleteProductSQL);
			System.out.println("Co " + kq + " dong bi thay doi");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int DeleteDetail(InvoiceDetail invoicdeDetail) {
		// TODO Auto-generated method stub
		return 0;
	}

}
