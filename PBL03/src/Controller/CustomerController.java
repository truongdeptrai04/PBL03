package Controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Model.Customer;
import Model.Employee;
import Service.CustomerService;
import Service.CustomerServiceImpl;
import Service.EmployeeServiceImpl;
import Utility.CustomerTableModel;
import Utility.EmployeeTableModel;
import View.CustomerUpdateJFrame;


public class CustomerController {
	private DefaultTableModel model;
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    JTable table;
    private CustomerTableModel customerTableModel = null;

    private final String[] COLUMNS = {"ID", "Name", "Phone", "Address",
        "Turnover", "Rank"};

    private CustomerService customerService = null;

    private TableRowSorter<TableModel> rowSorter = null;
    
    public CustomerController(JPanel jpnView, JTextField jtfSearch, JButton btnAdd) {
    	table = new JTable();
    	this.jpnView = jpnView;
    	this.jtfSearch = jtfSearch;
    	this.btnAdd = btnAdd;
    	this.customerTableModel = new CustomerTableModel();
    	customerService = new CustomerServiceImpl();
    }
    
    public void setDataToTable() {
        ArrayList<Customer> listItem = customerService.getList();
        model = customerTableModel.setTableEmployee(listItem, COLUMNS);
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
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 2));
                    
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 2));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        
        
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
        
//        //Tuy chinh do rong cac cot
//        table.getColumnModel().getColumn(0).setMaxWidth(60);
//        table.getColumnModel().getColumn(0).setMinWidth(60);
//        table.getColumnModel().getColumn(0).setPreferredWidth(60);
//        
//        table.getColumnModel().getColumn(1).setMaxWidth(180);
//        table.getColumnModel().getColumn(1).setMinWidth(180);
//        table.getColumnModel().getColumn(1).setPreferredWidth(180);
//        
//        table.getColumnModel().getColumn(2).setMaxWidth(200);
//        table.getColumnModel().getColumn(2).setMinWidth(200);
//        table.getColumnModel().getColumn(2).setPreferredWidth(200);
//        
//        table.getColumnModel().getColumn(3).setMaxWidth(120);
//        table.getColumnModel().getColumn(3).setMinWidth(120);
//        table.getColumnModel().getColumn(3).setPreferredWidth(120);
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
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                   if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                          DefaultTableModel model = (DefaultTableModel) table.getModel();
                          int selectedRowIndex = table.getSelectedRow();
                          
                          selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                          
                          Customer customer = new Customer();
                          customer.setID(model.getValueAt(selectedRowIndex, 0).toString());
                          customer.setName(model.getValueAt(selectedRowIndex, 1).toString());
                          customer.setPhoneNumber(model.getValueAt(selectedRowIndex, 2).toString());
                          customer.setAddress(model.getValueAt(selectedRowIndex, 3).toString());
                          customer.setTurnover((int)model.getValueAt(selectedRowIndex, 4));
                          customer.getCard().setRank(model.getValueAt(selectedRowIndex, 0).toString());
//                          hocVien.setMa_hoc_vien((int) model.getValueAt(selectedRowIndex, 0));
//                          hocVien.setHo_ten(model.getValueAt(selectedRowIndex, 2).toString());
//                          hocVien.setNgay_sinh(classFormat.covertDateToDateSql(
//                                  classFormat.covertStringToDate(model.getValueAt(selectedRowIndex, 3).toString(), "dd/MM/yyyy")));
//                          hocVien.setGioi_tinh(model.getValueAt(selectedRowIndex, 4).toString().equalsIgnoreCase("Nam"));
//                          hocVien.setSo_dien_thoai(model.getValueAt(selectedRowIndex, 5) != null
//                                  ? model.getValueAt(selectedRowIndex, 5).toString() : null);
//                          hocVien.setDia_chi(model.getValueAt(selectedRowIndex, 6) != null
//                                  ? model.getValueAt(selectedRowIndex, 6).toString() : null);
//                          hocVien.setTinh_trang((boolean) model.getValueAt(selectedRowIndex, 7));
//
                          CustomerUpdateJFrame frame = new CustomerUpdateJFrame(customer);
                          frame.setLocationRelativeTo(null);
                          frame.setResizable(false);
                          frame.setTitle("Customer Information");
                          frame.setVisible(true);
                   }
            }

      });
        
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
