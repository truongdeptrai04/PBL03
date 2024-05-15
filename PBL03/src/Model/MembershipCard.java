package Model;

public class MembershipCard {
    private String cardID;
    private Discount discount;
    private Brand brand;
    private String rank;
    public MembershipCard() {
    	brand = new Brand();
    	discount = new Discount();
    }
    public MembershipCard(String CardID, Discount discount, Brand brand, String rank) {
    	this.cardID = CardID;
    	this.discount = discount;
    	this.brand = brand;
    	this.rank = rank;	
    }
    
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
    
}
