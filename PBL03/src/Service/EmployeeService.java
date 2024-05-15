package Service;

import java.util.ArrayList;

import Model.Employee;

public interface EmployeeService {
	public ArrayList<Employee> getList();
	public String generateProductID();
	public int createOrUpdate(Employee employee);
	public void Insert(Employee employee);
	public int Delete(Employee employee);
	public int Delete(String employeeID);
	public int getMaxId();
}
