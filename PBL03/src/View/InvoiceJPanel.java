package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class InvoiceJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jpnView;

	/**
	 * Create the panel.
	 */
	public InvoiceJPanel() {
		this.setBounds(0, 0, 982, 724);	
		setBackground(new Color(243, 249, 251));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 118, 900, 433);
		add(panel);
		
		jpnView = new JTextField();
		jpnView.setBounds(135, 41, 209, 36);
		add(jpnView);
		jpnView.setColumns(10);
		
		JLabel jlbSearch = new JLabel("Search:");
		jlbSearch.setFont(new Font("Tahoma", Font.PLAIN, 21));
		jlbSearch.setBounds(40, 41, 95, 36);
		add(jlbSearch);
		
		JLabel jlbNote = new JLabel("(*): Invoice ID");
		jlbNote.setFont(new Font("Tahoma", Font.ITALIC, 11));
		jlbNote.setForeground(new Color(255, 0, 0));
		jlbNote.setBounds(354, 49, 80, 20);
		add(jlbNote);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(625, 46, 113, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(788, 48, 104, 20);
		add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Invoice quantity:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(40, 573, 120, 25);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("12");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(170, 573, 59, 25);
		add(lblNewLabel_1);

	}
}
