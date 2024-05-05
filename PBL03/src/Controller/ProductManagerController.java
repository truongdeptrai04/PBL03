package Controller;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import Service.ProductService;
import Service.ProductServiceImpl;
import Utility.ClassTableModel;
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

    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;

    private ClassTableModel classTableModel = null;

    private final String[] COLUMNS = {"CN", "ID", "Name", "Color",
        "Size", "Type", "Price", "Quantity"};

    private ProductService productService = null;

    private TableRowSorter<TableModel> rowSorter = null;

    public ProductManagerController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.classTableModel = new ClassTableModel();
        this.productService = new ProductServiceImpl();
    }

    public void setDataToTable() {
        ArrayList<Product> listItem = productService.getList();
        DefaultTableModel model = classTableModel.setTableProduct(listItem, COLUMNS);
        JTable table = new JTable(model);

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

        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        table.getTableHeader().setBackground(new Color(218, 245, 244));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Tahoma", Font.PLAIN, 18));
        table.setShowHorizontalLines(false);
        
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