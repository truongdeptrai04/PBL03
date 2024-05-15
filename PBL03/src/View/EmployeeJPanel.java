package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import Controller.EmployeeController;
import javax.swing.border.LineBorder;

public class EmployeeJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfSearch;

	/**
	 * Create the panel.
	 */
	public EmployeeJPanel() {
		setBackground(new Color(243, 249, 251));
		setBounds(0, 0, 982, 724);
		setLayout(null);
		
		JPanel jpnView = new JPanel();
		jpnView.setBackground(new Color(255, 255, 255));
		jpnView.setBounds(15, 130, 950, 500);
		add(jpnView);
		
		jtfSearch = new JTextField();
		jtfSearch.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		jtfSearch.setBackground(new Color(243, 249, 251));
		jtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfSearch.setColumns(10);
		jtfSearch.setBounds(175, 48, 209, 36);
		add(jtfSearch);
		
		JLabel lblNewLabel = new JLabel("Employee:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(65, 48, 120, 36);
		add(lblNewLabel);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBorder(new LineBorder(new Color(71, 150, 189), 1, true));
		btnAdd.setFocusPainted(false);
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(656, 48, 107, 36);
		add(btnAdd);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBorder(new LineBorder(new Color(71, 150, 189), 1, true));
		btnDelete.setFocusPainted(false);
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setForeground(new Color(255, 0, 0));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBounds(787, 48, 107, 36);
		add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("(*): Employee name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(394, 54, 150, 20);
		add(lblNewLabel_1);
		
		EmployeeController controller = new EmployeeController(jpnView, jtfSearch, btnAdd, btnDelete);
		controller.setDataToTable();
	}
}
