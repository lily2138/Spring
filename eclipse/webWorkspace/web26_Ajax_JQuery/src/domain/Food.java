package domain;

public class Food {
	private String maker;
	private int price;
	
	public Food(String maker, int price) {
		super();
		this.maker = maker;
		this.price = price;
	}
	
	public Food() {}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Food [maker=" + maker + ", price=" + price + "]";
	}
	
	
}
