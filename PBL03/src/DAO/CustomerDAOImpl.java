package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Customer;
import Model.Employee;
import Model.MembershipCard;
import Model.Product;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public ArrayList<Customer> getList() {
		Connection cons = JDBC.getConnection();
        String sql = "SELECT customer.CustomerID, customer.CustomerName, customer.PhoneNumber, customer.Turnover, customer.Address, membershipcard.Rank FROM customer " +
        		"INNER JOIN membershipcard ON customer.CardID = membershipcard.CardID ";
        ArrayList<Customer> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	Customer customer = new Customer();
            	customer.setID(rs.getString("CustomerID"));
            	customer.setName(rs.getString("CustomerName"));  
            	customer.setPhoneNumber(rs.getString("PhoneNumber"));
            	customer.setTurnover(rs.getInt("Turnover"));
            	customer.setAddress(rs.getString("Address"));
                customer.getCard().setRank(rs.getString("Rank"));
            	
                list.add(customer);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public String generateCustomerID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOrUpdate(Customer customer) {
		try {
            Connection cons = JDBC.getConnection();
            customer.getCard().setCardID("NO");
            String sql = "INSERT INTO customer(CustomerID, PhoneNumber, CustomerName, Address, Turnover, CardID) VALUES(?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE PhoneNumber = VALUES(PhoneNumber), CustomerName = VALUES(CustomerName), Address = VALUES(Address), Turnover = VALUES(Turnover), CardID = VALUES(CardID);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getID());
            ps.setString(2, customer.getPhoneNumber());
            ps.setString(3, customer.getName());
            ps.setString(4, customer.getAddress());
            ps.setInt(5, customer.getTurnover());
//            ps.setString(6, customer.getCard().getCardID());
            System.out.println(customer.getID());
            ps.execute();
            ps.close();
            cons.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	public void Insert(Customer customer) {
	    try {
	        Connection con = JDBC.getConnection();
	        Statement statement = con.createStatement();
	        
	        // Thêm dữ liệu vào bảng customer
	        String insertQuery = "INSERT INTO Product (CustomerID, PhoneNumber, CustomerName, Address, Turnover, CardID) " +
	                             "VALUES ('" + customer.getID() + "', '" + customer.getPhoneNumber() + "', '" + 
	                             customer.getName() + "', '" + customer.getAddress() + "', " + customer.getTurnover() + ", '" + 
	                             customer.getCard() + "')";
	        statement.executeUpdate(insertQuery);
	        
	        System.out.println("Thêm dữ liệu vào bảng Product thành công.");
	        
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public int Delete(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Delete(String customerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxId() {
		// TODO Auto-generated method stub
		return 0;
	}	
	
	public boolean customerExists(String phoneNumber) {
	    try {
	        Connection con = JDBC.getConnection();
	        String sql = "SELECT COUNT(*) FROM customer WHERE PhoneNumber = ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, phoneNumber);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            int count = rs.getInt(1);
	            return count > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	public Customer getCustomerInfo(String phoneNumber) {
	    Customer customer = new Customer();
	    try {
	        Connection con = JDBC.getConnection();
	        String sql = "SELECT * FROM customer WHERE PhoneNumber = ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, phoneNumber);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            customer = new Customer();
	            customer.setID(rs.getString("CustomerID"));
	            customer.setName(rs.getString("CustomerName"));
	            customer.setPhoneNumber(rs.getString("PhoneNumber"));
	            customer.setAddress(rs.getString("Address"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return customer;
	}

}
