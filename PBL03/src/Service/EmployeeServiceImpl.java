package Service;

import java.util.ArrayList;

import DAO.EmployeeDAO;
import DAO.EmployeeDAOImpl;
import Model.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDAO employeeDAO = null;
	public EmployeeServiceImpl() {
		this.employeeDAO = new EmployeeDAOImpl();
		}
	@Override
	public ArrayList<Employee> getList() {
		return employeeDAO.getList();
	}

	@Override
	public String generateProductID() {
		return employeeDAO.generateProductID();
	}

	@Override
	public int createOrUpdate(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.createOrUpdate(employee);
	}

	@Override
	public void Insert(Employee employee) {
		// TODO Auto-generated method stub
		employeeDAO.Insert(employee);
	}

	@Override
	public int Delete(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.Delete(employee);
	}

	@Override
	public int Delete(String employeeID) {
		// TODO Auto-generated method stub
		return employeeDAO.Delete(employeeID);
	}

	@Override
	public int getMaxId() {
		// TODO Auto-generated method stub
		return employeeDAO.getMaxId();
	}
	
}
