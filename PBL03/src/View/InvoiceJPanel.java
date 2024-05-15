package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

import Controller.InvoiceController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class InvoiceJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfSearch;

	/**
	 * Create the panel.
	 */
	public InvoiceJPanel() {
		this.setBounds(0, 0, 982, 724);	
		setBackground(new Color(243, 249, 251));
		setLayout(null);
		
		JPanel jpnView = new JPanel();
		jpnView.setBackground(new Color(255, 255, 255));
		jpnView.setBounds(40, 118, 900, 433);
		add(jpnView);
		
		jtfSearch = new JTextField();
		jtfSearch.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		jtfSearch.setBackground(new Color(243, 249, 251));
		jtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfSearch.setBounds(125, 41, 209, 36);
		add(jtfSearch);
		jtfSearch.setColumns(10);
		
		JLabel jlbSearch = new JLabel("Search:");
		jlbSearch.setFont(new Font("Tahoma", Font.PLAIN, 21));
		jlbSearch.setBounds(40, 41, 95, 36);
		add(jlbSearch);
		
		JLabel jlbNote = new JLabel("(*): Invoice ID");
		jlbNote.setFont(new Font("Tahoma", Font.ITALIC, 13));
		jlbNote.setForeground(new Color(255, 0, 0));
		jlbNote.setBounds(344, 49, 120, 20);
		add(jlbNote);
		
		JLabel lblNewLabel = new JLabel("Invoice quantity:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(40, 573, 120, 25);
		add(lblNewLabel);
		
		JLabel jlbInvoiceQuantity = new JLabel("");
		jlbInvoiceQuantity.setFont(new Font("Tahoma", Font.BOLD, 17));
		jlbInvoiceQuantity.setBounds(163, 573, 59, 25);
		add(jlbInvoiceQuantity);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotal.setBounds(314, 573, 45, 25);
		add(lblTotal);
		
		JLabel jlbTotal = new JLabel("");
		jlbTotal.setFont(new Font("Tahoma", Font.BOLD, 17));
		jlbTotal.setBounds(360, 573, 150, 25);
		add(jlbTotal);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBorder(new LineBorder(new Color(71, 150, 189), 1, true));
		btnDelete.setFocusPainted(false);
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setForeground(new Color(255, 0, 0));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(785, 567, 120, 40);
		add(btnDelete);
		
		Choice cFilter = new Choice();
//		cFilter.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		cFilter.setBounds(625, 45, 0, 0);
//		cFilter.add("ALL");
//		cFilter.add("Today");
//		cFilter.add("This Week");
//		cFilter.add("This Month");
//		cFilter.add("This Year");
		
		add(cFilter);
		
		JLabel lblNewLabel_2 = new JLabel("Filter");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(560, 45, 0, 0);
		add(lblNewLabel_2);
		
		InvoiceController controller = new InvoiceController(jlbInvoiceQuantity, jlbTotal, cFilter, jtfSearch, btnDelete, jpnView);
		controller.setDataToTable();
	}
}
