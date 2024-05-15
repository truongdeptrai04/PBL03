package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Model.Customer;
import Model.Discount;
import Model.Product;

public class DiscountDAOImpl implements DiscountDAO{
	public boolean isDiscountValid(String discountID) {
        boolean isValid = false;
        try {
            // Lấy ngày hiện tại
            java.util.Date currentDate = new java.util.Date();
            java.sql.Date sqlCurrentDate = new java.sql.Date(currentDate.getTime());

            // Lấy ngày kết thúc của mã giảm giá từ cơ sở dữ liệu
            Connection con = JDBC.getConnection();
	        String sql = "SELECT EndTime FROM discount WHERE DiscountID = ?";
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, discountID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                java.sql.Date endTime = rs.getDate("EndTime");
                // So sánh ngày hiện tại với ngày kết thúc của mã giảm giá
                if (endTime != null && !sqlCurrentDate.after(endTime)) {
                    isValid = true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return isValid;
    }
	
	public ArrayList<Discount> getList() {
        ArrayList<Discount> list = new ArrayList<>();
        String sql = "SELECT * FROM discount";
        
        try (Connection cons = JDBC.getConnection();
             PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Discount discount = new Discount();
                discount.setDiscountID(rs.getString("DiscountID"));
                discount.setDiscountPercent(rs.getDouble("DiscountPercent"));
                discount.setStartTime(rs.getDate("StartTime"));
                discount.setEndTime(rs.getDate("EndTime"));
                list.add(discount);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
	
}
