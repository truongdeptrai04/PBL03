package DAO;

import java.util.ArrayList;
import Model.Product;

public interface ProductDAO {
	public ArrayList<Product> getList();
	
	public String generateProductID();
	public int createOrUpdate(Product product);
	public void Insert(Product products);
	public int Delete(Product product);
	public int Delete(String ProductID);
	public int getMaxId();
}
