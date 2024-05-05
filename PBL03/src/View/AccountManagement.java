package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;
import javax.swing.DebugGraphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountManagement extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	//test 1
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountManagement frame = new AccountManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AccountManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1214, 839);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(71, 150, 189));
		panel.setBounds(0, 0, 1200, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbWelcome = new JLabel("Welcome Admin");
		lbWelcome.setForeground(new Color(255, 255, 255));
		lbWelcome.setIcon(new ImageIcon(AccountManagement.class.getResource("/image/managerIcon6.png")));
		lbWelcome.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lbWelcome.setBounds(862, 11, 259, 58);
		panel.add(lbWelcome);
		
		JButton btnExit = new JButton("");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginView ac = new loginView();
				ac.setVisible(true);
				dispose();
			}
		});
		btnExit.setFocusPainted(false);
		btnExit.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnExit.setBackground(new Color(71, 150, 189));
		btnExit.setIcon(new ImageIcon(AccountManagement.class.getResource("/image/exitIcon1.png")));
		btnExit.setBounds(1121, 13, 54, 54);
		panel.add(btnExit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 254));
		panel_1.setBounds(0, 80, 215, 724);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnProductManager = new JButton("Product   ");
		btnProductManager.setFocusPainted(false);
		btnProductManager.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnProductManager.setBackground(new Color(255, 255, 254));
		btnProductManager.setIcon(new ImageIcon(AccountManagement.class.getResource("/image/ProductIcon2.png")));
		btnProductManager.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnProductManager.setBounds(0, 0, 215, 75);
		panel_1.add(btnProductManager);
		
		JButton btnInvoice = new JButton("Invoice    ");
		btnInvoice.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnInvoice.setFocusPainted(false);
		btnInvoice.setBackground(new Color(255, 255, 254));
		btnInvoice.setIcon(new ImageIcon(AccountManagement.class.getResource("/image/InvoiceIcon.png")));
		btnInvoice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInvoice.setBounds(0, 75, 215, 75);
		panel_1.add(btnInvoice);
		
		JButton btnDiscount = new JButton("Discount  ");
		btnDiscount.setBackground(new Color(255, 255, 254));
		btnDiscount.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnDiscount.setFocusPainted(false);
		btnDiscount.setIcon(new ImageIcon(AccountManagement.class.getResource("/image/DiscountIcon.png")));
		btnDiscount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDiscount.setBounds(0, 150, 215, 75);
		panel_1.add(btnDiscount);
		
		JButton btnCustomer = new JButton("Customer ");
		btnCustomer.setBackground(new Color(255, 255, 254));
		btnCustomer.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnCustomer.setFocusPainted(false);
		btnCustomer.setIcon(new ImageIcon(AccountManagement.class.getResource("/image/CustomerIcon.png")));
		btnCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCustomer.setBounds(0, 225, 215, 75);
		panel_1.add(btnCustomer);
		
		JButton btnAccount = new JButton("Account   ");
		btnAccount.setBackground(new Color(255, 255, 254));
		btnAccount.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnAccount.setFocusPainted(false);
		btnAccount.setIcon(new ImageIcon(AccountManagement.class.getResource("/image/AccountIcon.png")));
		btnAccount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAccount.setBounds(0, 300, 215, 75);
		panel_1.add(btnAccount);
		
		JButton btnStatistics = new JButton("Statistics  ");
		btnStatistics.setBackground(new Color(255, 255, 254));
		btnStatistics.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnStatistics.setFocusPainted(false);
		btnStatistics.setIcon(new ImageIcon(AccountManagement.class.getResource("/image/FBIcon.png")));
		btnStatistics.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStatistics.setBounds(0, 375, 215, 75);
		panel_1.add(btnStatistics);
		
		JLabel lbShowroom = new JLabel("SHOWROOM - 01");
		lbShowroom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbShowroom.setHorizontalAlignment(SwingConstants.CENTER);
		lbShowroom.setBounds(0, 679, 215, 35);
		panel_1.add(lbShowroom);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(243, 249, 251));
		panel_2.setBounds(218, 80, 982, 724);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setAutoscrolls(true);
		scrollPane_1.setBounds(40, 100, 902, 550);
		panel_2.add(scrollPane_1);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setForeground(new Color(0, 0, 0));
		table.setShowVerticalLines(false);
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Color", "Size", "Type", "Price", "Brand"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(54);
		table.getColumnModel().getColumn(1).setPreferredWidth(181);
		table.getColumnModel().getColumn(3).setPreferredWidth(43);
		table.setRowHeight(30);
		scrollPane_1.setViewportView(table);
		
		JButton btnAdd = new JButton("");
		btnAdd.setFocusPainted(false);
		btnAdd.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnAdd.setBackground(new Color(243, 249, 251));
		btnAdd.setIcon(new ImageIcon(AccountManagement.class.getResource("/image/addIcon1.png")));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAdd.setBounds(40, 32, 40, 40);
		panel_2.add(btnAdd);
		
		JLabel lbAdd = new JLabel("Add");
		lbAdd.setFont(new Font("Dialog", Font.PLAIN, 24));
		lbAdd.setBounds(92, 32, 56, 40);
		panel_2.add(lbAdd);
	}
}
//compile test
