package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Employee;
import Model.Product;

public class EmployeeDAOImpl implements EmployeeDAO{
	public ArrayList<Employee> getList() {
		Connection cons = JDBC.getConnection();
        String sql = "SELECT * FROM employee " +
        		"INNER JOIN account ON employee.EmployeeID = account.EmployeeID ";
        ArrayList<Employee> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	Employee employee = new Employee();
            	employee.setID(rs.getString("EmployeeID"));
            	employee.setName(rs.getString("EmployeeName"));  
            	employee.setEmail(rs.getString("Email"));
            	employee.setPhoneNumber(rs.getString("PhoneNumber"));
            	employee.setAddress(rs.getString("Address"));
            	employee.getAccount().setUsername(rs.getString("Username"));
            	employee.getAccount().setPassword(rs.getString("Password"));
            	employee.setPosition(rs.getString("Position"));
            	
                list.add(employee);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public String generateProductID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createOrUpdate(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Insert(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int Delete(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Delete(String employeeID) {
		int kq = 0;
	    PreparedStatement deleteFromEmployee = null;
	    PreparedStatement deleteFromAccount = null;
		try {
			Connection con = JDBC.getConnection();
	        con.setAutoCommit(false); // Bắt đầu giao dịch

	        // Xóa hàng từ bảng finalcialbudgeting trước
	        String deleteAccountSQL = "DELETE FROM account WHERE EmployeeID = ?";
	        deleteFromAccount = con.prepareStatement(deleteAccountSQL);
	        deleteFromAccount.setString(1, employeeID);
	        kq += deleteFromAccount.executeUpdate();

	        // Sau đó xóa hàng từ bảng product
	        String deleteEmployeeSQL = "DELETE FROM employee WHERE EmployeeID = ?";
	        deleteFromEmployee = con.prepareStatement(deleteEmployeeSQL);
	        deleteFromEmployee.setString(1, employeeID);
	        kq += deleteFromEmployee.executeUpdate();

	        con.commit();
			
			System.out.println("Ban da thuc thi: " + deleteFromEmployee);
			System.out.println("Co " + kq + " dong bi thay doi");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getMaxId() {
		// TODO Auto-generated method stub
		return 0;
	}


}
