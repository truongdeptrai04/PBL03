package Model;

public class Customer {
	private String CustomerID;
	private String phoneNumber;
	private String name;
	private String address;
	private int turnover;
	private MembershipCard card;
	public Customer() {
		card = new MembershipCard();
	}
	public Customer(String CustomerID, String phoneNumber, String name, String address, int turnover) {
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.address = address;
		this.turnover = turnover;
		this.CustomerID = CustomerID;
	}
	public void setID(String id) {
		this.CustomerID = id;
		}
	public String getID() {
		return this.CustomerID;
	}
    public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    public int getTurnover() {
		return turnover;
	}
	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}
	public Customer(String name, String phoneNumber, boolean isVip) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public String getName() {
    	return this.name;
    }
    public void setPhoneNumber(String phoneNumber) {
    	this.phoneNumber = phoneNumber;
    }
	public String getPhoneNumber() {
    	return this.phoneNumber;
    }
    public MembershipCard getCard() {
		return this.card;
	}
	public void setCard(MembershipCard card) {
		this.card = card;
	}
}