package Database;
import java.sql.*;
public class JDBC {
	public static Connection getConnection() {
		Connection c = null;
		
		try {
			//DANG KY DRIVERMANAGER MYSQL
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url = "jdbc:mySQL://localhost:3306/qlbh";
			String username = "root";
			String password = "";
			// TAO KET NOI
			c = DriverManager.getConnection(url, username, password);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch ( Exception e) {
			e.printStackTrace();
		}
		//tesst
		//test nưa
	}

}
