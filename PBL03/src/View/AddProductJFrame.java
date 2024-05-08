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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import Controller.addProductController;

import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class AddProductJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfPrice;
	private JTextField jtfProductName;
	private JTextField jtfProductType;
	private JTextField jtfColor;
	private JTextField jtfSize;
	private JPanel panel, jpnView;
	private final String[] COLUMNS = {"Product Name", "Produce Type", "Color",
	        "Size", "Price"};
	/**
	 * Launch the application.
	 */

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
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(25, 11, 750, 298);
		contentPane.add(panel);
		panel.setLayout(null);
		
		jtfPrice = new JTextField();
		jtfPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfPrice.setColumns(10);
		jtfPrice.setBounds(59, 120, 200, 36);
		panel.add(jtfPrice);
		
		jtfProductName = new JTextField();
		jtfProductName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfProductName.setColumns(10);
		jtfProductName.setBounds(59, 40, 250, 36);
		panel.add(jtfProductName);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setFocusPainted(false);
		btnSave.setBorder(new LineBorder(new Color(71, 150, 189), 2, true));
		btnSave.setBackground(new Color(255, 255, 255));
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(59, 200, 110, 40);
		panel.add(btnSave);
		
		JLabel lblNewLabel = new JLabel("Product Name:");
		lblNewLabel.setBounds(59, 13, 100, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Price:");
		lblNewLabel_1.setBounds(59, 93, 100, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product Type:");
		lblNewLabel_2.setBounds(450, 13, 100, 25);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Color:");
		lblNewLabel_3.setBounds(450, 93, 100, 25);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Size:");
		lblNewLabel_4.setBounds(450, 173, 100, 25);
		panel.add(lblNewLabel_4);
		
		jtfProductType = new JTextField();
		jtfProductType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfProductType.setBounds(450, 40, 200, 36);
		panel.add(jtfProductType);
		jtfProductType.setColumns(10);
		
		jtfColor = new JTextField();
		jtfColor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfColor.setColumns(10);
		jtfColor.setBounds(450, 120, 200, 36);
		panel.add(jtfColor);
		
		jtfSize = new JTextField();
		jtfSize.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfSize.setBounds(450, 200, 110, 36);
		panel.add(jtfSize);
		jtfSize.setColumns(10);
		
		JLabel lblNewLabel_5_2 = new JLabel("(*)");
		lblNewLabel_5_2.setForeground(Color.RED);
		lblNewLabel_5_2.setBounds(660, 48, 20, 20);
		panel.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("(*)");
		lblNewLabel_5_3.setForeground(Color.RED);
		lblNewLabel_5_3.setBounds(660, 128, 20, 20);
		panel.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_4 = new JLabel("(*)");
		lblNewLabel_5_4.setForeground(Color.RED);
		lblNewLabel_5_4.setBounds(570, 208, 20, 20);
		panel.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5 = new JLabel("(*)");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBounds(319, 48, 20, 20);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("(*)");
		lblNewLabel_5_1.setForeground(Color.RED);
		lblNewLabel_5_1.setBounds(269, 128, 20, 20);
		panel.add(lblNewLabel_5_1);
		
		JLabel jlbMessage = new JLabel("(*): Require data");
		jlbMessage.setForeground(new Color(255, 0, 0));
		jlbMessage.setFont(new Font("Tahoma", Font.ITALIC, 11));
		jlbMessage.setBounds(59, 255, 500, 14);
		panel.add(jlbMessage);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFocusPainted(false);
		btnDelete.setBorder(new LineBorder(new Color(71, 150, 189), 2, true));
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setBounds(680, 316, 95, 35);
		contentPane.add(btnDelete);
		
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setFocusPainted(false);
		btnCancel.setBorder(new LineBorder(new Color(71, 150, 189), 2, true));
		btnCancel.setBackground(new Color(255, 255, 255));
		btnCancel.setBounds(680, 539, 95, 35);
		contentPane.add(btnCancel);
//		btnCancel.addActionListener(new ActionListener() {
//		    public void actionPerformed(ActionEvent e) {
//		        dispose();
//		    }
//		});
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFocusPainted(false);
		btnSubmit.setBorder(new LineBorder(new Color(71, 150, 189), 2, true));
		btnSubmit.setBackground(new Color(255, 255, 255));
		btnSubmit.setBounds(680, 365, 95, 35);
		contentPane.add(btnSubmit);
		
		jpnView = new JPanel();
		jpnView.setBounds(25, 310, 640, 270);
		contentPane.add(jpnView);
		jpnView.setLayout(null);

		
		addProductController controller = new addProductController(this, jtfProductName, jtfProductType, jtfColor, jtfSize, jtfPrice, btnSave, btnDelete, btnSubmit, btnCancel, jlbMessage, jpnView);
	}
}
