package Model;

public class Product {
	private String ID;
	private String type;
	private String discountID;
	private String name;
	private double price;
	private int quantity;
	private String color;
	private String size;
	private static int IDCounter = 1;
	
    public Product() {
	}
	public Product(String ID, String name, String type,  String color, double price, int quantity, String size, String discountID) {
    	this.ID = ID;
        this.type = type;
        this.discountID = discountID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.size = size;	
    }
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDiscount() {
		return discountID;
	}
	public void setDiscount(String discountID) {
		this.discountID = discountID;
	}
    public String getID() {
		return ID;
	}
	public void setID(String iD) {
		this.ID = iD;
	}
    public void setName(String name) {
    	this.name = name;
    }
    public String getName() {
    	return this.name;
    }
    public void setPrice(double price) {
    	this.price = price;
    }
    public double getPrice() {
    	return this.price;
    }
    public void setQuantity(int quantity) {
    	this.quantity = quantity;
    }
    public int getQuantity() {
    	return this.quantity;
    }
    public void setColor(String color) {
    	this.color = color;
    }
    public String getColor() {
    	return this.color;
    }
    public void setSize(String size) {
    	this.size = size;
    }
    public String getSize() {
    	return this.size;
    }
}
