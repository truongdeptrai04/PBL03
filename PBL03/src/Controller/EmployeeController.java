package Controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Model.Employee;
import Model.Invoice;
import Service.EmployeeService;
import Service.EmployeeServiceImpl;
import Service.ProductService;
import Utility.EmployeeTableModel;
import Utility.ClassTableModel;

public class EmployeeController {
	private DefaultTableModel model;
    private JPanel jpnView;
    private JButton btnAdd, btnDelete;
    private JTextField jtfSearch;
    JTable table;
    private EmployeeTableModel employeeTableModel = null;

    private final String[] COLUMNS = {"ID", "Name", "Email", "Phone",
        "Address", "Username", "Password", "Position"};

    private EmployeeService employeeService = null;

    private TableRowSorter<TableModel> rowSorter = null;
    
    public EmployeeController(JPanel jpnView, JTextField jtfSearch, JButton btnAdd, JButton btnDelete) {
    	table = new JTable();
    	this.jpnView = jpnView;
    	this.jtfSearch = jtfSearch;
    	this.btnAdd = btnAdd;
    	this.btnDelete = btnDelete;
    	this.employeeTableModel = new EmployeeTableModel();
    	employeeService = new EmployeeServiceImpl();
    }
    
    public void setDataToTable() {
        ArrayList<Employee> listItem = employeeService.getList();
        model = employeeTableModel.setTableEmployee(listItem, COLUMNS);
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
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1));
                    
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1));
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
                    	employeeService.Delete(id);
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
        	if(i==1 || i == 2 || i == 4 || i == 5 || i == 6) continue;
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        //Tuy chinh do rong cac cot
        table.getColumnModel().getColumn(0).setMaxWidth(60);
        table.getColumnModel().getColumn(0).setMinWidth(60);
        table.getColumnModel().getColumn(0).setPreferredWidth(60);
        
        table.getColumnModel().getColumn(1).setMaxWidth(180);
        table.getColumnModel().getColumn(1).setMinWidth(180);
        table.getColumnModel().getColumn(1).setPreferredWidth(180);
        
        table.getColumnModel().getColumn(2).setMaxWidth(200);
        table.getColumnModel().getColumn(2).setMinWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        
        table.getColumnModel().getColumn(3).setMaxWidth(120);
        table.getColumnModel().getColumn(3).setMinWidth(120);
        table.getColumnModel().getColumn(3).setPreferredWidth(120);
//        
//        table.getColumnModel().getColumn(4).setMaxWidth(100);
//        table.getColumnModel().getColumn(4).setMinWidth(100);
//        table.getColumnModel().getColumn(4).setPreferredWidth(100);
//        
//        table.getColumnModel().getColumn(5).setMaxWidth(100);
//        table.getColumnModel().getColumn(5).setMinWidth(100);
//        table.getColumnModel().getColumn(5).setPreferredWidth(100);
//        
//        table.getColumnModel().getColumn(6).setMaxWidth(120);
//        table.getColumnModel().getColumn(6).setMinWidth(120);
//        table.getColumnModel().getColumn(6).setPreferredWidth(120);
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
	}
	
	private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
}
