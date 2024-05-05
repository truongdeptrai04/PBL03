package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1214, 839);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 248));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(209, 209, 209), 10, true));
		panel.setBackground(new Color(216, 216, 216));
		panel.setBounds(100, 321, 1000, 380);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Product");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBackground(new Color(254, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setIcon(new ImageIcon(Home.class.getResource("/image/ProductIcon2.png")));
		btnNewButton.setBounds(50, 70, 400, 60);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Discount");
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setBackground(new Color(254, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setIcon(new ImageIcon(Home.class.getResource("/image/DiscountIcon.png")));
		btnNewButton_1.setBounds(50, 160, 400, 60);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Acount\r\n");
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setBackground(new Color(254, 255, 255));
		btnNewButton_2.setIcon(new ImageIcon(Home.class.getResource("/image/AccountIcon.png")));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_2.setBounds(50, 250, 400, 60);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Invoice");
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setBackground(new Color(254, 255, 255));
		btnNewButton_3.setIcon(new ImageIcon(Home.class.getResource("/image/InvoiceIcon.png")));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_3.setBounds(550, 70, 400, 60);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_1_1 = new JButton("Customer");
		btnNewButton_1_1.setFocusPainted(false);
		btnNewButton_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1.setBackground(new Color(254, 255, 255));
		btnNewButton_1_1.setIcon(new ImageIcon(Home.class.getResource("/image/CustomerIcon.png")));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1_1.setBounds(550, 160, 400, 60);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Statistics");
		btnNewButton_2_1.setFocusPainted(false);
		btnNewButton_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2_1.setBackground(new Color(254, 255, 255));
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_2_1.setIcon(new ImageIcon(Home.class.getResource("/image/FBIcon.png")));
		btnNewButton_2_1.setBounds(550, 250, 400, 60);
		panel.add(btnNewButton_2_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/image/managerIcon5.png")));
		lblNewLabel.setBounds(100, 208, 80, 87);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MANAGER - 01");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(180, 208, 200, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("SHOWROOM 01 | DA NANG");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(180, 239, 245, 40);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("STORE MANAGEMENT | SHOWROOM 01 DA NANG");
		lblNewLabel_2.setForeground(new Color(132, 202, 232));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel_2.setBounds(150, 57, 900, 59);
		contentPane.add(lblNewLabel_2);
	}
}
