package Controller;

import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Model.Customer;
import Model.Discount;
import Model.Product;
import Service.CustomerService;
import Service.CustomerServiceImpl;
import Service.DiscountService;
import Service.DiscountServiceImpl;
import Service.ProductService;
import Service.ProductServiceImpl;
import Utility.ClassTableModel;
import View.AddProductJFrame;

public class SaleController {
	private JTextField jtfSearch, jtfQuantity, jtfPhoneNumber, jtfName, jtfAddress, jtfDiscount;
	private JLabel jlbTotal;
	private JPanel jpnView1, jpnView2;
	private JButton btnAdd, btnDelete, btnSubmit;
	private JComboBox cbbDiscount, cbbPuschasingMethod;
	
    private DefaultTableModel model1, model2;
    JTable table1, table2;
    private ClassTableModel classTableModel = null;

    private final String[] COLUMNS = {"CN", "ID", "Name", "Color",
        "Size", "Type", "Price", "Inventory"};
    
    private final String[] COLUMNS2 = {"CN", "ID", "Name", "Color",
            "Size", "Type", "Quantity", "Total"};
    
    private ProductService productService = null;
    private CustomerService customerService = null;
    private DiscountService discountService = null;
    private TableRowSorter<TableModel> rowSorter = null;
   
    
    
    private static int cn = 1;
    private ArrayList<Product> list = null;
    
	public SaleController(JTextField jtfSearch, JTextField jtfQuantity, JTextField jtfPhoneNumber, JTextField jtfName,
			JTextField jtfAddress, JComboBox cbbDiscount, JComboBox cbbPuschasingMethod, JLabel jlbTotal, JPanel jpnView1,
			JPanel jpnView2, JButton btnAdd, JButton btnDelete, JButton btnSubmit, JTextField jtfDiscount) {
		super();
		list = new ArrayList<Product>();
		model2 = new DefaultTableModel();
    	model2.addColumn("CN");
    	model2.addColumn("ID");
    	model2.addColumn("Product Name");
    	model2.addColumn("Color");
    	model2.addColumn("Size");
    	model2.addColumn("Type");
    	model2.addColumn("Quantity");
    	model2.addColumn("Total");
		this.jtfSearch = jtfSearch;
		this.jtfQuantity = jtfQuantity;
		this.jtfPhoneNumber = jtfPhoneNumber;
		this.jtfName = jtfName;
		this.jtfAddress = jtfAddress;
		this.jtfDiscount = jtfDiscount;
		this.jtfDiscount.setEnabled(false);
		this.cbbDiscount = cbbDiscount;
		this.cbbPuschasingMethod = cbbPuschasingMethod;
		this.jlbTotal = jlbTotal;
		this.jpnView1 = jpnView1;
		this.jpnView2 = jpnView2;
		this.btnAdd = btnAdd;
		this.btnDelete = btnDelete;
		this.btnSubmit = btnSubmit;
		this.classTableModel = new ClassTableModel();
		this.productService = new ProductServiceImpl();
		this.customerService = new CustomerServiceImpl();
		this.discountService = new DiscountServiceImpl();
	}

	

	public void setDataToTable() {
		ArrayList<Discount> listDiscount = discountService.getList();
        ArrayList<Product> listItem = productService.getList();
        model1 = classTableModel.setTableProduct(listItem, COLUMNS);
        table1 = new JTable(model1);
        table2 = new JTable(model2);

        rowSorter = new TableRowSorter<>(table1.getModel());
        table1.setRowSorter(rowSorter);
        
        for (Discount discount : listDiscount) {
            cbbDiscount.addItem(discount.getDiscountID());
        }
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                	updateRowNumbers(model1);
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 2));
                    
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                	updateRowNumbers(model1);
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 2));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	int selectedRow = table1.getSelectedRow();
                if (selectedRow != -1) {
                	if(jtfQuantity.getText() != null) {
                		int quantity = Integer.parseInt(jtfQuantity.getText());
                        list.add(getDataFromSelectedRow(table1, model1));
                        updateRowNumbers(model2);
                        addDataToTable(getDataFromSelectedRow(table1, model1), selectedRow, model2, quantity);
                        jtfQuantity.setText("");
                        
                        if(jtfDiscount.getText() != null) {
                        	jlbTotal.setText(Integer.toString(calculateTotal(table2, 7)) + " VND");
                        }else {
                        	double total = Double.parseDouble(jtfDiscount.getText());
                        	int discount = Integer.parseInt(jtfDiscount.getText());
                        	total = (total * discount )/ 100;
                        	jlbTotal.setText(Double.toString(total) + " VND");
                        }
                	}else {
                		JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
                	}
                	
                    } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	deleteSelectedRow(table2, model2);
            	updateRowNumbers(model2);
            	cn--;
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        jtfPhoneNumber.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	String phoneNumber = jtfPhoneNumber.getText();
                if (customerService.customerExists(phoneNumber)) {
                    Customer customer = customerService.getCustomerInfo(phoneNumber);
                    jtfName.setText(customer.getName());
                    jtfAddress.setText(customer.getAddress());
                } else {
                	jtfName.setText("");
                    jtfAddress.setText("");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	String phoneNumber = jtfPhoneNumber.getText();
                if (customerService.customerExists(phoneNumber)) {
                    Customer customer = customerService.getCustomerInfo(phoneNumber);
                    jtfName.setText(customer.getName());
                    jtfAddress.setText(customer.getAddress());
                } else {
                	jtfName.setText("");
                    jtfAddress.setText("");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
//        jtfDiscount.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                 double total = Double.parseDouble(jlbTotal.getText());
//                 int discount = Integer.parseInt(jtfDiscount.getText());
//                 total = (total * discount )/ 100;
//                 jlbTotal.setText(Double.toString(total));
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//            	 double total = Double.parseDouble(jlbTotal.getText());
//                 int discount = Integer.parseInt(jtfDiscount.getText());
//                 total = (total * discount )/ 100;
//                 jlbTotal.setText(Double.toString(total));
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//            }
//        });
        
        cbbDiscount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDiscount = (String) cbbDiscount.getSelectedItem();
                if (selectedDiscount.equals("NO")) {
                    jtfDiscount.setEnabled(false);
                    jtfDiscount.setText("");
                } else if(selectedDiscount.equals("CUSTOM")){
                	jtfDiscount.setEnabled(true);
                    jtfDiscount.setText("");
                }else {
                	for(Discount discount : listDiscount) {
                		if(discount.getDiscountID() == selectedDiscount) {
//                			jtfDiscount.setEnabled(true);
                			jtfDiscount.setText(Integer.toString((int)(discount.getDiscountPercent())));
                			setTotal(jlbTotal);
                		}
                	}
                	
                }
            }
        });
        
        
        jtfDiscount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int total = calculateTotal(table2, 7);
                int discount = Integer.parseInt(jtfDiscount.getText());
                total = total - (total * discount )/ 100;
                jlbTotal.setText(Integer.toString(total) + " VND");
            }
        });
       
        
//        jtfPhoneNumber.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String phoneNumber = jtfPhoneNumber.getText();
//                if (customerService.customerExists(phoneNumber)) {
//                    Customer customer = customerService.getCustomerInfo(phoneNumber);
//                    jtfName.setText(customer.getName());
//                    jtfAddress.setText(customer.getAddress());
//                } else {
//                    // Nếu không tồn tại, tiếp tục nhập thông tin của khách hàng và thêm mới vào cơ sở dữ liệu
//                    // Ví dụ:
//                    // String name = jtfName.getText();
//                    // String address = jtfAddress.getText();
//                    // addCustomer(phoneNumber, name, address);
//                }
//            }
//        });
            
            
//        btnAdd.addMouseListener(new MouseAdapter() {
//        	public void mousePressed(MouseEvent e) {
//        		System.out.println("Add");
//        		AddProductJFrame ac = new AddProductJFrame();
//        		ac.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//				ac.setVisible(true);
//        	}
//        });
        
//        table1.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//            	System.out.println("Hello");
//                if (SwingUtilities.isRightMouseButton(e)) {
//                    int row = table1.rowAtPoint(e.getPoint());
//                    if (row >= 0 && row < table1.getRowCount()) {
//                        table1.setRowSelectionInterval(row, row);
//                    } else {
//                        table1.clearSelection();
//                    }
//
//                    JPopupMenu popupMenu = createPopupMenu();
//                    popupMenu.show(table1, e.getX(), e.getY());
//                }
//            }
//        });
        
        
        
        // design
        table1.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        table1.getTableHeader().setBackground(new Color(218, 245, 244));
        table1.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table1.setFillsViewportHeight(true);
        table1.setRowHeight(25);
        table1.validate();
        table1.repaint();
        table1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table1.setShowVerticalLines(false);
        
        table2 = new JTable(model2);
    	// design
        table2.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table2.getTableHeader().setBackground(new Color(218, 245, 244));
        table2.getTableHeader().setPreferredSize(new Dimension(50, 25));
        table2.setFillsViewportHeight(true);
        table2.setRowHeight(25);
        table2.validate();
        table2.repaint();
        
       
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Cài đặt DefaultTableCellRenderer cho từng cột trong JTable
        for (int i = 0; i < table1.getColumnCount(); i++) {
        	if(i==2) continue;
            table1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        
        //Tuy chinh do rong cac cot
        table1.getColumnModel().getColumn(0).setMaxWidth(50);
        table1.getColumnModel().getColumn(0).setMinWidth(50);
        table1.getColumnModel().getColumn(0).setPreferredWidth(50);
        
        table1.getColumnModel().getColumn(1).setMaxWidth(80);
        table1.getColumnModel().getColumn(1).setMinWidth(80);
        table1.getColumnModel().getColumn(1).setPreferredWidth(80);
        
//        table.getColumnModel().getColumn(2).setMaxWidth(250);
//        table.getColumnModel().getColumn(2).setMinWidth(250);
//        table.getColumnModel().getColumn(2).setPreferredWidth(250);
        
        table1.getColumnModel().getColumn(3).setMaxWidth(80);
        table1.getColumnModel().getColumn(3).setMinWidth(80);
        table1.getColumnModel().getColumn(3).setPreferredWidth(80);
        
        table1.getColumnModel().getColumn(4).setMaxWidth(50);
        table1.getColumnModel().getColumn(4).setMinWidth(50);
        table1.getColumnModel().getColumn(4).setPreferredWidth(50);
        
        table1.getColumnModel().getColumn(5).setMaxWidth(150);
        table1.getColumnModel().getColumn(5).setMinWidth(150);
        table1.getColumnModel().getColumn(5).setPreferredWidth(150);
        
        table1.getColumnModel().getColumn(6).setMaxWidth(120);
        table1.getColumnModel().getColumn(6).setMinWidth(120);
        table1.getColumnModel().getColumn(6).setPreferredWidth(120);
        
        table1.getColumnModel().getColumn(7).setMaxWidth(90);
        table1.getColumnModel().getColumn(7).setMinWidth(90);
        table1.getColumnModel().getColumn(7).setPreferredWidth(90);
        
        JScrollPane scroll1 = new JScrollPane();
        scroll1.getViewport().add(table1);
        scroll1.setPreferredSize(new Dimension(1350, 400));
        jpnView1.removeAll();
        jpnView1.setLayout(new CardLayout());
        jpnView1.add(scroll1);
        jpnView1.validate();
        jpnView1.repaint();
        
        JScrollPane scroll2 = new JScrollPane();
        scroll2.getViewport().add(table2);
        scroll2.setBackground(new Color(255, 255, 255));
        scroll2.setPreferredSize(new Dimension(640, 270));
        jpnView2.removeAll();
        jpnView2.setLayout(new CardLayout());
        jpnView2.add(scroll2);
        jpnView2.validate();
        jpnView2.repaint();
    }
	
	public void updateRowNumbers(DefaultTableModel model1) {
        for (int i = 0; i < model1.getRowCount(); i++) {
            model1.setValueAt(i + 1, i, 0); 
        }
    }
	
//    private final String[] COLUMNS = {"CN", "ID", "Name", "Color",
//            "Size", "Type", "Price", "Inventory"};
	private Product getDataFromSelectedRow(JTable table1, DefaultTableModel model1) {
		int selectedRow = table1.getSelectedRow();
		Product product = new Product();
		product.setID((String) model1.getValueAt(selectedRow, 1));
        product.setDiscount("NO");
    	product.setName((String) model1.getValueAt(selectedRow, 2)); 
        product.setType((String) model1.getValueAt(selectedRow, 5)); 
        product.setColor((String) model1.getValueAt(selectedRow, 3)); 
       product.setSize((String) model1.getValueAt(selectedRow, 4)); 
       product.setPrice((int) model1.getValueAt(selectedRow, 6));
       product.setQuantity((int) model1.getValueAt(selectedRow, 7));
       return product;
	}
       
//	private final String[] COLUMNS2 = {"CN", "ID", "Name", "Color",
//            "Size", "Type", "Quantity", "Total"};
	private void addDataToTable(Product product,  int selectedRow, DefaultTableModel model2, int quantity) {
		int index = findRowIndexByValue(model2, product.getID(), 1);
		if(index != -1) {
			int count = (int)model2.getValueAt(index, 6);
			count += quantity;
			int total = count * product.getPrice();
			model2.setValueAt(count, index, 6);
			model2.setValueAt(total, index, 7);
		}else {
			int cn = this.cn;
	    	String productID = product.getID();
	    	String productName = product.getName();
	        String productType	 = product.getType();
	        String color = product.getColor();
	        String size = product.getSize();
	        int total = quantity * product.getPrice();
	        System.out.println(total);
	        model2.addRow(new Object[]{cn, productID, productName, color, size, productType, quantity, total});
	        this.cn++;
		}
    }
	private int findRowIndexByValue(DefaultTableModel table, String value, int columnIndex) {
	    int rowCount = table.getRowCount();
	    for (int i = 0; i < rowCount; i++) {
	        Object cellValue = table.getValueAt(i, columnIndex);
	        if (cellValue != null && cellValue.equals(value)) {
	            return i;
	        }
	    }
	    return -1;
	}
	private void deleteSelectedRow(JTable table, DefaultTableModel model) {
	    int selectedRow = table.getSelectedRow();
	    if (selectedRow != -1) {
	    	model.removeRow(selectedRow);
	    } else {
	    	JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
	}
	public int calculateTotal(JTable table, int columnIndex) {
	    int sum = 0;
	    int rowCount = table.getRowCount();
	    for (int i = 0; i < rowCount; i++) {
	        int value = (int) table.getValueAt(i, columnIndex);
	        sum+=value;
	    }
	    return sum;
	}
	public void setTotal(JLabel jlbTotal) {
		int total = calculateTotal(table2, 7);
        int discount = Integer.parseInt(jtfDiscount.getText());
        total = total - (total * discount )/ 100;
        jlbTotal.setText(Integer.toString(total) + " VND");
	}
	
}
