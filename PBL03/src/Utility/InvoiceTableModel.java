package Utility;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Model.Invoice;
import Model.Product;

public class InvoiceTableModel {
	public DefaultTableModel setTableInvoice(ArrayList<Invoice> listItem, String[] listColumn) {
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
//			"ID", "Customer Name", "Phone",
//	        "Employee Name", "Discount", "Total", "Date"
		};
		dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        Invoice invoice = null;
        for (int i = 0; i < num; i++) {
        	invoice = listItem.get(i);
            obj = new Object[columns];
            obj[0] = invoice.getInvoiceID();
            obj[1] = invoice.getCustomer().getName();
            obj[2] = invoice.getCustomer().getPhoneNumber();
            obj[3] = invoice.getEmployee().getName();
            obj[4] = invoice.getDiscount().getDiscountPercent();
            obj[5] = invoice.getTotal();
            obj[6] = invoice.getDate();
            dtm.addRow(obj);
        }
        return dtm;
	}
}
