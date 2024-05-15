package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
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

import Bean.OptionBean;
import Controller.ScreenSwitchingController;

import java.awt.Dimension;
import javax.swing.border.MatteBorder;
import javax.swing.DebugGraphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.Cursor;

public class MainJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panel, pnOption, pnView;
	private JLabel lbWelcome, lbShowroom;
	private JButton btnExit, btnProduct, btnInvoice, btnCustomer, btnAccount, btnStatistics;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJFrame frame = new MainJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainJFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1214, 839);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(71, 150, 189));
		panel.setBounds(0, 0, 1200, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbWelcome = new JLabel("Welcome Admin");
		lbWelcome.setForeground(new Color(255, 255, 255));
		lbWelcome.setIcon(new ImageIcon(MainJFrame.class.getResource("/image/managerIcon6.png")));
		lbWelcome.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lbWelcome.setBounds(50, 11, 259, 58);
		panel.add(lbWelcome);
		
		btnExit = new JButton("");
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
		btnExit.setIcon(new ImageIcon(MainJFrame.class.getResource("/image/exitIcon1.png")));
		btnExit.setBounds(1121, 13, 54, 54);
		panel.add(btnExit);
		
		pnOption = new JPanel();
		pnOption.setBackground(new Color(255, 255, 254));
		pnOption.setBounds(0, 80, 215, 724);
		contentPane.add(pnOption);
		pnOption.setLayout(null);
		
		btnProduct = new JButton("Product   ");
		btnProduct.setFocusPainted(false);
		btnProduct.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnProduct.setBackground(new Color(255, 255, 254));
		btnProduct.setIcon(new ImageIcon(MainJFrame.class.getResource("/image/ProductIcon2.png")));
		btnProduct.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnProduct.setBounds(0, 0, 215, 75);
		pnOption.add(btnProduct);
		
		btnInvoice = new JButton("Invoice    ");
		btnInvoice.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnInvoice.setFocusPainted(false);
		btnInvoice.setBackground(new Color(255, 255, 254));
		btnInvoice.setIcon(new ImageIcon(MainJFrame.class.getResource("/image/InvoiceIcon.png")));
		btnInvoice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInvoice.setBounds(0, 75, 215, 75);
		pnOption.add(btnInvoice);
		
		btnCustomer = new JButton("Customer ");
		btnCustomer.setBackground(new Color(255, 255, 254));
		btnCustomer.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnCustomer.setFocusPainted(false);
		btnCustomer.setIcon(new ImageIcon(MainJFrame.class.getResource("/image/CustomerIcon.png")));
		btnCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCustomer.setBounds(0, 225, 215, 75);
		pnOption.add(btnCustomer);
		
		btnAccount = new JButton("Account   ");
		btnAccount.setBackground(new Color(255, 255, 254));
		btnAccount.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnAccount.setFocusPainted(false);
		btnAccount.setIcon(new ImageIcon(MainJFrame.class.getResource("/image/AccountIcon.png")));
		btnAccount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAccount.setBounds(0, 300, 215, 75);
		pnOption.add(btnAccount);
		
		btnStatistics = new JButton("Statistics  ");
		btnStatistics.setBackground(new Color(255, 255, 254));
		btnStatistics.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnStatistics.setFocusPainted(false);
		btnStatistics.setIcon(new ImageIcon(MainJFrame.class.getResource("/image/FBIcon.png")));
		btnStatistics.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStatistics.setBounds(0, 375, 215, 75);
		pnOption.add(btnStatistics);
		
		JButton btnSale = new JButton("Sale         ");
		btnSale.setIcon(new ImageIcon(MainJFrame.class.getResource("/image/sale3.png")));
		btnSale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSale.setFocusPainted(false);
		btnSale.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnSale.setBackground(new Color(255, 255, 254));
		btnSale.setBounds(0, 150, 215, 75);
		pnOption.add(btnSale);
		
		lbShowroom = new JLabel("SHOWROOM - 01");
		lbShowroom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbShowroom.setHorizontalAlignment(SwingConstants.CENTER);
		lbShowroom.setBounds(0, 679, 215, 35);
		pnOption.add(lbShowroom);
		
		pnView = new JPanel();
		pnView.setBackground(new Color(255, 255, 254));
		pnView.setBounds(218, 80, 982, 724);
		contentPane.add(pnView);
		pnView.setLayout(null);
		
		ScreenSwitchingController controller = new ScreenSwitchingController(pnView);
		controller.setView(btnProduct);
		
		ArrayList<OptionBean> listItem = new ArrayList();
		listItem.add(new OptionBean("Product", btnProduct));
		listItem.add(new OptionBean("Invoice", btnInvoice));
		listItem.add(new OptionBean("Sale", btnSale));
		listItem.add(new OptionBean("Customer", btnCustomer));
		listItem.add(new OptionBean("Account", btnAccount));
		listItem.add(new OptionBean("Statistic", btnStatistics));

		controller.setEvent(listItem);
		
	}
}
//test001
