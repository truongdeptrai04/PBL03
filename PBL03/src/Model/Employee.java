package Model;

public class Employee {
    private String ID;
    private Store store;
    private String name;
    private Account account;
    private String email;
    private String phoneNumber;
	private String address;
	private String position;
    private static int employeeCount = 1;
    public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Employee() {
    	store = new Store();
    	account = new Account();
    }
    public Employee(Store store, String name, String nickName, String pass, String email, String address) {
    	this.ID = "EP";
    	String IDcounter = String.format("%04d", employeeCount);
    	ID += IDcounter;	
    	employeeCount++;
    	this.store = store;
    	this.name = name;
    	this.email = email;
    	this.address = address;
    }
    public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    public Account getAccount() {
    	return account;
    }
    public void setAccount(Account account) {
    	this.account = account;
    }
    public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPass(String pass) {
		pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
