package Service;

import java.util.ArrayList;

import DAO.ProductDAO;
import DAO.ProductDAOImpl;
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
	@Override
	public int createOrUpdate(Product product) {
		// TODO Auto-generated method stub
		return productDao.createOrUpdate(product);
	}
	@Override
	public int Delete(Product product) {
		return productDao.Delete(product);
	}
	@Override
	public int Delete(String productID) {
		return productDao.Delete(productID);
	}
	public String generateProductId() {
		return productDao.generateProductID();
	}
	public void Insert(Product product) {
		productDao.Insert(product);
	}
	public int getMaxId() {
		return productDao.getMaxId();
	}
}
