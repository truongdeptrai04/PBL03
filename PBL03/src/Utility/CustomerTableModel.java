package Utility;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Model.Customer;
import Model.Employee;

public class CustomerTableModel {
	public DefaultTableModel setTableEmployee(ArrayList<Customer> listItem, String[] listColumn) {
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
        Customer customer = null;
        for (int i = 0; i < num; i++) {
        	customer = listItem.get(i);
            obj = new Object[columns];
            obj[0] = customer.getID();
            obj[1] = customer.getName();
            obj[2] = customer.getPhoneNumber();
            obj[3] = customer.getAddress();
            obj[4] = customer.getTurnover();
            obj[5] = customer.getCard().getRank();
            

            dtm.addRow(obj);
        }
        return dtm;
	}
}
