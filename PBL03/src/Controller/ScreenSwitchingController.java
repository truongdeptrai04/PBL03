package Controller;

import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import Bean.OptionBean;
import View.EmployeeJPanel;
import View.CustomerJPanel;
import View.DiscountJPanel;
import View.InvoiceJPanel;
import View.ProductJPanel;
import View.SaleJPanel;
import View.StatisticJPanel;

public class ScreenSwitchingController {
	private JPanel root;
	private String kindSelected = "";
	private ArrayList<OptionBean> listItem = null;
	
	public ScreenSwitchingController(JPanel JPRoot) {
		this.root = JPRoot;
	}
	public void setView(JButton jbItem) {
		kindSelected = "Product";
		jbItem.setBackground(new Color(218, 238 ,245));
		jbItem.setForeground(new Color(0, 0, 0));
		
		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(new ProductJPanel());
		root.validate();
		root.repaint();
	}
	public void setEvent(ArrayList<OptionBean> listItem) {
		this.listItem = listItem;
		for(OptionBean item : listItem) {
			item.getJb().addMouseListener(new LabelEvent(item.getJb(), item.getKind()));
		}
	}
	class LabelEvent implements MouseListener{
		private JPanel node;
		private JButton jbItem;
		private String kind;
		
		public LabelEvent(JButton jbItem, String kind) {
			super();
			this.kind = kind;
			this.jbItem = jbItem;
		}

		
		@Override
		public void mousePressed(MouseEvent e) {
			switch(kind) {
				case "Product":
					node = new ProductJPanel();
					break;
				case "Invoice":
					node = new InvoiceJPanel();
					break;
				case "Sale":
					node = new SaleJPanel();
					break;
				case "Discount":
					node = new DiscountJPanel();
					break;
				case "Account":
					node = new EmployeeJPanel();
					break;
				case "Customer":
					node = new CustomerJPanel();
					break;
				case "Statistic":
					node = new StatisticJPanel();
					break;
				default:
					node = new ProductJPanel();
						break;
			}
			root.removeAll();
			root.setLayout(new BorderLayout());
			root.add(node);
			root.validate();
			root.repaint();
			setChangeBackground(kind);	
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			kindSelected = kind;
			jbItem.setBackground(new Color(218, 238 ,245));
			jbItem.setForeground(new Color(0, 0, 0));
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbItem.setBackground(new Color(218, 238 ,245));
			jbItem.setForeground(new Color(0, 0, 0));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(!kindSelected.equalsIgnoreCase(kind)) {
				jbItem.setBackground(new Color(255, 255, 254));
				jbItem.setForeground(new Color(0, 0, 0));
			}
		}
		private void setChangeBackground(String kind) {
			for(OptionBean item : listItem) {
				if(item.getKind().equalsIgnoreCase(kind)) {
					item.getJb().setBackground(new Color(218, 238 ,245));
					item.getJb().setForeground(new Color(0, 0, 0));
				}else {
					item.getJb().setBackground(new Color(255, 255, 254));
					item.getJb().setForeground(new Color(0, 0, 0));
				}
			}
		}
	}
}
