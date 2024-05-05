package Utility;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Model.Product;

public class ClassTableModel {
	public DefaultTableModel setTableProduct(ArrayList<Product> listItem, String[] listColumn) {
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
        Product product = null;
        for (int i = 0; i < num; i++) {
        	product = listItem.get(i);
            obj = new Object[columns];
            obj[0] = (i + 1);
            obj[1] = product.getID();
            obj[2] = product.getName();
            obj[3] = product.getColor();
            obj[4] = product.getSize();
            obj[5] = product.getType();
            obj[6] = product.getPrice();
            obj[7] = product.getQuantity();
            dtm.addRow(obj);
        }
        return dtm;
	}
}
