
public class Product {

	private final long code;
	private final String name;
	private final Price price;
	
	public Product(long code, String name, Price price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}
	
	public long getCode() {
		return this.code;
	}
		
	public String getName() {
		return this.name;
	}
	
	public Price getPrice() {
		return this.price;
	}
}
