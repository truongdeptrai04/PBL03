package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class loginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtZxzxz;
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
		lblNewLabel.setBounds(110, 35, 200, 50);
		panel.add(lblNewLabel);
		
		txtZxzxz = new JTextField();
		txtZxzxz.setText("Tài khoản");
		txtZxzxz.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txtZxzxz.setToolTipText("");
		txtZxzxz.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtZxzxz.setBounds(60, 130, 300, 50);
		panel.add(txtZxzxz);
		txtZxzxz.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		passwordField.setBounds(60, 215, 300, 50);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(71, 150, 189));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnNewButton.setBounds(60, 320, 300, 50);
		panel.add(btnNewButton);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 128, 192), 4));
		lblNewLabel_1.setIcon(new ImageIcon(loginView.class.getResource("/image/loginImage2.jpg")));
		lblNewLabel_1.setPreferredSize(new Dimension(loginImage.getIconWidth(), loginImage.getIconHeight()));
		lblNewLabel_1.setBounds(430, 100, 290, 300);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(71, 150, 189));
		panel_1.setBounds(0, 0, 1200, 80);
		contentPane.add(panel_1);
	}
}
