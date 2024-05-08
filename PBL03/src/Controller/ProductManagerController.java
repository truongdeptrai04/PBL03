package Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import Service.ProductService;
import Service.ProductServiceImpl;
import Utility.ClassTableModel;
import View.AddProductJFrame;
import View.MainJFrame;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Model.Product;

/**
 *
 * @author TVD
 */
public class ProductManagerController {
	private DefaultTableModel model;
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    JTable table;
    private ClassTableModel classTableModel = null;

    private final String[] COLUMNS = {"CN", "ID", "Name", "Color",
        "Size", "Type", "Price", "Quantity"};

    private ProductService productService = null;

    private TableRowSorter<TableModel> rowSorter = null;

    public ProductManagerController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
    	table = new JTable();
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.classTableModel = new ClassTableModel();
        this.productService = new ProductServiceImpl();
        
    }
    public void updateRowNumbers(DefaultTableModel model) {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i + 1, i, 0); 
        }
    }
    public JPopupMenu createPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem("Xóa");
        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                	if(showDialog()) {
                		String id = (String) table.getValueAt(selectedRow, 1);
                    	productService.Delete(id);
                    	
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.removeRow(selectedRow);
                        updateRowNumbers(model);
                	}
                }
            }
        });
        popupMenu.add(deleteItem);
        return popupMenu;
    }
    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
    public void setDataToTable() {
        ArrayList<Product> listItem = productService.getList();
        model = classTableModel.setTableProduct(listItem, COLUMNS);
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
                	updateRowNumbers(model);
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 2));
                    
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                	updateRowNumbers(model);
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 2));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        btnAdd.addMouseListener(new MouseAdapter() {
        	public void mousePressed(MouseEvent e) {
        		System.out.println("Add");
        		AddProductJFrame ac = new AddProductJFrame();
        		ac.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				ac.setVisible(true);
        	}
        });
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	System.out.println("Hello");
                if (SwingUtilities.isRightMouseButton(e)) {
                    int row = table.rowAtPoint(e.getPoint());
                    if (row >= 0 && row < table.getRowCount()) {
                        table.setRowSelectionInterval(row, row);
                    } else {
                        table.clearSelection();
                    }

                    JPopupMenu popupMenu = createPopupMenu();
                    popupMenu.show(table, e.getX(), e.getY());
                }
            }
        });
        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        table.getTableHeader().setBackground(new Color(218, 245, 244));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setFillsViewportHeight(true);
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Tahoma", Font.PLAIN, 18));
        table.setShowVerticalLines(false);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Cài đặt DefaultTableCellRenderer cho từng cột trong JTable
        for (int i = 0; i < table.getColumnCount(); i++) {
        	if(i==2) continue;
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        //Tuy chinh do rong cac cot
        table.getColumnModel().getColumn(0).setMaxWidth(50);
        table.getColumnModel().getColumn(0).setMinWidth(50);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        
        table.getColumnModel().getColumn(1).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setMinWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        
//        table.getColumnModel().getColumn(2).setMaxWidth(250);
//        table.getColumnModel().getColumn(2).setMinWidth(250);
//        table.getColumnModel().getColumn(2).setPreferredWidth(250);
        
        table.getColumnModel().getColumn(3).setMaxWidth(80);
        table.getColumnModel().getColumn(3).setMinWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        
        table.getColumnModel().getColumn(4).setMaxWidth(50);
        table.getColumnModel().getColumn(4).setMinWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        
        table.getColumnModel().getColumn(5).setMaxWidth(150);
        table.getColumnModel().getColumn(5).setMinWidth(150);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);
        
        table.getColumnModel().getColumn(6).setMaxWidth(120);
        table.getColumnModel().getColumn(6).setMinWidth(120);
        table.getColumnModel().getColumn(6).setPreferredWidth(120);
        
        table.getColumnModel().getColumn(7).setMaxWidth(90);
        table.getColumnModel().getColumn(7).setMinWidth(90);
        table.getColumnModel().getColumn(7).setPreferredWidth(90);
        
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