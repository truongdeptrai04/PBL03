package Service;

import java.util.ArrayList;

import Model.Customer;

public interface CustomerService {
	public ArrayList<Customer> getList();
	public String generateCustomerID();
	public void createOrUpdate(Customer customer);
	public void Insert(Customer customer);
	public int Delete(Customer customer);
	public int Delete(String customerID);
	public int getMaxId();
	public boolean customerExists(String phoneNumber);
	public Customer getCustomerInfo(String phoneNumber);
}
