package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import Model.Customer;
import Service.CustomerService;
import Service.CustomerServiceImpl;

public class CustomerUpdateController {
	private JButton btnSave;
	private JTextField jtfCusName, jtfCusPhoneNumber, jtfCusAddress, jtfCusRank, jtfCusTurnover;
	private JPanel jpnView;
	private JLabel jlbCusID;
	
	private Customer customer = null;
	private CustomerService customerService = null;
	
	public CustomerUpdateController(JFrame jframe, JButton btnSave, JTextField jtfCusName, JTextField jtfCusPhoneNumber,
			JTextField jtfCusAddress, JTextField jtfCusRank, JTextField jtfCusTurnover, JPanel jpnView, JLabel jlbCusID) {
		super();
		this.btnSave = btnSave;
		this.jtfCusName = jtfCusName;
		this.jtfCusPhoneNumber = jtfCusPhoneNumber;
		this.jtfCusAddress = jtfCusAddress;
		this.jtfCusRank = jtfCusRank;
		this.jtfCusTurnover = jtfCusTurnover;
		this.jpnView = jpnView;
		this.jlbCusID = jlbCusID;
		this.customerService = new CustomerServiceImpl();
	}
	
	public void setView(Customer customer) {
        this.customer = customer;
        // set data
        jlbCusID.setText(customer.getID());
        jtfCusName.setText(customer.getName());
        jtfCusPhoneNumber.setText(customer.getPhoneNumber());
        jtfCusAddress.setText(customer.getAddress());
        jtfCusRank.setText(customer.getCard().getRank());
        jtfCusTurnover.setText(("" + customer.getTurnover()));
        // set event
        setEvent();
    }

    public void setEvent() {
        btnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (!checkNotNull()) {
                        System.out.println("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                        customer.setName(jtfCusName.getText().trim());
                        customer.setPhoneNumber(jtfCusPhoneNumber.getText().trim());
                        customer.setAddress(jtfCusAddress.getText().trim());
                        customer.getCard().setRank(jtfCusRank.getText().trim());

                        if (showDialog()) {
                            customerService.createOrUpdate(customer);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    private boolean checkNotNull() {
        return jtfCusName.getText() != null && !jtfCusName.getText().equalsIgnoreCase("");
    }

    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
    
}
