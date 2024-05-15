package View;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Controller.SaleController;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SaleJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfSearch;
	private JTextField jtfQuantity;
	private JTextField jtfPhoneNumber;
	private JTextField jtfName;
	private JTextField jtfAddress;
	private JTextField jtfDiscount;

	/**
	 * Create the panel.
	 */
	public SaleJPanel() {
		setBounds(0, 0, 982, 724);
		setBackground(new Color(243, 249, 251));
		setLayout(null);
		
		JPanel jpnView1 = new JPanel();
		jpnView1.setBackground(new Color(255, 255, 255));
		jpnView1.setBounds(10, 75, 962, 234);
		add(jpnView1);
		
		JPanel jpnView2 = new JPanel();
		jpnView2.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		jpnView2.setBackground(new Color(255, 255, 255));
		jpnView2.setBounds(10, 370, 741, 324);
		add(jpnView2);
		
		jtfSearch = new JTextField();
		jtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfSearch.setColumns(10);
		jtfSearch.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		jtfSearch.setBackground(new Color(243, 249, 251));
		jtfSearch.setBounds(114, 33, 209, 28);
		add(jtfSearch);
		
		JLabel lblProductName = new JLabel("(*): Product name");
		lblProductName.setForeground(Color.RED);
		lblProductName.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblProductName.setBounds(333, 33, 120, 20);
		add(lblProductName);
		
		JLabel jlbSearch = new JLabel("Search:");
		jlbSearch.setFont(new Font("Tahoma", Font.PLAIN, 21));
		jlbSearch.setBounds(29, 28, 95, 36);
		add(jlbSearch);
		
		jtfQuantity = new JTextField();
		jtfQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfQuantity.setColumns(10);
		jtfQuantity.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		jtfQuantity.setBackground(new Color(243, 249, 251));
		jtfQuantity.setBounds(102, 328, 80, 28);
		add(jtfQuantity);
		
		JLabel jlbSearch_1 = new JLabel("Quantity:");
		jlbSearch_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlbSearch_1.setBounds(29, 323, 95, 36);
		add(jlbSearch_1);
		
		jtfPhoneNumber = new JTextField();
		jtfPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfPhoneNumber.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		jtfPhoneNumber.setBounds(778, 341, 178, 36);
		add(jtfPhoneNumber);
		jtfPhoneNumber.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Phone Number:");
		lblNewLabel.setBounds(778, 320, 100, 20);
		add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(778, 380, 87, 20);
		add(lblName);
		
		jtfName = new JTextField();
		jtfName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfName.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		jtfName.setColumns(10);
		jtfName.setBounds(778, 401, 178, 36);
		add(jtfName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(778, 440, 87, 20);
		add(lblAddress);
		
		jtfAddress = new JTextField();
		jtfAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfAddress.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		jtfAddress.setColumns(10);
		jtfAddress.setBounds(778, 461, 178, 36);
		add(jtfAddress);
		
		JLabel lblDiscountPercent = new JLabel("Discount Percent");
		lblDiscountPercent.setBounds(778, 498, 100, 20);
		add(lblDiscountPercent);
		
		JLabel lblPurchasingMethod = new JLabel("Purchasing Method");
		lblPurchasingMethod.setBounds(778, 561, 120, 20);
		add(lblPurchasingMethod);
		
		JLabel lblNewLabel_1 = new JLabel("Total:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(778, 624, 60, 20);
		add(lblNewLabel_1);
		
		JLabel jlbTotal = new JLabel("0 VND");
		jlbTotal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		jlbTotal.setBounds(825, 624, 120, 20);
		add(jlbTotal);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFocusPainted(false);
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBorder(new LineBorder(new Color(71, 150, 189)));
		btnDelete.setBounds(633, 329, 100, 30);
		add(btnDelete);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFocusPainted(false);
		btnSubmit.setBackground(new Color(255, 255, 255));
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmit.setBorder(new LineBorder(new Color(71, 150, 189), 1, true));
		btnSubmit.setBounds(809, 664, 100, 30);
		add(btnSubmit);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFocusPainted(false);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBorder(new LineBorder(new Color(71, 150, 189)));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(192, 329, 100, 30);
		add(btnAdd);
		
		JComboBox cbbDiscount = new JComboBox();
		cbbDiscount.setBackground(new Color(255, 255, 254));
		cbbDiscount.setBounds(778, 524, 100, 28);
		add(cbbDiscount);
		
		JComboBox cbbPuschasingMethod = new JComboBox();
		cbbPuschasingMethod.setModel(new DefaultComboBoxModel(new String[] {"Offline", "Online"}));
		cbbPuschasingMethod.setBounds(778, 586, 80, 28);
		add(cbbPuschasingMethod);
		
		jtfDiscount = new JTextField();
		jtfDiscount.setText("0");
		jtfDiscount.setBounds(890, 524, 60, 28);
		add(jtfDiscount);
		jtfDiscount.setColumns(10);
		
		SaleController controller = new SaleController(jtfSearch, jtfQuantity, jtfPhoneNumber, jtfName, jtfAddress, cbbDiscount, cbbPuschasingMethod, jlbTotal, jpnView1, jpnView2, btnAdd, btnDelete, btnSubmit, jtfDiscount);
		controller.setDataToTable();
	}
}
