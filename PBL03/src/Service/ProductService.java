package Service;

import java.util.ArrayList;

import Model.Product;

public interface ProductService {
	public ArrayList<Product> getList();
	public int createOrUpdate(Product product);
	int Delete(Product product);
	int Delete(String productID);
	public String generateProductId();
	public void Insert(Product product);
	public int getMaxId();
}
