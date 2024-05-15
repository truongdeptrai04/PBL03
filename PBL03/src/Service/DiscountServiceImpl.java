package Service;

import java.util.ArrayList;

import DAO.CustomerDAO;
import DAO.CustomerDAOImpl;
import DAO.DiscountDAO;
import DAO.DiscountDAOImpl;
import Model.Discount;

public class DiscountServiceImpl implements DiscountService{
	private DiscountDAO discountDAO = null;
	public DiscountServiceImpl() {
		this.discountDAO = new DiscountDAOImpl();
	}
	@Override
	public boolean isDiscountValid(String discountID) {
		// TODO Auto-generated method stub
		return discountDAO.isDiscountValid(discountID);
	}

	@Override
	public ArrayList<Discount> getList() {
		// TODO Auto-generated method stub
		return discountDAO.getList();
	}

}
