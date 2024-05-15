package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;

public class BillPrintJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillPrintJFrame frame = new BillPrintJFrame();
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
	public BillPrintJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 615);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SHOP MANAGEMENT");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1.setBounds(90, 11, 165, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address:");
		lblNewLabel_2.setBounds(15, 38, 53, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("97 Nguyen Luong Bang, Lien Chieu, Da Nang");
		lblNewLabel_3.setBounds(73, 38, 260, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SALES RECEIPT");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_4.setBounds(95, 88, 180, 31);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Phone:");
		lblNewLabel.setBounds(110, 63, 48, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("0868674213");
		lblNewLabel_5.setBounds(158, 63, 74, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Receipt Code:");
		lblNewLabel_6.setBounds(100, 120, 85, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Ngay 20 Thang 10 Nam 2024");
		lblNewLabel_7.setBounds(80, 140, 165, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Customer:");
		lblNewLabel_8.setBounds(10, 165, 65, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Nguyen Khanh Huy");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_9.setBounds(78, 162, 150, 20);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Phone:");
		lblNewLabel_10.setBounds(10, 187, 48, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Address:");
		lblNewLabel_11.setBounds(10, 210, 55, 14);
		contentPane.add(lblNewLabel_11);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 245, 305, 52);
		contentPane.add(panel);
		
		JLabel lblNewLabel_12 = new JLabel("IV00001");
		lblNewLabel_12.setBounds(185, 120, 90, 14);
		contentPane.add(lblNewLabel_12);
		
		JTextArea txtrPleaseKindlyDoublecheck = new JTextArea();
		txtrPleaseKindlyDoublecheck.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtrPleaseKindlyDoublecheck.setText("PLEASE KINDLY DOUBLE-CHECK YOUR INVOICE\r\n      BEFORE PROCEEDING WITH PAYMENT!\r\n          THANKS FOR YOUR PATRONAGE\r\n             SEE YOU AGAIN NEXT TIME.");
		txtrPleaseKindlyDoublecheck.setBounds(34, 478, 300, 80);
		contentPane.add(txtrPleaseKindlyDoublecheck);
		
		JLabel lblNewLabel_13 = new JLabel("0325536633");
		lblNewLabel_13.setBounds(61, 187, 80, 14);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Da Nang");
		lblNewLabel_14.setBounds(72, 210, 150, 14);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("2700000");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_15.setBounds(260, 308, 70, 18);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Product cost:");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_16.setBounds(138, 308, 100, 18);
		contentPane.add(lblNewLabel_16);
	}
}
