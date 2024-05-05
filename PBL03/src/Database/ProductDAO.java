package Database;

import java.util.ArrayList;
import Model.Product;

public interface ProductDAO {
	public ArrayList<Product> getList();
	
	public int createOrUpdate(Product product);
}
