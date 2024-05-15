package Model;

public class Account {
	private String accountID;
	private String username;
	private String password;
	
	public Account() {
		
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Account(String accountID, String username, String password) {
		super();
		this.accountID = accountID;
		this.username = username;
		this.password = password;
	}
	
}
