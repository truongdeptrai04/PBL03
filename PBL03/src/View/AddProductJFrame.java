package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class AddProductJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProductJFrame frame = new AddProductJFrame();
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
	public AddProductJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(25, 11, 750, 280);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(430, 40, 200, 36);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setBounds(430, 120, 200, 36);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(new Color(255, 255, 255));
		comboBox_2.setBounds(430, 200, 70, 36);
		panel.add(comboBox_2);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBorder(new LineBorder(new Color(71, 150, 189), 2, true));
		btnNewButton_1.setBounds(650, 120, 36, 36);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(new LineBorder(new Color(71, 150, 189), 2, true));
		btnNewButton.setBounds(650, 40, 36, 36);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(59, 120, 200, 36);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(59, 40, 250, 36);
		panel.add(textField_1);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setFocusPainted(false);
		btnNewButton_1_1.setBorder(new LineBorder(new Color(71, 150, 189), 2, true));
		btnNewButton_1_1.setBounds(520, 200, 36, 36);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_3 = new JButton("SAVE");
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setBorder(new LineBorder(new Color(71, 150, 189), 2, true));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.setBounds(59, 200, 110, 40);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Product Name:");
		lblNewLabel.setBounds(59, 13, 100, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Price:");
		lblNewLabel_1.setBounds(59, 93, 100, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product Type:");
		lblNewLabel_2.setBounds(430, 13, 100, 25);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Color:");
		lblNewLabel_3.setBounds(430, 93, 100, 25);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Size:");
		lblNewLabel_4.setBounds(430, 173, 100, 25);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton_5 = new JButton("DELETE");
		btnNewButton_5.setFocusPainted(false);
		btnNewButton_5.setBorder(new LineBorder(new Color(71, 150, 189), 2, true));
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.setBounds(680, 316, 95, 35);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("CANCEL");
		btnNewButton_6.setFocusPainted(false);
		btnNewButton_6.setBorder(new LineBorder(new Color(71, 150, 189), 2, true));
		btnNewButton_6.setBackground(new Color(255, 255, 255));
		btnNewButton_6.setBounds(680, 539, 95, 35);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_5_1 = new JButton("COMPLETE");
		btnNewButton_5_1.setFocusPainted(false);
		btnNewButton_5_1.setBorder(new LineBorder(new Color(71, 150, 189), 2, true));
		btnNewButton_5_1.setBackground(new Color(255, 255, 255));
		btnNewButton_5_1.setBounds(680, 365, 95, 35);
		contentPane.add(btnNewButton_5_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 310, 640, 270);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 640, 270);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Product Name", "Product Type", "Size", "Color", "Price"
			}
		));
		scrollPane.setViewportView(table);
	}
}
