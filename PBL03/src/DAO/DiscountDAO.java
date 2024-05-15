package DAO;

import java.util.ArrayList;

import Model.Discount;

public interface DiscountDAO {
	public boolean isDiscountValid(String discountID);
	public ArrayList<Discount> getList();
}
