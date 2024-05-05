package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import Database.JDBC;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
	private JPanel contentPane, topPanel;
	private JLabel loginLB, imageLB, emailID, password;
	private JButton loginBT;
	private JTextField accountField;
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
		
		loginLB = new JLabel("L O G I N");
		loginLB.setHorizontalAlignment(SwingConstants.CENTER);
		loginLB.setBackground(new Color(192, 192, 192));
		loginLB.setFont(new Font("Tahoma", Font.PLAIN, 32));
		loginLB.setBounds(110, 30, 200, 50);
		panel.add(loginLB);
		
		accountField = new JTextField();
		accountField.setText("");
		accountField.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		accountField.setToolTipText("");
		accountField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		accountField.setBounds(60, 130, 300, 50);
		panel.add(accountField);
		accountField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		passwordField.setBounds(60, 228, 300, 50);
		panel.add(passwordField);
		
		loginBT.setForeground(new Color(255, 255, 255));
		loginBT.setBackground(new Color(71, 150, 189));
		loginBT.setFont(new Font("Tahoma", Font.PLAIN, 27));
		loginBT.setBounds(60, 350, 300, 50);
		panel.add(loginBT);
		
		
		imageLB = new JLabel("");
		imageLB.setBorder(new LineBorder(new Color(0, 128, 192), 4));
		imageLB.setIcon(new ImageIcon(loginView.class.getResource("/image/loginImage2.jpg")));
		imageLB.setPreferredSize(new Dimension(loginImage.getIconWidth(), loginImage.getIconHeight()));
		imageLB.setBounds(430, 100, 290, 300);
		panel.add(imageLB);
		
		emailID = new JLabel("Email ID:");
		emailID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		emailID.setBounds(60, 91, 163, 28);
		panel.add(emailID);
		
		password = new JLabel("Password:");
		password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		password.setBounds(60, 191, 163, 28);
		panel.add(password);
		
		topPanel = new JPanel();
		topPanel.setBackground(new Color(71, 150, 189));
		topPanel.setBounds(0, 0, 1200, 80);
		contentPane.add(topPanel);
		
		loginBT = new JButton("LOGIN");
		loginBT.setFocusPainted(false);
		loginBT.addActionListener(new ActionListener() {
			
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
					ps.setString(1,accountField.getText());
					ps.setString(2,passwordField.getText());
					// ExcuteQuerry trả về resultset khi thực thi câu lệnh
					rs = ps.executeQuery();
					
					if(accountField.getText().equals("") || passwordField.getText().equals("")){
						JOptionPane.showMessageDialog(loginBT, "Chưa nhập Username và Password");						
					} 
					else if (rs.next())// Neu co du lieu
					{
						AccountManagement ac = new AccountManagement();
						ac.setVisible(true);
						dispose();
						JOptionPane.showMessageDialog(loginBT,"Đăng nhập thành công");
					} else {
						JOptionPane.showMessageDialog(loginBT,"Đăng nhập thất bại");
					}

					 
				} catch (Exception e1) {
					
				}
			}
		});
	}
}
