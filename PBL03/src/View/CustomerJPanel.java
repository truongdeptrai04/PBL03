package View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Controller.CustomerController;

import java.awt.Color;
import java.awt.Font;

public class CustomerJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfSearch;
	/**
	 * Create the panel.
	 */
	public CustomerJPanel() {
		this.setBounds(0, 0, 982, 724);	
		setBackground(new Color(243, 249, 251));
		setLayout(null);
		
		JLabel jlbSearch = new JLabel("Search:");
		jlbSearch.setFont(new Font("Tahoma", Font.PLAIN, 21));
		jlbSearch.setBounds(40, 41, 95, 36);
		add(jlbSearch);
		
		jtfSearch = new JTextField();
		jtfSearch.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		jtfSearch.setBackground(new Color(243, 249, 251));
		jtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfSearch.setBounds(125, 41, 209, 36);
		add(jtfSearch);
		jtfSearch.setColumns(10);
		
		JLabel jlbNote = new JLabel("(*): Customer name");
		jlbNote.setFont(new Font("Tahoma", Font.ITALIC, 13));
		jlbNote.setForeground(new Color(255, 0, 0));
		jlbNote.setBounds(344, 49, 150, 20);
		add(jlbNote);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFocusPainted(false);
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(780, 43, 128, 40);
		add(btnAdd);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(40, 118, 900, 525);
		add(panel);
		
		CustomerController controller = new CustomerController(panel, jtfSearch, btnAdd);
		controller.setDataToTable();
	}
}
