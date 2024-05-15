package DAO;

import java.sql.*;
import java.util.ArrayList;

//import com.mysql.jdbc.PreparedStatement;

import Model.Product;

public class ProductDAOImpl implements ProductDAO{
	public static ProductDAOImpl getInstance() {
		return new ProductDAOImpl();
	}
	
	@Override
	public ArrayList<Product> getList() {
		Connection cons = JDBC.getConnection();
        String sql = "SELECT * FROM product";
        ArrayList<Product> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("Name"));
                product.setID(rs.getString("ProductID"));
                product.setType(rs.getString("Type"));
//                product.setDiscount(rs.getString("dia_chi"));
                product.setPrice(rs.getInt("Price"));
                product.setQuantity(rs.getInt("Quantity"));
                product.setColor(rs.getString("Color"));
                product.setSize(rs.getString("Size"));
                list.add(product);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
	}
	
	@Override
    public int createOrUpdate(Product product) {
        try {
            Connection cons = JDBC.getConnection();
            String sql = "INSERT INTO product(ProductID, Name, Type, Color, Quantity, Size, Price) VALUES(?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE ProductID = VALUES(ProductID), Name = VALUES(Name), Type = VALUES(Type), Color = VALUES(Color), Quantity = VALUES(Quantity), Size = VALUES(Size), Price = VALUES(Price);";
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, product.getID());   
            ps.setString(2, product.getName());
            ps.setString(3, product.getType());
            ps.setString(4, product.getColor());
            ps.setInt(5, product.getQuantity());
            ps.setString(6, product.getSize());
            ps.setDouble(7, product.getPrice());
            
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

	@Override
	public int Delete(Product product) {
		int kq = 0;
		try {
			Connection con = JDBC.getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE from product " + 
					" WHERE ProductID='" + product.getID() + "'";
			System.out.println(sql);
			kq = st.executeUpdate(sql);
			
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("Co " + kq + " dong bi thay doi");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int Delete(String productID) {
		int kq = 0;
	    PreparedStatement deleteFromProduct = null;
	    PreparedStatement deleteFromFinalcialbudgeting = null;
		try {
			Connection con = JDBC.getConnection();
	        con.setAutoCommit(false); // Bắt đầu giao dịch

	        // Xóa hàng từ bảng finalcialbudgeting trước
	        String deleteFinalcialbudgetingSQL = "DELETE FROM finalcialbudgeting WHERE ProductID = ?";
	        deleteFromFinalcialbudgeting = con.prepareStatement(deleteFinalcialbudgetingSQL);
	        deleteFromFinalcialbudgeting.setString(1, productID);
	        kq += deleteFromFinalcialbudgeting.executeUpdate();

	        // Sau đó xóa hàng từ bảng product
	        String deleteProductSQL = "DELETE FROM product WHERE ProductID = ?";
	        deleteFromProduct = con.prepareStatement(deleteProductSQL);
	        deleteFromProduct.setString(1, productID);
	        kq += deleteFromProduct.executeUpdate();

	        con.commit();
			
			System.out.println("Ban da thuc thi: " + deleteProductSQL);
			System.out.println("Co " + kq + " dong bi thay doi");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

//	public void Insert(Product product) {
//		int kq = 0;
//		try {
//			Connection con = JDBC.getConnection();
//			Statement ps = con.createStatement();
//			String sql = "INSERT INTO product (ProductID, Name, Type, Color, Quantity, Size, Price, DiscountID) " +
//		             "VALUES ('" + product.getID() + "', '" + product.getName() + "', '" + product.getType() + "', '" + 
//		             product.getColor() + "', " + product.getQuantity() + ", '" + product.getSize() + "', " + 
//		             product.getPrice() + ", " + product.getDiscount() + ")";
//			System.out.println("Ban da thuc thi");
//			kq=ps.executeUpdate(sql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public void Insert(Product product) {
	    try {
	        Connection con = JDBC.getConnection();
	        Statement statement = con.createStatement();
	        
	        // Thêm dữ liệu vào bảng Product
	        String insertQuery = "INSERT INTO Product (ProductID, Name, Type, Color, Quantity, Size, Price, DiscountID) " +
	                             "VALUES ('" + product.getID() + "', '" + product.getName() + "', '" + 
	                             product.getType() + "', '" + product.getColor() + "', " + product.getQuantity() + ", '" + 
	                             product.getSize() + "', " + product.getPrice() + ", '" + product.getDiscount() + "')";
	        statement.executeUpdate(insertQuery);
	        
	        System.out.println("Thêm dữ liệu vào bảng Product thành công.");
	        
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public int getMaxId() {
		int productID = 0000;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = JDBC.getConnection();
            String sql = "SELECT MAX(ProductID) FROM product";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String maxProductID = rs.getString(1);
                if (maxProductID == null) {
                    // Nếu không có bản ghi nào trong bảng product
                	String lastNumber = "0000";
                	return Integer.parseInt(lastNumber);
                } else {
                    // Lấy số cuối cùng trong productID, ví dụ từ "PR00005" lấy "00005"
                    String lastNumber = maxProductID.substring(2);
                    // Chuyển đổi số thành integer và tăng lên 1
                    return Integer.parseInt(lastNumber);
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return productID;
	}
	public String generateProductID() {
        String productID = "";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = JDBC.getConnection();
            String sql = "SELECT MAX(ProductID) FROM product";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String maxProductID = rs.getString(1);
                if (maxProductID == null) {
                    // Nếu không có bản ghi nào trong bảng product
                    productID = "PR0001";
                } else {
                    // Lấy số cuối cùng trong productID, ví dụ từ "PR00005" lấy "00005"
                    String lastNumber = maxProductID.substring(2);
                    // Chuyển đổi số thành integer và tăng lên 1
                    int nextNumber = Integer.parseInt(lastNumber) + 1;
                    // Tạo lại productID với số mới
                    productID = String.format("PR%04d", nextNumber);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return productID;
    }

}
