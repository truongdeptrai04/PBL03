package DAO;

import java.util.ArrayList;

import Model.Employee;
import Model.Product;

public interface EmployeeDAO {
	public ArrayList<Employee> getList();
	public String generateProductID();
	public int createOrUpdate(Employee employee);
	public void Insert(Employee employee);
	public int Delete(Employee employee);
	public int Delete(String employeeID);
	public int getMaxId();
}
