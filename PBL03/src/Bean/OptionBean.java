package Bean;

import javax.swing.*;

public class OptionBean {
	private String kind;
	private JButton jb;
	public OptionBean() {
		
	}
	public JButton getJb() {
		return jb;
	}
	public void setJb(JButton jb) {
		this.jb = jb;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}

	public OptionBean(String kind, JButton jb) {
		super();
		this.kind = kind;
		this.jb = jb;
	}
}
