package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import DAO.JDBC;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class loginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	ImageIcon loginImage = new ImageIcon(loginView.class.getResource("/image/loginImage.jpg"));
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginView frame = new loginView();
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
	public loginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1214, 839);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(243, 249, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(192, 192, 192), 5));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(200, 190, 800, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("L O G I N");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(110, 42, 200, 50);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textField.setBounds(60, 130, 300, 50);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		passwordField.setBounds(60, 215, 300, 50);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					//TAO KET NOI
					Connection connection = JDBC.getConnection();
					// Buoc2 :Tao doi tuong Statement
					Statement st = connection.createStatement();
					ResultSet rs;
					//CAU TRUY VAN SQL
					String sql = "select * from account where userName=? and passWord=?";
					// Cho phép chỉ định tham số đầu vào
					PreparedStatement ps = connection.prepareCall(sql);
					ps.setString(1,textField.getText());
					ps.setString(2,passwordField.getText());
					// ExcuteQuerry trả về resultset khi thực thi câu lệnh
					rs = ps.executeQuery();
					
					if(textField.getText().equals("") || passwordField.getText().equals("")){
						JOptionPane.showMessageDialog(btnNewButton, "Chưa nhập Username và Password");						
					} 
					else if (rs.next())// Neu co du lieu
					{
						MainJFrame ac = new MainJFrame();
						ac.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(btnNewButton,"Đăng nhập thất bại");
					}

					 
				} catch (Exception e1) {
					
				}
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(71, 150, 189));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnNewButton.setBounds(60, 320, 300, 50);
		panel.add(btnNewButton);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(loginView.class.getResource("/image/loginImage.jpg")));
		lblNewLabel_1.setPreferredSize(new Dimension(loginImage.getIconWidth(), loginImage.getIconHeight()));
		lblNewLabel_1.setBounds(430, 100, 300, 300);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(71, 150, 189));
		panel_1.setBounds(0, 0, 1200, 80);
		contentPane.add(panel_1);
		
		// content
	}
}

