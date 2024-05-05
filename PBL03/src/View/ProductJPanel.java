package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

import Controller.ProductManagerController;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class ProductJPanel extends JPanel {
	private JPanel jpnView;
	private JButton btnAdd;
	private static final long serialVersionUID = 1L;
	private JTextField jtfSearch;

	public ProductJPanel() {
		setBackground(new Color(243, 249, 251));
		setLayout(null);
		
		jtfSearch = new JTextField();
		jtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jtfSearch.setBounds(121, 40, 252, 46);
		add(jtfSearch);
		jtfSearch.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.setFocusPainted(false);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(71, 150, 189));
		btnAdd.setBounds(764, 40, 128, 46);
		add(btnAdd);
		
		jpnView = new JPanel();
		jpnView.setBackground(new Color(255, 255, 254));
		jpnView.setBounds(41, 125, 900, 530);
		add(jpnView);
		
		JLabel lblNewLabel = new JLabel("Search:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(24, 40, 90, 46);
		add(lblNewLabel);
		
		ProductManagerController controller = new ProductManagerController(jpnView, btnAdd, jtfSearch);
		controller.setDataToTable();
	}
}
