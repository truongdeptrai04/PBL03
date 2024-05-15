package Utility;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Model.Employee;
import Model.Product;

public class EmployeeTableModel {
	public DefaultTableModel setTableEmployee(ArrayList<Employee> listItem, String[] listColumn) {
		int columns  = listColumn.length;
		DefaultTableModel dtm = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
			
//            @Override
//            public Class<?> getColumnClass(int columnIndex) {
//                return columnIndex == 5 ? Boolean.class : String.class;
//            }
		};
		dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        Employee employee = null;
        for (int i = 0; i < num; i++) {
        	employee = listItem.get(i);
            obj = new Object[columns];
            obj[0] = employee.getID();
            obj[1] = employee.getName();
            obj[2] = employee.getEmail();
            obj[3] = employee.getPhoneNumber();
            obj[4] = employee.getAddress();
            obj[5] = employee.getAccount().getUsername();
            obj[6] = employee.getAccount().getPassword();
            obj[7] = employee.getPosition();
            dtm.addRow(obj);
        }
        return dtm;
	}
}
