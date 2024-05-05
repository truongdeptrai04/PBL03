package Database;

import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Model.Product;

public class ProductDAOImpl implements ProductDAO{

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
                product.setPrice(rs.getDouble("Price"));
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

}
