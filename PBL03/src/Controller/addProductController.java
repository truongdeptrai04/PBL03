package Controller;

import Model.Product;
import Service.ProductService;
import Service.ProductServiceImpl;
import Utility.ClassTableModel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class addProductController {
	private JFrame jfr;
	private JPanel jpnView;
	private JTextField jtfProductName, jtfProductType, jtfColor, jtfSize, jtfPrice;
	private JButton btnSave, btnDelete, btnSubmit, btnCancel;
	private JLabel jlbMessage;
	private JTable table;
	ArrayList<String> inputList;
	
	private Product product = null;
	private ClassTableModel classTableModel = null;
    private ProductService productService = null;
    DefaultTableModel model;
    static int cn = 1;
    public addProductController(JFrame jfr, JTextField jtfProductName, JTextField jtfProductType, JTextField jtfColor, JTextField jtfSize, 
    		JTextField jtfPrice, JButton btnSave, JButton btnDelete, JButton btnSubmit, JButton btnCancel, JLabel jlbMessage, JPanel jpnView) {
    	this.jfr = jfr;
    	model = new DefaultTableModel();
    	model.addColumn("CN");
    	model.addColumn("ProductName");
    	model.addColumn("ProductType");
    	model.addColumn("Color");
    	model.addColumn("Size");
    	model.addColumn("Price");
    	
    	this.btnSubmit = btnSubmit;
        this.jtfProductName = jtfProductName;
        this.jtfProductType = jtfProductType;
        this.jtfColor = jtfColor;
        this.jtfSize = jtfSize;
        this.jtfPrice = jtfPrice;
        this.btnSave = btnSave;
        this.btnDelete = btnDelete;
        this.btnCancel = btnCancel;
        this.jlbMessage = jlbMessage;
        this.jpnView = jpnView;
        this.productService = new ProductServiceImpl();
        setDataToTable();
        setEvent();
    }
    	
//    public void setView(Product product) {
//        this.product = product;
//        // set data
//        jtfMaHocVien.setText("#" + product.getMa_hoc_vien());
//        jtfHoTen.setText(product.getHo_ten());
//        jdcNgaySinh.setDate(product.getNgay_sinh());
//        if (product.isGioi_tinh()) {
//            jtfGioiTinhNam.setSelected(true);
//        } else {
//            jtfGioiTinhNu.setSelected(true);
//        }
//        jtfSoDienThoai.setText(product.getSo_dien_thoai());
//        jtaDiaChi.setText(product.getDia_chi());
//        jcbKichHoat.setSelected(product.isTinh_trang());
//        // set event
//        setEvent();
//    }
    
    public void updateRowNumbers(DefaultTableModel model) {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i + 1, i, 0); 
        }
    }
    
    private void addDataToTable() {
    	int cn = this.cn;
        String ProductName = jtfProductName.getText();
        String ProductType = jtfProductType.getText();
        String Color = jtfColor.getText();
        String Size = jtfSize.getText();
        int Price = Integer.parseInt(jtfPrice.getText());
        // Thêm dữ liệu mới vào model của JTable
        this.model.addRow(new Object[]{cn, ProductName, ProductType, Color, Size, Price});
        this.cn++;
        this.jtfProductName.setText("");
        this.jtfProductType.setText("");
        this.jtfColor.setText("");
        this.jtfSize.setText("");
        this.jtfPrice.setText("");
    }
    
    public ArrayList<Product> getProductsFromTable(JTable table) {
        ArrayList<Product> productList = new ArrayList<>();

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        int colCount = model.getColumnCount();
        int count = 1;
        for (int i = 0; i < rowCount; i++) {
            String productID = "";
            int quantity = 0;
            String DiscountID = "NO";
            String productName = (String) model.getValueAt(i, 1); // Giả sử cột 1 là ProductName
            System.out.println(productName);
            String productType = (String) model.getValueAt(i, 2); // Giả sử cột 2 là ProductType
            String color = (String) model.getValueAt(i, 3); // Giả sử cột 3 là Color
            String size = (String) model.getValueAt(i, 4); // Giả sử cột 4 là Size
            int price = (int) model.getValueAt(i, 5); // Giả sử cột 5 là Price

            Product product = new Product(productID, productName, productType, color, price, quantity, size, DiscountID);
            productList.add(product);
        }

        return productList;
    }
    
    public void clearTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }
    
    public void deleteSelectedRow(JTable table, DefaultTableModel model) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
                model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public void setDataToTable() {
    	table = new JTable(model);
    	// design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(218, 245, 244));
        table.getTableHeader().setPreferredSize(new Dimension(50, 25));
        table.setFillsViewportHeight(true);
        table.setRowHeight(25);
        table.validate();
        table.repaint();
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setBackground(new Color(255, 255, 255));
        scroll.setPreferredSize(new Dimension(640, 270));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    	
        //Can chinh du lieu vao center cua cot
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
        	if(i==1) continue;
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        //Tuy chinh do rong cac cot
        table.getColumnModel().getColumn(0).setMaxWidth(50);
        table.getColumnModel().getColumn(0).setMinWidth(50);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        
//        table.getColumnModel().getColumn(1).setMaxWidth(80);
//        table.getColumnModel().getColumn(1).setMinWidth(80);
//        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        
  	    table.getColumnModel().getColumn(2).setMaxWidth(120);
        table.getColumnModel().getColumn(2).setMinWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(120);
        
        table.getColumnModel().getColumn(3).setMaxWidth(60);
        table.getColumnModel().getColumn(3).setMinWidth(60);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        
        table.getColumnModel().getColumn(4).setMaxWidth(60);
        table.getColumnModel().getColumn(4).setMinWidth(60);
        table.getColumnModel().getColumn(4).setPreferredWidth(60);
        
        table.getColumnModel().getColumn(5).setMaxWidth(80);
        table.getColumnModel().getColumn(5).setMinWidth(80);
        table.getColumnModel().getColumn(5).setPreferredWidth(80);
//        
//        table.getColumnModel().getColumn(6).setMaxWidth(120);
//        table.getColumnModel().getColumn(6).setMinWidth(120);
//        table.getColumnModel().getColumn(6).setPreferredWidth(120);
//        
//        table.getColumnModel().getColumn(7).setMaxWidth(90);
//        table.getColumnModel().getColumn(7).setMinWidth(90);
//        table.getColumnModel().getColumn(7).setPreferredWidth(90);
        
//        JScrollPane scroll = new JScrollPane();
//        scroll.getViewport().add(table);
//        scroll.setPreferredSize(new Dimension(1350, 400));
    }
    public void setEvent() {
        btnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                    if (!checkNotNull()) {
                    	if(isDouble(jtfPrice.getText())){
                    		
                    	}else {
                    		
                    	}
                    	fillColor();
                    } else {
                    	fillColor();
                    	if(!isDouble(jtfPrice.getText())){
                    		jlbMessage.setText("Please enter a real number in the Price field!");
                    	}else {
                    		jlbMessage.setText("(*): Require data");
                    		
                    		addDataToTable();
//                          product.setName(jtfProductType.getText().trim());
//                          product.setNgay_sinh(covertDateToDateSql(jdcNgaySinh.getDate()));
//                          product.setSo_dien_thoai(jtfSoDienThoai.getText());
//                          product.setDia_chi(jtaDiaChi.getText());
//                          product.setGioi_tinh(jtfGioiTinhNam.isSelected());
//                          product.setTinh_trang(jcbKichHoat.isSelected());
//                          if (showDialog()) {
//                              int lastId = hocVienService.createOrUpdate(product);
//                              if (lastId != 0) {
//                                  product.setMa_hoc_vien(lastId);
//                                  jtfMaHocVien.setText("#" + product.getMa_hoc_vien());
//                                  jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
//                              } else {
//                                  jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
//                              }
//                          }
//                      	inputList.add(jtfProductName.getText());
//                      	inputList.add(jtfProductName.getText());
//                      	inputList.add(jtfProductName.getText());
//                      	inputList.add(jtfProductName.getText());
//                      	inputList.add(jtfProductName.getText());
                      	// Xóa dữ liệu từ các trường nhập

                    	}
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
        btnSubmit.addMouseListener(new MouseAdapter() {
        	@Override
            public void mousePressed(MouseEvent e) {
                try {
                        if (showDialog()) {
                        	int max = productService.getMaxId()+1;
                        	
                        	ArrayList<Product> list = getProductsFromTable(table);
                        	for(Product product : list) {
                        		product.setID(generateProductName(max));
                        		max++;
                        		productService.Insert(product);
                        		clearTable(table);
                        	}
                        	
//                            int lastId = hocVienService.createOrUpdate(product);
//                            if (lastId != 0) {
//                                product.setMa_hoc_vien(lastId);
//                                jtfMaHocVien.setText("#" + product.getMa_hoc_vien());
//                                jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
//                            } else {
//                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
//                            }
                        	
                            
                        }
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
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
        });;
        btnDelete.addMouseListener(new MouseAdapter() {
        	@Override
            public void mousePressed(MouseEvent e) {
        		deleteSelectedRow(table, model);
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
        });;
		btnCancel.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        jfr.dispose();
	    }
	});
    }
    public String generateProductName(int productId) {
        String productIdStr = String.valueOf(productId);
        String paddedProductId = String.format("%04d", productId); 
        return "PR" + paddedProductId;
    }
    private boolean checkNotNull() {
        return (jtfProductName.getText() != null && !jtfProductName.getText().equalsIgnoreCase("")) &&
        		(jtfProductType.getText() != null && !jtfProductType.getText().equalsIgnoreCase("")) &&
        		(jtfColor.getText() != null && !jtfColor.getText().equalsIgnoreCase("")) &&
        		(jtfSize.getText() != null && !jtfSize.getText().equalsIgnoreCase("")) &&
        		(jtfPrice.getText() != null && !jtfPrice.getText().equalsIgnoreCase(""))
        		;
    }
    private void fillColor() {
    	if(jtfProductName.getText() != null && !jtfProductName.getText().equalsIgnoreCase("")) {
    		jtfProductName.setBorder(new LineBorder(new Color(171, 173, 179)));
    	}else {
    		jtfProductName.setBorder(new LineBorder(new Color(252, 3, 3)));
    	}
    	if(jtfProductType.getText() != null && !jtfProductType.getText().equalsIgnoreCase("")) {
    		jtfProductType.setBorder(new LineBorder(new Color(171, 173, 179)));
    	}else {
    		jtfProductType.setBorder(new LineBorder(new Color(252, 3, 3)));
    	}
    	if(jtfColor.getText() != null && !jtfColor.getText().equalsIgnoreCase("")) {
    		jtfColor.setBorder(new LineBorder(new Color(171, 173, 179)));
    	}else {
    		jtfColor.setBorder(new LineBorder(new Color(252, 3, 3)));
    	}
    	if(jtfSize.getText() != null && !jtfSize.getText().equalsIgnoreCase("")) {
    		jtfSize.setBorder(new LineBorder(new Color(171, 173, 179)));
    	}else {
    		jtfSize.setBorder(new LineBorder(new Color(252, 3, 3)));
    	}
    	if(jtfPrice.getText() != null && !jtfPrice.getText().equalsIgnoreCase("") && isDouble(jtfPrice.getText())) {
    		jtfPrice.setBorder(new LineBorder(new Color(171, 173, 179)));
    	}else {
    		jtfPrice.setBorder(new LineBorder(new Color(252, 3, 3)));
    	}
    }
    private boolean isDouble(String input) {
        try {
            double value = Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
    
    public java.sql.Date covertDateToDateSql(Date d) {
        return new java.sql.Date(d.getTime());
    }
    
}
