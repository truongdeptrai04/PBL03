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

public class AccountManagement extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
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
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(22, 106, 168, 505);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setIcon(new ImageIcon(AccountManagement.class.getResource("/image/Home.png")));
		btnNewButton.setBounds(23, 11, 135, 43);
		panel.add(btnNewButton);
		
		JButton btnProducts = new JButton("Products");
		btnProducts.setHorizontalAlignment(SwingConstants.LEFT);
		btnProducts.setIcon(new ImageIcon(AccountManagement.class.getResource("/image/Bag.png")));
		btnProducts.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProducts.setBackground(Color.WHITE);
		btnProducts.setBounds(23, 65, 135, 43);
		panel.add(btnProducts);
		
		JButton btnInvoice = new JButton("Invoice");
		btnInvoice.setIcon(new ImageIcon(AccountManagement.class.getResource("/image/File_dock_search.png")));
		btnInvoice.setHorizontalAlignment(SwingConstants.LEFT);
		btnInvoice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInvoice.setBackground(Color.WHITE);
		btnInvoice.setBounds(23, 119, 135, 43);
		panel.add(btnInvoice);
		
		JButton btnDiscount = new JButton("Discount");
		btnDiscount.setIcon(new ImageIcon(AccountManagement.class.getResource("/image/gift_alt.png")));
		btnDiscount.setHorizontalAlignment(SwingConstants.LEFT);
		btnDiscount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDiscount.setBackground(Color.WHITE);
		btnDiscount.setBounds(23, 173, 135, 43);
		panel.add(btnDiscount);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(71, 150, 189));
		panel_1.setBounds(22, 21, 1166, 74);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(AccountManagement.class.getResource("/image/logo1.jpg")));
		lblNewLabel_2.setBounds(0, 0, 122, 74);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Online Shop Management");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(827, 8, 528, 52);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(200, 175, 988, 437);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		table = new JTable();
		table.setBackground(new Color(245, 255, 250));
		table.setBounds(10, 11, 968, 426);
		panel_2.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("Home");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		lblNewLabel_1.setBounds(273, 106, 461, 58);
		contentPane.add(lblNewLabel_1);
	}
}
