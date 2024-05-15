package Service;

import java.util.ArrayList;

import Model.Discount;

public interface DiscountService {
	public boolean isDiscountValid(String discountID);
	public ArrayList<Discount> getList();
}
