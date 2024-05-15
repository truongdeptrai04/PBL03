package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

import Controller.ProductManagerController;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;


public class ProductJPanel extends JPanel {
	private JPanel jpnView;
	private JButton btnAdd;
	private static final long serialVersionUID = 1L;
	private JTextField jtfSearch;
	private JLabel lblNewLabel_1;

	public ProductJPanel() {
		setBackground(new Color(243, 249, 251));
		setLayout(null);
		
		jtfSearch = new JTextField();
		jtfSearch.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		jtfSearch.setBackground(new Color(243, 249, 251));
		jtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jtfSearch.setBounds(130, 45, 209, 36);
		add(jtfSearch);
		jtfSearch.setColumns(10);
		
		btnAdd = new JButton("ADD");
		btnAdd.setBorder(new LineBorder(new Color(71, 150, 189), 1, true));
		btnAdd.setFocusPainted(false);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setForeground(new Color(0, 0, 0));
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.setBounds(764, 43, 128, 40);
		add(btnAdd);
		
		jpnView = new JPanel();
		jpnView.setBackground(new Color(255, 255, 254));
		jpnView.setBounds(41, 125, 900, 530);
		add(jpnView);
		
		JLabel lblNewLabel = new JLabel("Search:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(34, 40, 90, 46);
		add(lblNewLabel);
		
		ProductManagerController controller = new ProductManagerController(jpnView, btnAdd, jtfSearch);
		
		lblNewLabel_1 = new JLabel("(*): Product name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(349, 53, 130, 20);
		add(lblNewLabel_1);
		controller.setDataToTable();
	}
}
