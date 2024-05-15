package Service;

import java.util.ArrayList;

import DAO.CustomerDAO;
import DAO.CustomerDAOImpl;
import DAO.EmployeeDAO;
import DAO.EmployeeDAOImpl;
import Model.Customer;

public class CustomerServiceImpl implements CustomerService{
	private CustomerDAO customerDAO = null;
	public CustomerServiceImpl() {
		this.customerDAO = new CustomerDAOImpl();
	}
	
	@Override
	public String generateCustomerID() {
		// TODO Auto-generated method stub
		return customerDAO.generateCustomerID();
	}

	@Override
	public void createOrUpdate(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.createOrUpdate(customer);
	}

	@Override
	public void Insert(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.Insert(customer);
	}

	@Override
	public int Delete(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.Delete(customer);
	}

	@Override
	public int Delete(String customerID) {
		// TODO Auto-generated method stub
		return customerDAO.Delete(customerID);
	}

	@Override
	public int getMaxId() {
		// TODO Auto-generated method stub
		return customerDAO.getMaxId();
	}

	@Override
	public ArrayList<Customer> getList() {
		// TODO Auto-generated method stub
		return customerDAO.getList();
	}

	@Override
	public boolean customerExists(String phoneNumber) {
		// TODO Auto-generated method stub
		return customerDAO.customerExists(phoneNumber);
	}

	@Override
	public Customer getCustomerInfo(String phoneNumber) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomerInfo(phoneNumber);
	}

}
