package Service;

import java.util.ArrayList;

import Database.ProductDAO;
import Database.ProductDAOImpl;
import Model.Product;

public class ProductServiceImpl implements ProductService{
	private ProductDAO productDao = null;
	public ProductServiceImpl() {
		this.productDao = new ProductDAOImpl();
		}
	@Override
	public ArrayList<Product> getList() {
		// TODO Auto-generated method stub
		return productDao.getList();
	}

}
