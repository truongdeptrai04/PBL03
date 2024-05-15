package Controller;

import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Model.Invoice;
import Model.Product;
import Service.InvoiceService;
import Service.InvoiceServiceImpl;
import Service.ProductService;
import Utility.ClassTableModel;
import Utility.InvoiceTableModel;
import View.AddProductJFrame;

public class InvoiceController {
	private JLabel jlbInvoiceQuantity, jlbTotal;
	private Choice cFilter;
	private JTextField jtfSearch;
	private JButton btnDelete;
	private JPanel jpnView;
	private DefaultTableModel model;
    JTable table;
    private InvoiceTableModel invoiceTableModel = null;
    
    private final String[] COLUMNS = {"ID", "Customer Name", "Phone",
        "Employee Name", "Discount", "Total", "Date"};

    private InvoiceService invoiceService = null;

    private TableRowSorter<TableModel> rowSorter = null;

	public InvoiceController(JLabel jlbInvoiceQuantity, JLabel jlbTotal, Choice cFilter, JTextField jtfSearch,
			JButton btnDelete, JPanel jpnView) {
		super();
		table = new JTable();
		this.jlbInvoiceQuantity = jlbInvoiceQuantity;
		this.jlbTotal = jlbTotal;
		this.cFilter = cFilter;
		this.jtfSearch = jtfSearch;
		this.btnDelete = btnDelete;
		this.jpnView = jpnView;
		this.invoiceTableModel = new InvoiceTableModel();
		invoiceService = new InvoiceServiceImpl();
	}

	// Thiết lập TableCellRenderer cho cột chứa giá trị double trong JTable
	
	private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
    
	public int calculateTotal(JTable table, int columnIndex) {
	    int total = 0;
	    int rowCount = table.getRowCount();
	    for (int i = 0; i < rowCount; i++) {
	        double value = Integer.parseInt(table.getValueAt(i, columnIndex).toString());
	        total += value;
	    }
	    return total;
	}
	
	public void setDataToTable() {
        ArrayList<Invoice> listItem = invoiceService.getList();
        model = invoiceTableModel.setTableInvoice(listItem, COLUMNS);
        table = new JTable(model);

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 0));
                    
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 0));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                	if(showDialog()) {
                		String id = (String) table.getValueAt(selectedRow, 0);
                    	invoiceService.Delete(id);
                    	
                        model.removeRow(selectedRow);
                	}
                }
            }
        });;
        
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        table.getTableHeader().setBackground(new Color(218, 245, 244));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setFillsViewportHeight(true);
        table.setRowHeight(25);
        table.validate();
        table.repaint();
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setShowVerticalLines(false);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        
        for (int i = 0; i < table.getColumnCount(); i++) {
        	if(i==1 || i == 3) continue;
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        //Tuy chinh do rong cac cot
        table.getColumnModel().getColumn(0).setMaxWidth(60);
        table.getColumnModel().getColumn(0).setMinWidth(60);
        table.getColumnModel().getColumn(0).setPreferredWidth(60);
        
//        table.getColumnModel().getColumn(1).setMaxWidth(80);
//        table.getColumnModel().getColumn(1).setMinWidth(80);
//        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        
        table.getColumnModel().getColumn(2).setMaxWidth(120);
        table.getColumnModel().getColumn(2).setMinWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(120);
        
//        table.getColumnModel().getColumn(3).setMaxWidth(80);
//        table.getColumnModel().getColumn(3).setMinWidth(80);
//        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        
        table.getColumnModel().getColumn(4).setMaxWidth(100);
        table.getColumnModel().getColumn(4).setMinWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        
        table.getColumnModel().getColumn(5).setMaxWidth(100);
        table.getColumnModel().getColumn(5).setMinWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        
        table.getColumnModel().getColumn(6).setMaxWidth(120);
        table.getColumnModel().getColumn(6).setMinWidth(120);
        table.getColumnModel().getColumn(6).setPreferredWidth(120);

        int invoiceTotal = calculateTotal(table, 5);
        jlbTotal.setText(String.valueOf(invoiceTotal));
        
        int rowCount = model.getRowCount();
        jlbInvoiceQuantity.setText(String.valueOf(rowCount));
        
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
	}
	
}
