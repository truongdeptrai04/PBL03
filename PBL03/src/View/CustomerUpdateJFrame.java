package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.CustomerUpdateController;
import Model.Customer;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class CustomerUpdateJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfCusAddress;
	private JTextField jtfCusName;
	private JTextField jtfCusRank;
	private JTextField jtfCusPhoneNumber;
	private JTextField jtfCusTurnover;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer cus = new Customer();
					CustomerUpdateJFrame frame = new CustomerUpdateJFrame(cus);
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
	public CustomerUpdateJFrame(Customer customer) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 917, 657);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(243, 249, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(255, 255, 255));
		panel1.setBounds(20, 72, 859, 201);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Customer ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 15, 100, 20);
		panel1.add(lblNewLabel_1);
		
		jtfCusAddress = new JTextField();
		jtfCusAddress.setColumns(10);
		jtfCusAddress.setBounds(80, 131, 284, 40);
		panel1.add(jtfCusAddress);
		
		jtfCusName = new JTextField();
		jtfCusName.setColumns(10);
		jtfCusName.setBounds(80, 63, 250, 40);
		panel1.add(jtfCusName);
		
		jtfCusRank = new JTextField();
		jtfCusRank.setColumns(10);
		jtfCusRank.setBounds(458, 131, 96, 40);
		panel1.add(jtfCusRank);
		
		jtfCusPhoneNumber = new JTextField();
		jtfCusPhoneNumber.setColumns(10);
		jtfCusPhoneNumber.setBounds(551, 63, 248, 40);
		panel1.add(jtfCusPhoneNumber);
		
		jtfCusTurnover = new JTextField();
		jtfCusTurnover.setColumns(10);
		jtfCusTurnover.setBounds(640, 131, 157, 40);
		panel1.add(jtfCusTurnover);
		
		JLabel jlbCusID = new JLabel("CT0001");
		jlbCusID.setFont(new Font("Tahoma", Font.ITALIC, 14));
		jlbCusID.setEnabled(true);
		jlbCusID.setBounds(110, 15, 110, 20);
		panel1.add(jlbCusID);
		
		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 73, 49, 20);
		panel1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 141, 60, 20);
		panel1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("PhoneNumber:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(454, 72, 100, 20);
		panel1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Rank:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(407, 141, 41, 20);
		panel1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Turnover:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(570, 141, 60, 20);
		panel1.add(lblNewLabel_7);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setBackground(new Color(255, 255, 255));
		btnSave.setFocusPainted(false);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSave.setBounds(740, 20, 120, 40);
		contentPane.add(btnSave);
		
		JLabel lblNewLabel = new JLabel("CUSTOMER INFORMATION");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel.setBounds(30, 21, 250, 30);
		contentPane.add(lblNewLabel);
		
		JPanel jpnView = new JPanel();
		jpnView.setBackground(new Color(255, 255, 255));
		jpnView.setBounds(20, 285, 859, 296);
		contentPane.add(jpnView);
		
		CustomerUpdateController controller = new CustomerUpdateController(this, btnSave,  jtfCusName, jtfCusPhoneNumber, jtfCusAddress, jtfCusRank, jtfCusTurnover, jpnView, jlbCusID);
		controller.setView(customer);
	}
}
